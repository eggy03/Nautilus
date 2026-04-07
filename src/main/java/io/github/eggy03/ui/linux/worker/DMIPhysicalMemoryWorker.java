/*
 * SPDX-License-Identifier: GPL-3.0-or-later
 * Copyright (C) 2026 Egg-03
 */
package io.github.eggy03.ui.linux.worker;

import io.github.eggy03.dmidecode.entity.memory.DMIMemoryDevice;
import io.github.eggy03.dmidecode.service.memory.DMIMemoryDeviceService;
import io.github.eggy03.ui.common.constant.TerminalConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Slf4j
public class DMIPhysicalMemoryWorker extends SwingWorker<List<DMIMemoryDevice>, Void> {
    
    private final JComboBox<String> memorySlotComboBox;
    private final List<JTextField> memoryFields;

    @Override
    protected List<DMIMemoryDevice> doInBackground() throws Exception {
        return new DMIMemoryDeviceService().get(TerminalConstant.TIMEOUT_SIXTY_SECONDS);
    }

    @Override
    protected void done() {

        try {
            List<DMIMemoryDevice> dmiMemoryDeviceList = get();
            if(dmiMemoryDeviceList.isEmpty()){
                log.info("No entries for DMIMemory were found");
                return;
            }
            log.info("Found {} DMIMemory entry/entries", dmiMemoryDeviceList.size());

            // populate the combo box with memory locator data
            dmiMemoryDeviceList.forEach(memory -> memorySlotComboBox.addItem(memory.locator()));
            // populate fields for the first entry in the combo box
            populateFieldsBasedOnMemory(dmiMemoryDeviceList);
            // add a listener to the combo box to re-populate fields on new selection
            memorySlotComboBox.addActionListener(selectEvent -> populateFieldsBasedOnMemory(dmiMemoryDeviceList));

        } catch (ExecutionException e) {
            log.error("Memory Fetch Failed", e);
        } catch (InterruptedException e) {
            log.error("Memory Fetch Interrupted", e);
            Thread.currentThread().interrupt();
        }

    }

    private void populateFieldsBasedOnMemory(List<DMIMemoryDevice> dmiMemoryDeviceList) {

        String locator = String.valueOf(memorySlotComboBox.getSelectedItem());

        Optional<DMIMemoryDevice> optionalDMIMemoryDevice = dmiMemoryDeviceList
                .stream()
                .filter(memory -> memory.locator()!=null && memory.locator().equals(locator))
                .findFirst();

        if(optionalDMIMemoryDevice.isEmpty())
            return;

        DMIMemoryDevice memory = optionalDMIMemoryDevice.get();

        memoryFields.get(0).setText(memory.set());
        memoryFields.get(1).setText(memory.assetTag());
        memoryFields.get(2).setText(memory.serialNumber());
        memoryFields.get(3).setText(memory.partNumber());
        memoryFields.get(4).setText(memory.firmwareVersion());
        memoryFields.get(5).setText(memory.locator());
        memoryFields.get(6).setText(memory.bankLocator());
        memoryFields.get(7).setText(memory.formFactor());
        memoryFields.get(8).setText(memory.type());
        memoryFields.get(9).setText(memory.typeDetail());
        memoryFields.get(10).setText(String.valueOf(memory.rank()));
        memoryFields.get(11).setText(memory.size());
        memoryFields.get(12).setText(memory.dataWidth());
        memoryFields.get(13).setText(memory.totalWidth());
        memoryFields.get(14).setText(memory.volatileSize());
        memoryFields.get(15).setText(memory.nonVolatileSize());
        memoryFields.get(16).setText(memory.cacheSize());
        memoryFields.get(17).setText(memory.logicalSize());
        memoryFields.get(18).setText(memory.speed());
        memoryFields.get(19).setText(memory.configuredMemorySpeed());
        memoryFields.get(20).setText(memory.minimumVoltage());
        memoryFields.get(21).setText(memory.maximumVoltage());
        memoryFields.get(22).setText(memory.configuredVoltage());
        memoryFields.get(23).setText(memory.manufacturer());
        memoryFields.get(24).setText(memory.moduleManufacturerId());
        memoryFields.get(25).setText(memory.moduleProductId());
        memoryFields.get(26).setText(memory.memorySubsystemControllerManufacturerId());
        memoryFields.get(27).setText(memory.memorySubsystemControllerProductId());
        memoryFields.get(28).setText(memory.memoryTechnology());
        memoryFields.get(29).setText(memory.memoryOperatingModeCapability());
        memoryFields.get(30).setText(memory.arrayHandle());
        memoryFields.get(31).setText(memory.errorInformationHandle());
    }
}
