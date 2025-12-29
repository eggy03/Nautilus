package io.github.eggy03.ui.windows.worker;

import io.github.eggy03.ferrumx.windows.entity.compounded.Win32ProcessorToCacheMemory;
import io.github.eggy03.ferrumx.windows.entity.processor.Win32CacheMemory;
import io.github.eggy03.ferrumx.windows.entity.processor.Win32Processor;
import io.github.eggy03.ferrumx.windows.service.compounded.Win32ProcessorToCacheMemoryService;
import io.github.eggy03.ui.common.utilities.IconImageChooser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static io.github.eggy03.ui.windows.constant.WMIConstants.resolveWMIAvailability;
import static io.github.eggy03.ui.windows.constant.WMIConstants.resolveWMICacheErrorCorrectType;
import static io.github.eggy03.ui.windows.constant.WMIConstants.resolveWMICacheMemoryAssociativity;
import static io.github.eggy03.ui.windows.constant.WMIConstants.resolveWMICacheMemoryLevel;
import static io.github.eggy03.ui.windows.constant.WMIConstants.resolveWMICacheMemoryLocation;
import static io.github.eggy03.ui.windows.constant.WMIConstants.resolveWMICacheMemoryType;

@RequiredArgsConstructor
@Slf4j
public class WMIProcessorPanelWorker extends SwingWorker<List<Win32ProcessorToCacheMemory>, Void> {

    private final JComboBox<String> cpuIdComboBox;
    private final List<JTextField> cpuFields;
    private final JTextArea cacheTextArea;
    private final JLabel cpuManufacturerLogoLabel;

    @Override
    protected @NotNull List<Win32ProcessorToCacheMemory> doInBackground() {
       return new Win32ProcessorToCacheMemoryService().get(15L);
    }

    @Override
    protected void done() {
        try {
            List<Win32ProcessorToCacheMemory> cpuAndCacheList = get();
            if(cpuAndCacheList.isEmpty()) {
                log.info("No entries for Win32Processor were found");
                return;
            }
            log.info("Found {} Win32Processor entry/entries", cpuAndCacheList.size());

            // populate the combo box with cpu device id
            cpuAndCacheList.forEach(cpuAndCache -> cpuIdComboBox.addItem(cpuAndCache.getDeviceId()));
            // populate fields for the first entry in the combo box
            populateFieldsBasedOnCurrentCpuId(cpuAndCacheList);
            // add a listener to the combo box to re-populate fields on new selection
            cpuIdComboBox.addActionListener(selectEvent -> populateFieldsBasedOnCurrentCpuId (cpuAndCacheList));
        } catch (ExecutionException e) {
            log.error("CPU Fetch Failed", e);
        } catch (InterruptedException e) {
            log.error("CPU Fetch Interrupted", e);
            Thread.currentThread().interrupt();
        }
    }

    // populate the fields based on the current cpu-id in the combo-box
    private void populateFieldsBasedOnCurrentCpuId (List<Win32ProcessorToCacheMemory> cpuAndCacheList) {
    	
    	// filter a cpuAndCacheObject based on the cpu id in the combo box
    	Optional<Win32ProcessorToCacheMemory> current = cpuAndCacheList.stream()
                .filter(cpuAndCache -> cpuAndCache.getDeviceId()!=null && cpuAndCache.getDeviceId().equals(cpuIdComboBox.getSelectedItem()))
                .findFirst();

        if (current.isEmpty())
            return;

        Win32ProcessorToCacheMemory currentCpuAndCache = current.get();
        Win32Processor currentCpu = currentCpuAndCache.getProcessor();
        List<Win32CacheMemory> currentCacheList = currentCpuAndCache.getCacheMemoryList();
        
        // populate cpu fields
        if(currentCpu!=null) { // the order is maintained by the order in which the text fields have been passed to its constructor
        	cpuFields.get(0).setText(String.valueOf(currentCpu.getNumberOfCores()));
        	cpuFields.get(1).setText(String.valueOf(currentCpu.getThreadCount()));
        	cpuFields.get(2).setText(currentCpu.getMaxClockSpeed()+" MHz");
        	cpuFields.get(3).setText(currentCpu.getName());
        	cpuFields.get(4).setText(currentCpu.getVersion());
        	cpuFields.get(5).setText(String.valueOf(currentCpu.getFamily()));
        	cpuFields.get(6).setText(currentCpu.getStepping());
        	cpuFields.get(7).setText(currentCpu.getManufacturer());
        	cpuFields.get(8).setText(currentCpu.getCaption());
        	cpuFields.get(9).setText(currentCpu.getProcessorId());
        	cpuFields.get(10).setText(String.valueOf(currentCpu.getNumberOfEnabledCores()));
        	cpuFields.get(11).setText(String.valueOf(currentCpu.getNumberOfLogicalProcessors()));
        	//12 is a reserved field
        	cpuFields.get(13).setText(currentCpu.getAddressWidth()+" bit");
        	cpuFields.get(14).setText(String.valueOf(currentCpu.getSocketDesignation()));
        	cpuFields.get(15).setText(currentCpu.getExtClock()+ "MHz");
        	
        	// assign the cpu manufacturer logo
        	if(currentCpu.getManufacturer()!=null)
        		IconImageChooser.cpuImageChooser(cpuManufacturerLogoLabel, currentCpu.getManufacturer());
        }
        
        // populate cache size fields

        if(currentCacheList !=null && !currentCacheList.isEmpty()) {
        	
        	Map<Integer, Long> cacheLevelAndSizeMap = currentCacheList.stream()
                    .filter(cache -> cache.getLevel()!=null && cache.getInstalledSize()!=null)
                    .collect(Collectors.toMap(Win32CacheMemory::getLevel, Win32CacheMemory::getInstalledSize));

            // set cache size fields
        	cpuFields.get(16).setText(cacheLevelAndSizeMap.get(3)+" KB"); // level 3 - L1 cache
            cpuFields.get(17).setText(cacheLevelAndSizeMap.get(4)+" KB"); // level 4 - L2 cache
            cpuFields.get(18).setText(cacheLevelAndSizeMap.get(5)+" KB"); // level 5 - L3 cache

            // populate the text area with raw details
            cacheTextArea.setText(null); //before populating, clean the previous data if any
            currentCacheList.forEach(cache -> cacheTextArea.append(
                    "DeviceID: "+cache.getDeviceId()+System.lineSeparator()+
                    "Purpose: "+cache.getPurpose()+System.lineSeparator()+
                    "Type: "+resolveWMICacheMemoryType(cache.getCacheType())+System.lineSeparator()+
                    "Level: "+resolveWMICacheMemoryLevel(cache.getLevel())+System.lineSeparator()+
                    "Size: "+cache.getInstalledSize()+" KB"+System.lineSeparator()+
                    "Associativity: "+resolveWMICacheMemoryAssociativity(cache.getAssociativity())+System.lineSeparator()+
                    "Location: "+resolveWMICacheMemoryLocation(cache.getLocation())+System.lineSeparator()+
                    "Error Correct Type: "+resolveWMICacheErrorCorrectType(cache.getErrorCorrectType())+System.lineSeparator()+
                    "Availability: "+resolveWMIAvailability(cache.getAvailability())+System.lineSeparator()+
                    "Status: "+cache.getStatus()+System.lineSeparator()+System.lineSeparator()
            ));
        }
    }
}
