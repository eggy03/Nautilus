package io.github.eggy03.ui.linux.worker;

import io.github.eggy03.dmidecode.entity.board.DMIBIOS;
import io.github.eggy03.dmidecode.service.board.DMIBIOSService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Slf4j
public class DMIBIOSWorker extends SwingWorker<List<DMIBIOS>, Void> {

    private final JComboBox<Integer> biosNumberComboBox;
    private final List<JTextField> biosFields;
    private final JTextArea biosCharacteristicsTextArea;

    @Override
    protected List<DMIBIOS> doInBackground() throws Exception {
        return new DMIBIOSService().get(15);
    }

    @Override
    protected void done() {

        try {
            List<DMIBIOS> biosList = get();
            if(biosList.isEmpty()) {
                log.info("No entries for DMIBIOS were found");
                return;
            }
            log.info("Found {} DMIBIOS entry/entries", biosList.size());

            // create a numbered map for all the BIOSes found
            Map<Integer, DMIBIOS> mapList = IntStream
                    .range(0, biosList.size())
                    .boxed()
                    .collect(Collectors.toMap(key-> key+1, biosList::get));

            // populate the combo box with BIOS numbers
            mapList.keySet().forEach(biosNumberComboBox::addItem);
            // populate fields for the first entry in the combo box
            populateFields(mapList);
            // add a listener to the combo box to re-populate fields on new selection
            biosNumberComboBox.addActionListener(selectEvent -> populateFields (mapList));
        } catch (ExecutionException e) {
            log.error("DMIBIOS Fetch Failed", e);
        } catch (InterruptedException e) {
            log.error("DMIBIOS Fetch Interrupted", e);
            Thread.currentThread().interrupt();
        }
    }

    private void populateFields(Map<Integer, DMIBIOS> mapList) {

        if(biosNumberComboBox.getSelectedItem() instanceof Integer selection) {

            DMIBIOS bios = mapList.getOrDefault(selection, DMIBIOS.builder().build());

            biosFields.get(0).setText(bios.getVendor());
            biosFields.get(1).setText(bios.getVersion());
            biosFields.get(2).setText(bios.getReleaseDate());
            biosFields.get(3).setText(bios.getAddress());
            biosFields.get(4).setText(bios.getRuntimeSize());
            biosFields.get(5).setText(bios.getRomSize());
            biosFields.get(6).setText(bios.getBiosRevision());
            biosFields.get(7).setText(bios.getFirmwareRevision());

            StringBuilder characteristics = new StringBuilder();
            characteristics.append("Characteristics: ").append(System.lineSeparator());

            if(bios.getCharacteristics()!=null){
                bios.getCharacteristics().forEach(characteristic-> characteristics.append(characteristic).append(System.lineSeparator()));
            }
            biosCharacteristicsTextArea.setText(characteristics.toString());
        }
    }
}
