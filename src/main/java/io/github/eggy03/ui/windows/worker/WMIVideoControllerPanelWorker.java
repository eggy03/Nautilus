/*
 * SPDX-License-Identifier: GPL-3.0-or-later
 * Copyright (C) 2026 Egg-03
 */
package io.github.eggy03.ui.windows.worker;

import io.github.eggy03.cimari.entity.display.Win32VideoController;
import io.github.eggy03.cimari.service.display.Win32VideoControllerService;
import io.github.eggy03.ui.common.constant.TerminalConstant;
import io.github.eggy03.ui.windows.utilities.WMIDateUtility;
import io.github.eggy03.ui.windows.utilities.WMISizeUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Slf4j
@RequiredArgsConstructor
public class WMIVideoControllerPanelWorker extends SwingWorker<List<Win32VideoController>, Void> {

    private final JComboBox<String> gpuDeviceIdComboBox;
    private final List<JTextField> gpuFields;

    @Override
    protected List<Win32VideoController> doInBackground() {
        return new Win32VideoControllerService().get(TerminalConstant.TIMEOUT_SIXTY_SECONDS);
    }

    @Override
    protected void done() {
        try {
            List<Win32VideoController> videoControllerList = get();
            if (videoControllerList.isEmpty()) {
                log.info("No entries for Win32VideoController were found");
                return;
            }
            log.info("Found {} Win32VideoController entry/entries", videoControllerList.size());

            // fill video controller IDs in the combo box
            videoControllerList.forEach(v -> gpuDeviceIdComboBox.addItem(v.deviceId()));
            // populate fields for the first entry in the combo box
            populateFields(videoControllerList);
            // add a listener to the combo box to re-populate fields on new selection
            gpuDeviceIdComboBox.addActionListener(selectEvent -> populateFields(videoControllerList));

        } catch (InterruptedException e) {
            log.error("Video Controller Fetch Interrupted", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error("Video Controller Fetch Failed", e);
        }
    }

    private void populateFields(List<Win32VideoController> videoControllerList) {

        String gpuDeviceId = String.valueOf(gpuDeviceIdComboBox.getSelectedItem());
        Optional<Win32VideoController> optionalGpu = videoControllerList
                .stream()
                .filter(Objects::nonNull)
                .filter(v -> Objects.equals(v.deviceId(), gpuDeviceId))
                .findFirst();

        if (optionalGpu.isEmpty())
            return;

        Win32VideoController gpu = optionalGpu.get();
        gpuFields.get(0).setText(gpu.name());
        gpuFields.get(1).setText(gpu.pnpDeviceId());
        gpuFields.get(2).setText(gpu.currentHorizontalResolution() + " px");
        gpuFields.get(3).setText(gpu.currentVerticalResolution() + " px");
        gpuFields.get(4).setText(gpu.currentBitsPerPixel() + " bit");
        gpuFields.get(5).setText(gpu.minRefreshRate() + " Hz");
        gpuFields.get(6).setText(gpu.maxRefreshRate() + " Hz");
        gpuFields.get(7).setText(gpu.currentRefreshRate() + " Hz");
        gpuFields.get(8).setText(gpu.adapterDacType());
        gpuFields.get(9).setText(WMISizeUtility.parseToGBString(gpu.adapterRam()));
        gpuFields.get(10).setText(gpu.driverVersion());
        gpuFields.get(11).setText(WMIDateUtility.toLocalDateTime(gpu.driverDate()));
        gpuFields.get(12).setText(gpu.videoProcessor());
    }
}
