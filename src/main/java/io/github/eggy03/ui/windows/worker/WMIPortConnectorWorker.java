/*
 * SPDX-License-Identifier: GPL-3.0-or-later
 * Copyright (C) 2026 Egg-03
 */
package io.github.eggy03.ui.windows.worker;

import io.github.eggy03.cimari.entity.mainboard.Win32PortConnector;
import io.github.eggy03.cimari.service.mainboard.Win32PortConnectorService;
import io.github.eggy03.ui.common.constant.TerminalConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import static io.github.eggy03.ui.windows.constant.WMIConstants.resolveWMIPortType;

@Slf4j
@RequiredArgsConstructor
public class WMIPortConnectorWorker extends SwingWorker<List<Win32PortConnector>, Void> {

    private final JComboBox<String> tagComboBox;
    private final List<JTextField> portFields;

    @Override
    protected List<Win32PortConnector> doInBackground() {
        return new Win32PortConnectorService().get(TerminalConstant.TIMEOUT_SIXTY_SECONDS);
    }

    @Override
    protected void done() {

        try {
            List<Win32PortConnector> portList = get();
            if(portList.isEmpty()) {
                log.info("No entries for Win32PortConnector were found");
                return;
            }
            log.info("Found {} Win32PortConnector entry/entries", portList.size());

            //fill the combo box with port connector tags
            portList.forEach(port-> tagComboBox.addItem(port.tag()));
            // populate fields for the first entry in the combo box
            populatePortConnectorFields(portList);
            // add a listener to the combo box to re-populate fields on new selection
            tagComboBox.addActionListener(selectEvent -> populatePortConnectorFields(portList));

        } catch (InterruptedException e) {
            log.error("Baseboard Port Fetch Interrupted", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error("Baseboard Port Fetch Failed", e);
        }

    }

    private void populatePortConnectorFields(List<Win32PortConnector> portList) {

        String selectedTag = String.valueOf(tagComboBox.getSelectedItem());

        Optional<Win32PortConnector> selectedPort = portList
                .stream()
                .filter(Objects::nonNull)
                .filter(port -> Objects.equals(port.tag(), selectedTag))
                .findFirst();

        if(selectedPort.isEmpty())
            return;

        Win32PortConnector port = selectedPort.get();
        portFields.get(0).setText(resolveWMIPortType(port.portType()));
        portFields.get(1).setText(port.internalReferenceDesignator());
        portFields.get(2).setText(port.externalReferenceDesignator());
    }
}
