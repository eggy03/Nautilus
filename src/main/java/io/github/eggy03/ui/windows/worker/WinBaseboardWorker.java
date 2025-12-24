package io.github.eggy03.ui.windows.worker;

import io.github.eggy03.ferrumx.windows.entity.mainboard.Win32Baseboard;
import io.github.eggy03.ferrumx.windows.service.mainboard.Win32BaseboardService;
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
public class WinBaseboardWorker extends SwingWorker<List<Win32Baseboard>, Void> {

    private final JComboBox<Integer> baseboardNumberComboBox;
    private final List<JTextField> baseboardFields;

    @Override
    protected List<Win32Baseboard> doInBackground() {
        return new Win32BaseboardService().get(15L);
    }

    @Override
    protected void done() {
        try {
            // convert the list of baseboards into a map to determine each distinct baseboard
            Map<Integer, Win32Baseboard> baseboardMap = convertBaseboardListToMap(get());
            // populate the combo box with the baseboardMap keys
            baseboardMap.keySet().forEach(baseboardNumberComboBox::addItem);
            // populate fields for the first entry in the combo box
            populateFields(baseboardMap);
            // add a listener to the combo box to re-populate fields on new selection
            baseboardNumberComboBox.addActionListener(selectEvent -> populateFields(baseboardMap));
        } catch (InterruptedException e) {
            log.error("Baseboard Fetch Interrupted", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error("Baseboard Fetch Failed", e);
        }
    }

    // create a map of baseboard list since Win32Baseboard doesn't have a unique ID field to separate an instance
    private Map<Integer, Win32Baseboard> convertBaseboardListToMap(List<Win32Baseboard> baseboardList) {

        Map<Integer, Win32Baseboard> baseboardMap = new LinkedHashMap<>();

        if(baseboardList.isEmpty()) {
            log.info("No entries for Win32Baseboard were found");
            return baseboardMap;
        }
        log.info("Found {} Win32Baseboard entry/entries", baseboardList.size());

        for(int i=0 ; i<baseboardList.size(); i++) {
            baseboardMap.put(i+1, baseboardList.get(i));
        }
        return baseboardMap;
    }

    private void populateFields(Map<Integer, Win32Baseboard> baseboardMap) {

        Integer selectedBaseboardChoice = (Integer) baseboardNumberComboBox.getSelectedItem();
        Win32Baseboard baseboard = baseboardMap.getOrDefault(selectedBaseboardChoice, Win32Baseboard.builder().build());

        baseboardFields.get(0).setText(baseboard.getManufacturer());
        baseboardFields.get(1).setText(baseboard.getModel());
        baseboardFields.get(2).setText(baseboard.getProduct());
        baseboardFields.get(3).setText(baseboard.getSerialNumber());
        baseboardFields.get(4).setText(baseboard.getVersion());

    }

}
