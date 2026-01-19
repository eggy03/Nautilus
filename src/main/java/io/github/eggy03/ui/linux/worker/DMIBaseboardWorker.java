package io.github.eggy03.ui.linux.worker;

import io.github.eggy03.dmidecode.entity.board.DMIBaseboard;
import io.github.eggy03.dmidecode.service.board.DMIBaseboardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Slf4j
public class DMIBaseboardWorker extends SwingWorker<Optional<DMIBaseboard>, Void> {

    private final List<JTextField> baseboardFields;

    @Override
    protected Optional<DMIBaseboard> doInBackground() throws Exception {
        return new DMIBaseboardService().get(15);
    }

    @Override
    protected void done() {

        try {
            Optional<DMIBaseboard> optionalDMIBaseboard = get();
            if(optionalDMIBaseboard.isEmpty()) {
                log.info("No entries for DMIBaseboard were found");
                return;
            }
            log.info("Found a DMIBaseboard entry");

            // populate fields
            populateFields(optionalDMIBaseboard.get());

        } catch (ExecutionException e) {
            log.error("Baseboard Fetch Failed", e);
        } catch (InterruptedException e) {
            log.error("Baseboard Fetch Interrupted", e);
            Thread.currentThread().interrupt();
        }
    }

    private void populateFields(DMIBaseboard dmiBaseboard) {

        baseboardFields.get(0).setText(dmiBaseboard.getManufacturer());
        baseboardFields.get(1).setText(dmiBaseboard.getProductName());
        baseboardFields.get(2).setText(dmiBaseboard.getVersion());
        baseboardFields.get(3).setText(dmiBaseboard.getSerialNumber());
        baseboardFields.get(4).setText(dmiBaseboard.getAssetTag());
        baseboardFields.get(5).setText(dmiBaseboard.getFeatures()!=null ? dmiBaseboard.getFeatures().toString() : "N/A");
        baseboardFields.get(6).setText(dmiBaseboard.getLocationInChassis());
        baseboardFields.get(7).setText(dmiBaseboard.getChassisHandle());
        baseboardFields.get(8).setText(dmiBaseboard.getType());
    }
}
