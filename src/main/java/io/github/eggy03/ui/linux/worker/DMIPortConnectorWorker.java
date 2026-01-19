package io.github.eggy03.ui.linux.worker;

import io.github.eggy03.dmidecode.entity.board.DMIPortConnectorInformation;
import io.github.eggy03.dmidecode.service.board.DMIPortConnectorInformationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Slf4j
public class DMIPortConnectorWorker extends SwingWorker<List<DMIPortConnectorInformation>, Void> {

    private final JComboBox<Integer> portNumberComboBox;
    private final List<JTextField> portFields;

    @Override
    protected List<DMIPortConnectorInformation> doInBackground() throws Exception {
        return new DMIPortConnectorInformationService().get(15);
    }

    @Override
    protected void done() {

        try {
            List<DMIPortConnectorInformation> portList = get();
            if(portList.isEmpty()) {
                log.info("No entries for DMIPortConnector were found");
                return;
            }
            log.info("Found {} DMIPortConnector entry/entries", portList.size());

            // create a numbered map for all the port connectors found
            Map<Integer, DMIPortConnectorInformation> mapList = IntStream
                    .range(0, portList.size())
                    .boxed()
                    .collect(Collectors.toMap(key-> key+1, portList::get));

            // populate the combo box with port numbers
            mapList.keySet().forEach(portNumberComboBox::addItem);
            // populate fields for the first entry in the combo box
            populateFields(mapList);
            // add a listener to the combo box to re-populate fields on new selection
            portNumberComboBox.addActionListener(selectEvent -> populateFields (mapList));
        } catch (ExecutionException e) {
            log.error("DMIPortConnectorInformation Fetch Failed", e);
        } catch (InterruptedException e) {
            log.error("DMIPortConnectorInformation Fetch Interrupted", e);
            Thread.currentThread().interrupt();
        }
    }

    private void populateFields(Map<Integer, DMIPortConnectorInformation> mapList) {

        if(portNumberComboBox.getSelectedItem() instanceof Integer selection) {

            DMIPortConnectorInformation port = mapList.getOrDefault(selection, DMIPortConnectorInformation.builder().build());

            portFields.get(0).setText(port.getExternalReferenceDesignator());
            portFields.get(1).setText(port.getInternalReferenceDesignator());
            portFields.get(2).setText(port.getExternalConnectorType());
            portFields.get(3).setText(port.getInternalConnectorType());
            portFields.get(4).setText(port.getPortType());

        }
    }
}
