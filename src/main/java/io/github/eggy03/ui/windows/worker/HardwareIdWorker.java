package io.github.eggy03.ui.windows.worker;

import java.util.concurrent.ExecutionException;

import javax.swing.JTextField;
import javax.swing.SwingWorker;

import com.profesorfalken.jpowershell.PowerShell;

import io.github.eggy03.ferrumx.windows.entity.compounded.HardwareId;
import io.github.eggy03.ferrumx.windows.service.compounded.HardwareIdService;

public class HardwareIdWorker extends SwingWorker<HardwareId, Void>{
	
	private final JTextField hwidField;
	
	public HardwareIdWorker(JTextField hwidField) {
		this.hwidField = hwidField;
	}

	@Override
	protected HardwareId doInBackground() {
		try(PowerShell shell = PowerShell.openSession()){
			return new HardwareIdService().get(shell).orElseThrow();
		}
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
