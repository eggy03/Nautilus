package io.github.eggy03.ui.windows.worker;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.entity.compounded.Win32ProcessorToCacheMemory;
import io.github.eggy03.ferrumx.windows.entity.processor.Win32CacheMemory;
import io.github.eggy03.ferrumx.windows.entity.processor.Win32Processor;
import io.github.eggy03.ferrumx.windows.service.compounded.Win32ProcessorToCacheMemoryService;
import org.jetbrains.annotations.NotNull;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

public class CpuPanelWorker extends SwingWorker<List<Win32ProcessorToCacheMemory>, Void> {

    private final JComboBox<String> cpuIdComboBox;
    private final List<JTextField> cpuFields;
    private final JTextArea cacheTextArea;

    private List<Win32ProcessorToCacheMemory> cpuAndCacheObjectList;

    public CpuPanelWorker(JComboBox<String> cpuIdComboBox, List<JTextField> cpuFields, JTextArea cacheTextArea){
        this.cpuIdComboBox=cpuIdComboBox;
        this.cpuFields=cpuFields;
        this.cacheTextArea=cacheTextArea;
    }

    @Override
    protected @NotNull List<Win32ProcessorToCacheMemory> doInBackground() {
        try(PowerShell shell = PowerShell.openSession()){
            return new Win32ProcessorToCacheMemoryService().get(shell);
        }
    }

    @Override
    protected void done() {
        try {
            cpuAndCacheObjectList = get(20L, TimeUnit.SECONDS);            
            cpuAndCacheObjectList.forEach(cpuAndCacheCombo -> cpuIdComboBox.addItem(cpuAndCacheCombo.getDeviceId())); // add all cpu device ids to the combo box
                       
            populateFieldsBasedOnCurrentCpuId(); // for the first ID in the combo box, populate the fields         
            addCpuComboBoxActionListener(); //add cpu combo box action listener
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    // add a listener to the combo box such that fields are updated to reflect the values of the corresponding cpu in the combo box
    private void addCpuComboBoxActionListener() {
        cpuIdComboBox.addActionListener(cbSelectEvent -> populateFieldsBasedOnCurrentCpuId ());
    }
    
    // populate the fields based on the current cpuid in the combo-box
    private void populateFieldsBasedOnCurrentCpuId () {
    	
    	// filter a cpuAndCacheObject based on the cpu id in the combo box
    	Optional<Win32ProcessorToCacheMemory> current = cpuAndCacheObjectList.stream()
                .filter(cpuAndCacheObject -> cpuAndCacheObject.getDeviceId()!=null && cpuAndCacheObject.getDeviceId().equals(cpuIdComboBox.getSelectedItem())).findFirst();

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
        }
        
        // populate cache size fields
        if(currentCacheList !=null && !currentCacheList.isEmpty()) {
        	
        	Map<Integer, Long> cacheLevelAndSizeMap = currentCacheList.stream()
                    .filter(cache -> cache.getLevel()!=null && cache.getInstalledSize()!=null)
                    .collect(Collectors.toMap(Win32CacheMemory::getLevel, Win32CacheMemory::getInstalledSize));

            // set cache size fields
        	cpuFields.get(16).setText(String.valueOf(cacheLevelAndSizeMap.get(3))); // l1
            cpuFields.get(17).setText(String.valueOf(cacheLevelAndSizeMap.get(4))); // l2
            cpuFields.get(18).setText(String.valueOf(cacheLevelAndSizeMap.get(5))); // l3
            cpuFields.get(19).setText(String.valueOf(cacheLevelAndSizeMap.get(2))); // l4 is not specifically mentioned in WMI so we will use the unknown type

            // populate the text area with raw details
            currentCacheList.forEach(cache -> cacheTextArea.append(
                    "DeviceID: "+cache.getDeviceId()+System.lineSeparator()+
                    "Purpose: "+cache.getPurpose()+System.lineSeparator()+
                    "Level: "+cache.getLevel()+System.lineSeparator()+
                    "Size: "+cache.getInstalledSize()+" KB"+System.lineSeparator()+
                    "Status: "+cache.getStatus()+System.lineSeparator()+System.lineSeparator()
            ));
        }
    }
}
