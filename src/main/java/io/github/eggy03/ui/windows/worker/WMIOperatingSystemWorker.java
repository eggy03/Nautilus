/*
 * SPDX-License-Identifier: GPL-3.0-or-later
 * Copyright (C) 2026 Egg-03
 */
package io.github.eggy03.ui.windows.worker;

import io.github.eggy03.cimari.entity.system.Win32OperatingSystem;
import io.github.eggy03.cimari.service.system.Win32OperatingSystemService;
import io.github.eggy03.ui.common.constant.TerminalConstant;
import io.github.eggy03.ui.windows.utilities.WMIBooleanUtility;
import io.github.eggy03.ui.windows.utilities.WMIDateUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Slf4j
public class WMIOperatingSystemWorker extends SwingWorker<List<Win32OperatingSystem>, Void> {

    private final JComboBox<String> osNameComboBox;
    private final List<JTextField> osFields;
    private final JTextArea osConciseInfoArea;

    @Override
    protected List<Win32OperatingSystem> doInBackground() {
        return new Win32OperatingSystemService().get(TerminalConstant.TIMEOUT_SIXTY_SECONDS);
    }

    @Override
    protected void done() {
        try {
            List<Win32OperatingSystem> osList = get();
            if(osList.isEmpty()) {
                log.info("No entries for Win32OperatingSystem were found");
                return;
            }
            log.info("Found {} Win32OperatingSystem entry/entries", osList.size());

            // fill the combo box with os names
            osList.forEach(os -> osNameComboBox.addItem(os.name()));
            // populate fields for the first entry in the combo box
            populateFields(osList);
            // add a listener to the combo box to re-populate fields on new selection
            osNameComboBox.addActionListener(selectEvent-> populateFields(osList));

        } catch (InterruptedException e) {
            log.error("OS Fetch Interrupted", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error("OS Fetch Failed", e);
        }
    }

    private void populateFields(List<Win32OperatingSystem> osList) {

        String osName = String.valueOf(osNameComboBox.getSelectedItem());

        Optional<Win32OperatingSystem> optionalOs = osList
                .stream()
                .filter(Objects::nonNull)
                .filter(os-> Objects.equals(os.name(), osName))
                .findFirst();

        if(optionalOs.isEmpty())
            return;

        Win32OperatingSystem os = optionalOs.get();

        osFields.get(0).setText(os.caption());
        osFields.get(1).setText(os.version());
        osFields.get(2).setText(os.buildNumber());
        osFields.get(3).setText(os.manufacturer());
        osFields.get(4).setText(os.osArchitecture());
        osFields.get(5).setText(WMIDateUtility.toLocalDateTime(os.installDate()));
        osFields.get(6).setText(WMIDateUtility.toLocalDateTime(os.lastBootUpTime()));
        osFields.get(7).setText(os.serialNumber());
        osFields.get(8).setText(os.muiLanguages()==null ? "N/A" : os.muiLanguages().toString());
        osFields.get(9).setText(WMIBooleanUtility.resolveBoolean(os.primary()));
        osFields.get(10).setText(WMIBooleanUtility.resolveBoolean(os.distributed()));
        osFields.get(11).setText(WMIBooleanUtility.resolveBoolean(os.portableOperatingSystem()));
        osFields.get(12).setText(os.csName());
        osFields.get(13).setText(String.valueOf(os.numberOfUsers()));
        osFields.get(14).setText(os.registeredUser());
        osFields.get(15).setText(os.systemDrive());
        osFields.get(16).setText(os.windowsDirectory());
        osFields.get(17).setText(os.systemDirectory());

        String conciseOsText = os.osArchitecture() + " edition of Windows" +
                System.lineSeparator() +
                "Version: " + os.version() +
                System.lineSeparator() +
                "Installed on: " + WMIDateUtility.toLocalDateTime(os.installDate()) +
                System.lineSeparator() +
                "Last started on: " + WMIDateUtility.toLocalDateTime(os.lastBootUpTime()) +
                System.lineSeparator() +
                "Registered to: " + os.registeredUser();

        osConciseInfoArea.setText(conciseOsText);
    }
}
