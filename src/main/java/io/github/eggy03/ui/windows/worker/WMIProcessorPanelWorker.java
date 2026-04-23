/*
 * SPDX-License-Identifier: GPL-3.0-or-later
 * Copyright (C) 2026 Egg-03
 */
package io.github.eggy03.ui.windows.worker;

import io.github.eggy03.cimari.entity.compounded.Win32ProcessorToCacheMemory;
import io.github.eggy03.cimari.entity.processor.Win32CacheMemory;
import io.github.eggy03.cimari.entity.processor.Win32Processor;
import io.github.eggy03.cimari.service.compounded.Win32ProcessorToCacheMemoryService;
import io.github.eggy03.ui.common.constant.TerminalConstant;
import io.github.eggy03.ui.windows.constant.WMIConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

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
    private final List<JTextArea> cpuTextAreas;

    @Override
    protected @NotNull List<Win32ProcessorToCacheMemory> doInBackground() {
       return new Win32ProcessorToCacheMemoryService().get(TerminalConstant.TIMEOUT_SIXTY_SECONDS);
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
            cpuAndCacheList.forEach(cpuAndCache -> cpuIdComboBox.addItem(cpuAndCache.deviceId()));
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
                .filter(Objects::nonNull)
                .filter(cpuAndCache -> Objects.equals(cpuAndCache.deviceId(), cpuIdComboBox.getSelectedItem()))
                .findFirst();

        if (current.isEmpty())
            return;

        Win32ProcessorToCacheMemory currentCpuAndCache = current.get();
        Win32Processor currentCpu = currentCpuAndCache.processor();
        List<Win32CacheMemory> currentCacheList = currentCpuAndCache.cacheMemoryList();
        
        // populate cpu fields
        if(currentCpu!=null) { // the order is maintained by the order in which the text fields have been passed to its constructor
        	cpuFields.get(0).setText(String.valueOf(currentCpu.numberOfCores()));
        	cpuFields.get(1).setText(String.valueOf(currentCpu.threadCount()));
        	cpuFields.get(2).setText(currentCpu.maxClockSpeed()+" MHz");
        	cpuFields.get(3).setText(currentCpu.name());
        	cpuFields.get(4).setText(currentCpu.version());
        	cpuFields.get(5).setText(String.valueOf(currentCpu.family()));
        	cpuFields.get(6).setText(currentCpu.stepping());
        	cpuFields.get(7).setText(currentCpu.manufacturer());
        	cpuFields.get(8).setText(currentCpu.caption());
        	cpuFields.get(9).setText(currentCpu.processorId());
        	cpuFields.get(10).setText(String.valueOf(currentCpu.numberOfEnabledCores()));
        	cpuFields.get(11).setText(String.valueOf(currentCpu.numberOfLogicalProcessors()));
        	cpuFields.get(12).setText(WMIConstants.processorArchitecture(currentCpu.architecture()));
        	cpuFields.get(13).setText(currentCpu.addressWidth()+" bit");
        	cpuFields.get(14).setText(String.valueOf(currentCpu.socketDesignation()));
        	cpuFields.get(15).setText(currentCpu.extClock()+ " MHz");
        	
        	// assign text to the concise cpu text area
            JTextArea conciseCpuTextArea = cpuTextAreas.getFirst();
            String conciseText = "This CPU, " + String.valueOf(currentCpu.name()).trim() + " consists of "
                    + System.lineSeparator() +
                    currentCpu.numberOfCores() + " cores and " + currentCpu.threadCount() + " threads, out of which "
                    + System.lineSeparator() +
                    currentCpu.numberOfEnabledCores() + " cores and " + currentCpu.numberOfLogicalProcessors() + " threads are enabled."
                    + System.lineSeparator() +
                    "The factory reported base clock for this CPU is: " + currentCpu.maxClockSpeed() + " MHz."
                    + System.lineSeparator() +
                    "The reported socket for this CPU is: " + currentCpu.socketDesignation()
                    + System.lineSeparator() +
                    "The reported L2 Cache is: " + currentCpu.l2CacheSize()+ " KB and the reported L3 Cache is: "+currentCpu.l3CacheSize() + " KB.";

            conciseCpuTextArea.setText(conciseText);
        }
        
        // populate cache size fields
        if(currentCacheList !=null && !currentCacheList.isEmpty()) {

            // populate the text area with raw details
            JTextArea cacheTextArea = cpuTextAreas.get(1);
            cacheTextArea.setText(null); //before populating, clean the previous data if any
            currentCacheList.forEach(cache -> cacheTextArea.append(
                    "DeviceID: "+cache.deviceId()+System.lineSeparator()+
                    "Purpose: "+cache.purpose()+System.lineSeparator()+
                    "Type: "+resolveWMICacheMemoryType(cache.cacheType())+System.lineSeparator()+
                    "Level: "+resolveWMICacheMemoryLevel(cache.level())+System.lineSeparator()+
                    "Size: "+cache.installedSize()+" KB"+System.lineSeparator()+
                    "Associativity: "+resolveWMICacheMemoryAssociativity(cache.associativity())+System.lineSeparator()+
                    "Location: "+resolveWMICacheMemoryLocation(cache.location())+System.lineSeparator()+
                    "Error Correct Type: "+resolveWMICacheErrorCorrectType(cache.errorCorrectType())+System.lineSeparator()+
                    "Availability: "+resolveWMIAvailability(cache.availability())+System.lineSeparator()+
                    "Status: "+cache.status()+System.lineSeparator()+System.lineSeparator()
            ));
        }
    }
}
