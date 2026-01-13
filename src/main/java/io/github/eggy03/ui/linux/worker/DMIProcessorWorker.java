package io.github.eggy03.ui.linux.worker;

import io.github.eggy03.dmidecode.entity.processor.DMIProcessor;
import io.github.eggy03.dmidecode.service.processor.DMIProcessorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JTextField;
import javax.swing.SwingWorker;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class DMIProcessorWorker extends SwingWorker<List<DMIProcessor>, Void>{

	private final List<JTextField> cpuFields;

	@Override
	protected List<DMIProcessor> doInBackground(){
		return new DMIProcessorService().get(15);
	}

	@Override
	protected void done() {

	}

	public static void main(String[] args) {
		new DMIProcessorService().get(15).forEach(System.out::println);
	}

}
