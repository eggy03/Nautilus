package io.github.eggy03.ui.linux.worker;

import io.github.eggy03.dmidecode.entity.system.DMISystem;
import io.github.eggy03.dmidecode.service.system.DMISystemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Slf4j
public class SystemUUIDWorker extends SwingWorker<Optional<DMISystem>, Void> {

    private final JTextField uuidField;

    @Override
    protected Optional<DMISystem> doInBackground() throws Exception {
        return new DMISystemService().get(15);
    }

    @Override
    protected void done() {
        try {
            Optional<DMISystem> system = get();
            system.ifPresent(sys -> uuidField.setText(sys.getUuid()));
        } catch (ExecutionException e) {
            log.error("System Fetch Failed", e);
        } catch (InterruptedException e) {
            log.error("System Fetch Interrupted", e);
            Thread.currentThread().interrupt();
        }
    }
}
