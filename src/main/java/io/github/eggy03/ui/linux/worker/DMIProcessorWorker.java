/*
 * SPDX-License-Identifier: GPL-3.0-or-later
 * Copyright (C) 2026 Egg-03
 */
package io.github.eggy03.ui.linux.worker;

import io.github.eggy03.dmidecode.entity.processor.DMIProcessor;
import io.github.eggy03.dmidecode.service.processor.DMIProcessorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Slf4j
public class DMIProcessorWorker extends SwingWorker<List<DMIProcessor>, Void>{

	private final JComboBox<String> cpuIdComboBox;
	private final List<JTextField> cpuFields;
	private final JTextArea cpuCharsAndFlagsTextArea;

	@Override
	protected List<DMIProcessor> doInBackground(){
		return new DMIProcessorService().get(15);
	}

	@Override
	protected void done() {

		try {
			List<DMIProcessor> cpuList = get();
			if(cpuList.isEmpty()) {
				log.info("No entries for DMIProcessor were found");
				return;
			}
			log.info("Found {} DMIProcessor entry/entries", cpuList.size());

			// populate the combo box with cpu device id
			cpuList.forEach(cpu -> cpuIdComboBox.addItem(cpu.id()));
			// populate fields for the first entry in the combo box
			populateFieldsBasedOnCurrentCpuId(cpuList);
			// add a listener to the combo box to re-populate fields on new selection
			cpuIdComboBox.addActionListener(selectEvent -> populateFieldsBasedOnCurrentCpuId (cpuList));
		} catch (ExecutionException e) {
			log.error("CPU Fetch Failed", e);
		} catch (InterruptedException e) {
			log.error("CPU Fetch Interrupted", e);
			Thread.currentThread().interrupt();
		}

	}

	private void populateFieldsBasedOnCurrentCpuId(List<DMIProcessor> cpuList) {
		if(cpuList==null || cpuList.isEmpty())
			return;

		Optional<DMIProcessor> optionalDMIProcessor = cpuList.
				stream().
				filter(dmiProcessor -> dmiProcessor.id()!=null &&
						dmiProcessor.id().equals(cpuIdComboBox.getSelectedItem()))
						.findFirst();

		if(optionalDMIProcessor.isEmpty())
			return;

		DMIProcessor cpu = optionalDMIProcessor.get();

		cpuFields.get(0).setText(String.valueOf(cpu.coreCount()));
		cpuFields.get(1).setText(String.valueOf(cpu.threadCount()));
		cpuFields.get(2).setText(cpu.currentSpeed());
		cpuFields.get(3).setText(cpu.version());
		cpuFields.get(4).setText(cpu.signature());
		cpuFields.get(5).setText(cpu.family());
		cpuFields.get(6).setText(cpu.manufacturer());
		cpuFields.get(7).setText(cpu.serialNumber());
		cpuFields.get(8).setText(cpu.assetTag());
		cpuFields.get(9).setText(cpu.partNumber());
		cpuFields.get(10).setText(String.valueOf(cpu.coreEnabled()));
		cpuFields.get(11).setText(cpu.upgrade());
		cpuFields.get(12).setText(cpu.status());
		cpuFields.get(13).setText(cpu.voltage());
		cpuFields.get(14).setText(cpu.socketDesignation());
		cpuFields.get(15).setText(cpu.maxSpeed());

		List<String> characteristics = cpu.characteristics();
		List<String> flags = cpu.flags();

		StringBuilder sb = new StringBuilder();

		sb.append("CPU Characteristics:").append(System.lineSeparator());
		if(characteristics!=null){
			characteristics.forEach(characteristic-> sb.append("• ")
                    .append(characteristic)
                    .append(System.lineSeparator()));
		}

		sb.append(System.lineSeparator()).append("CPU Flags:").append(System.lineSeparator());
		if(flags!=null){
			flags.forEach(flag -> sb.append("• ")
					.append(flag)
					.append(System.lineSeparator()));
		}

		cpuCharsAndFlagsTextArea.setText(sb.toString());

	}
}
