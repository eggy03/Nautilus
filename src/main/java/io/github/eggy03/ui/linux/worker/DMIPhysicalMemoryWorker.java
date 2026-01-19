package io.github.eggy03.ui.linux.worker;

import io.github.eggy03.dmidecode.entity.memory.DMIMemoryDevice;
import io.github.eggy03.dmidecode.service.memory.DMIMemoryDeviceService;
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
        return new DMIMemoryDeviceService().get(15);
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
            dmiMemoryDeviceList.forEach(memory -> memorySlotComboBox.addItem(memory.getLocator()));
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
                .filter(memory -> memory.getLocator()!=null && memory.getLocator().equals(locator))
                .findFirst();

        if(optionalDMIMemoryDevice.isEmpty())
            return;

        DMIMemoryDevice memory = optionalDMIMemoryDevice.get();

        memoryFields.get(0).setText(memory.getSet());
        memoryFields.get(1).setText(memory.getAssetTag());
        memoryFields.get(2).setText(memory.getSerialNumber());
        memoryFields.get(3).setText(memory.getPartNumber());
        memoryFields.get(4).setText(memory.getFirmwareVersion());
        memoryFields.get(5).setText(memory.getLocator());
        memoryFields.get(6).setText(memory.getBankLocator());
        memoryFields.get(7).setText(memory.getFormFactor());
        memoryFields.get(8).setText(memory.getType());
        memoryFields.get(9).setText(memory.getTypeDetail());
        memoryFields.get(10).setText(String.valueOf(memory.getRank()));
        memoryFields.get(11).setText(memory.getSize());
        memoryFields.get(12).setText(memory.getDataWidth());
        memoryFields.get(13).setText(memory.getTotalWidth());
        memoryFields.get(14).setText(memory.getVolatileSize());
        memoryFields.get(15).setText(memory.getNonVolatileSize());
        memoryFields.get(16).setText(memory.getCacheSize());
        memoryFields.get(17).setText(memory.getLogicalSize());
        memoryFields.get(18).setText(memory.getSpeed());
        memoryFields.get(19).setText(memory.getConfiguredMemorySpeed());
        memoryFields.get(20).setText(memory.getMinimumVoltage());
        memoryFields.get(21).setText(memory.getMaximumVoltage());
        memoryFields.get(22).setText(memory.getConfiguredVoltage());
        memoryFields.get(23).setText(memory.getManufacturer());
        memoryFields.get(24).setText(memory.getModuleManufacturerId());
        memoryFields.get(25).setText(memory.getModuleProductId());
        memoryFields.get(26).setText(memory.getMemorySubsystemControllerManufacturerId());
        memoryFields.get(27).setText(memory.getMemorySubsystemControllerProductId());
        memoryFields.get(28).setText(memory.getMemoryTechnology());
        memoryFields.get(29).setText(memory.getMemoryOperatingModeCapability());
        memoryFields.get(30).setText(memory.getArrayHandle());
        memoryFields.get(31).setText(memory.getErrorInformationHandle());
    }
}
