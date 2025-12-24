package io.github.eggy03.ui.windows.worker;

import io.github.eggy03.ferrumx.windows.entity.memory.Win32PhysicalMemory;
import io.github.eggy03.ferrumx.windows.service.memory.Win32PhysicalMemoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import static io.github.eggy03.ui.windows.constant.WMIConstants.resolveWMIPhysicalMemoryFormFactor;

@RequiredArgsConstructor
@Slf4j
public class WinPhysicalMemoryPanelWorker extends SwingWorker<List<Win32PhysicalMemory>, Void> {

    private final JComboBox<String> memoryTagComboBox;
    private final List<JTextField> memoryFields;

    @Override
    protected List<Win32PhysicalMemory> doInBackground() {
        return new Win32PhysicalMemoryService().get(15L);
    }

    @Override
    protected void done() {
        try {
            List<Win32PhysicalMemory> physicalMemoryList = get();

            if(physicalMemoryList.isEmpty()) {
                log.info("No entries for Win32PhysicalMemory were found");
                return;
            }
            log.info("Found {} Win32PhysicalMemory entry/entries", physicalMemoryList.size());

            // fill the combo box with memory tags
            physicalMemoryList.forEach(memory -> memoryTagComboBox.addItem(memory.getTag()));
            // populate fields for the first entry in the combo box
            populateMemoryFields(physicalMemoryList);
            // add a listener to the combo box to re-populate fields on new selection
            memoryTagComboBox.addActionListener(selectEvent-> populateMemoryFields(physicalMemoryList));

        } catch (ExecutionException e) {
            log.error("Memory Fetch Failed", e);
        } catch (InterruptedException e) {
            log.error("Memory Fetch Interrupted", e);
            Thread.currentThread().interrupt();
        }
    }


    private void populateMemoryFields(List<Win32PhysicalMemory> physicalMemoryList) {

        // get the current selected item in the combo box
        String memoryTag = String.valueOf(memoryTagComboBox.getSelectedItem());

        // from the memory list, filter the memory module based on the selected tag
        Optional<Win32PhysicalMemory> selectedMemory = physicalMemoryList
                .stream()
                .filter(memory ->  memory.getTag()!=null && memory.getTag().equals(memoryTag))
                .findFirst(); // tag is a unique ID, and it will always return at most 1 Win32PhysicalMemory object

        if (selectedMemory.isEmpty())
            return;

        Win32PhysicalMemory memory = selectedMemory.get();

        // populate the fields
        memoryFields.get(0).setText(memory.getName());
        memoryFields.get(1).setText(memory.getManufacturer());
        memoryFields.get(2).setText(memory.getModel());
        memoryFields.get(3).setText(memory.getOtherIdentifyingInfo());
        memoryFields.get(4).setText(memory.getPartNumber());
        memoryFields.get(5).setText(memory.getSerialNumber());
        memoryFields.get(6).setText(resolveWMIPhysicalMemoryFormFactor(memory.getFormFactor()));
        memoryFields.get(7).setText(memory.getBankLabel());
        memoryFields.get(8).setText(memory.getCapacity()+" KB");
        memoryFields.get(9).setText(memory.getDataWidth()+ " Bits");
        memoryFields.get(10).setText(memory.getSpeed()+ " MHz");
        memoryFields.get(11).setText(memory.getConfiguredClockSpeed()+ " MHz");
        memoryFields.get(12).setText(memory.getDeviceLocator());

    }
}
