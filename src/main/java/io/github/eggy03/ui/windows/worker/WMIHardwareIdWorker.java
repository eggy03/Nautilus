package io.github.eggy03.ui.windows.worker;

import io.github.eggy03.ferrumx.windows.entity.compounded.HardwareId;
import io.github.eggy03.ferrumx.windows.service.compounded.HardwareIdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.concurrent.ExecutionException;

@Slf4j
@RequiredArgsConstructor
public class WMIHardwareIdWorker extends SwingWorker<HardwareId, Void>{
	
	private final JTextField hwidField;

	@Override
	protected HardwareId doInBackground() {
		return new HardwareIdService().get(15L).orElse(HardwareId.builder().build());
		// I wonder if I should throw an exception or just return an empty build
	}
	
	@Override
	protected void done() {
		
		try {
			HardwareId hwid = get();
			hwidField.setText(hwid.getHashHWID());
		} catch (ExecutionException e) {
			log.error("HWID Fetch Failed", e);
		} catch (InterruptedException e) {
			log.error("HWID Fetch Interrupted", e);
			Thread.currentThread().interrupt();
		}
	}

}
