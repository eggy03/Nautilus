package io.github.eggy03.ui.windows.worker;

import java.util.concurrent.ExecutionException;

import javax.swing.JTextField;
import javax.swing.SwingWorker;

import io.github.eggy03.ferrumx.windows.entity.compounded.HardwareId;
import io.github.eggy03.ferrumx.windows.service.compounded.HardwareIdService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HardwareIdWorker extends SwingWorker<HardwareId, Void>{
	
	private final JTextField hwidField;

	@Override
	protected HardwareId doInBackground() {
		return new HardwareIdService().get(15L).orElse(HardwareId.builder().build()); // TODO i wonder if i should throw an exception or just return an empty build
	}
	
	@Override
	protected void done() {
		
		try {
			HardwareId hwid = get();
			hwidField.setText(hwid.getHashHWID());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
