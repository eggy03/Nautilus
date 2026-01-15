package io.github.eggy03.ui.linux.worker;

import io.github.eggy03.dmidecode.entity.processor.DMIProcessor;
import io.github.eggy03.dmidecode.service.processor.DMIProcessorService;
import io.github.eggy03.ferrumx.windows.entity.compounded.Win32ProcessorToCacheMemory;
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
	private final List<JTextArea> cpuTextAreas;

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
			cpuList.forEach(cpu -> cpuIdComboBox.addItem(cpu.getId()));
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
				filter(dmiProcessor -> dmiProcessor.getId()!=null &&
						dmiProcessor.getId().equals(cpuIdComboBox.getSelectedItem()))
						.findFirst();

		if(optionalDMIProcessor.isEmpty())
			return;

		DMIProcessor cpu = optionalDMIProcessor.get();

		cpuFields.get(0).setText(String.valueOf(cpu.getCoreCount()));
		cpuFields.get(1).setText(String.valueOf(cpu.getThreadCount()));
		cpuFields.get(2).setText(cpu.getCurrentSpeed());
		cpuFields.get(3).setText(cpu.getVersion());
		cpuFields.get(4).setText(cpu.getSignature());
		cpuFields.get(5).setText(cpu.getFamily());
		cpuFields.get(6).setText(cpu.getManufacturer());
		cpuFields.get(7).setText(cpu.getSerialNumber());
		cpuFields.get(8).setText(cpu.getAssetTag());
		cpuFields.get(9).setText(cpu.getPartNumber());
		cpuFields.get(10).setText(String.valueOf(cpu.getCoreEnabled()));
		cpuFields.get(11).setText(cpu.getUpgrade());
		cpuFields.get(12).setText(cpu.getStatus());
		cpuFields.get(13).setText(cpu.getVoltage());
		cpuFields.get(14).setText(cpu.getSocketDesignation());
		cpuFields.get(15).setText(cpu.getMaxSpeed());

		StringBuilder sb = new StringBuilder();
		sb.append("CPU Characteristics:")
				.append(System.lineSeparator());

		if(cpu.getCharacteristics()!=null){
			cpu.getCharacteristics().forEach(characteristic-> sb.append("• ")
                    .append(characteristic)
                    .append(System.lineSeparator()));
		}

		sb.append(System.lineSeparator())
				.append("CPU Flags:")
				.append(System.lineSeparator());

		if(cpu.getFlags()!=null){
			cpu.getFlags().forEach(flag -> sb.append("• ")
					.append(flag)
					.append(System.lineSeparator()));
		}

		cpuTextAreas.get(0).setText(sb.toString());

	}


}
