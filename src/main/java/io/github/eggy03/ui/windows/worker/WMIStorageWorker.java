package io.github.eggy03.ui.windows.worker;

import io.github.eggy03.ferrumx.windows.entity.compounded.Win32DiskDriveToPartitionAndLogicalDisk;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class WMIStorageWorker extends SwingWorker<List<Win32DiskDriveToPartitionAndLogicalDisk>, Void> {

    private final JComboBox<String> diskIdComboBox;
    private final List<JTextField> diskFields;
    private final List<JEditorPane> diskEditorPanes;

    @Override
    protected List<Win32DiskDriveToPartitionAndLogicalDisk> doInBackground() {
        return List.of();
        // TODO write actual logic
    }

    @Override
    protected void done() {
        // TODO write actual logic
    }
}
