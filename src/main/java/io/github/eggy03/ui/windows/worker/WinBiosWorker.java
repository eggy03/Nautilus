package io.github.eggy03.ui.windows.worker;

import io.github.eggy03.ferrumx.windows.entity.mainboard.Win32Bios;
import io.github.eggy03.ferrumx.windows.service.mainboard.Win32BiosService;
import io.github.eggy03.ui.windows.utilities.WMIDateUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Slf4j
@RequiredArgsConstructor
public class WinBiosWorker extends SwingWorker<List<Win32Bios>, Void> {

    private final JComboBox<Integer> biosNumberComboBox;
    private final List<JTextField> biosFields;

    @Override
    protected List<Win32Bios> doInBackground() {
        return new Win32BiosService().get(15L);
    }

    @Override
    protected void done() {

        try {
            // get the bios list
            List<Win32Bios> biosList = get();
            if(biosList.isEmpty()) {
                log.info("No entries for Win32Bios were found");
                return;
            }
            log.info("Found {} Win32Bios entry/entries", biosList.size());

            // covert the bios list into a map
            Map<Integer, Win32Bios> biosMap = covertBiosListToMap(biosList);
            // populate the combo box
            biosMap.keySet().forEach(biosNumberComboBox::addItem);
            // populate fields for the first entry in the combo box
            populateBiosFields(biosMap);
            // add a listener to the combo box to re-populate fields on new selection
            biosNumberComboBox.addActionListener(selectEvent -> populateBiosFields(biosMap));
        } catch (InterruptedException e) {
            log.error("BIOS Fetch Interrupted", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error("BIOS Fetch Failed", e);
        }

    }

    private Map<Integer, Win32Bios> covertBiosListToMap(List<Win32Bios> biosList) {

        Map<Integer, Win32Bios> biosMap = new LinkedHashMap<>();

        for(int i=0; i<biosList.size(); i++) {
            biosMap.put(i+1, biosList.get(i));
        }

        return biosMap;

    }

    private void populateBiosFields(Map<Integer, Win32Bios> biosMap) {

        Integer selectedBiosNumber = (Integer) biosNumberComboBox.getSelectedItem();

        Win32Bios bios = biosMap.getOrDefault(selectedBiosNumber, Win32Bios.builder().build());

        biosFields.get(0).setText(bios.getCaption());
        biosFields.get(1).setText(bios.getCurrentLanguage());
        biosFields.get(2).setText(bios.getManufacturer());
        biosFields.get(3).setText(bios.getName());

        biosFields.get(5).setText(WMIDateUtility.toLocalDateTime(bios.getReleaseDate()));

        biosFields.get(7).setText(bios.getSmbiosBiosVersion());
        biosFields.get(8).setText(bios.getStatus());
        biosFields.get(9).setText(bios.getVersion());

        // this is so bad....I cant use inline expression or sonar will detect it
        Boolean primaryBios = bios.isPrimaryBios();
        if(primaryBios!=null) {
            if(primaryBios) biosFields.get(4).setText("Yes");
            else biosFields.get(4).setText("No");
        } else biosFields.get(4).setText("N/A");

        Boolean smbiosPresent = bios.isSMBIOSPresent();
        if(smbiosPresent!=null) {
            if(smbiosPresent) biosFields.get(6).setText("Yes");
            else biosFields.get(6).setText("No");
        } else biosFields.get(6).setText("N/A");
    }
}
