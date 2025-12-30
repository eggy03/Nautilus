package io.github.eggy03.ui.windows.worker;

import io.github.eggy03.ferrumx.windows.entity.compounded.Win32DiskDriveToPartitionAndLogicalDisk;
import io.github.eggy03.ferrumx.windows.entity.storage.Win32DiskDrive;
import io.github.eggy03.ferrumx.windows.entity.storage.Win32DiskPartition;
import io.github.eggy03.ferrumx.windows.entity.storage.Win32LogicalDisk;
import io.github.eggy03.ferrumx.windows.service.compounded.Win32DiskDriveToPartitionAndLogicalDiskService;
import io.github.eggy03.ui.windows.constant.WMIConstants;
import io.github.eggy03.ui.windows.utilities.WMIBooleanUtility;
import io.github.eggy03.ui.windows.utilities.WMISizeUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Slf4j
public class WMIStorageWorker extends SwingWorker<List<Win32DiskDriveToPartitionAndLogicalDisk>, Void> {

    private final JComboBox<String> diskIdComboBox;
    private final List<JTextField> diskFields;
    private final List<JEditorPane> diskEditorPanes;

    @Override
    protected List<Win32DiskDriveToPartitionAndLogicalDisk> doInBackground() {
        return new Win32DiskDriveToPartitionAndLogicalDiskService().get(15L);
    }

    @Override
    protected void done() {
        try {
            List<Win32DiskDriveToPartitionAndLogicalDisk> diskList = get();
            if(diskList.isEmpty()) {
                log.info("No entries for Win32DiskDrive were found");
                return;
            }
            log.info("Found {} Win32DiskDrive entry/entries", diskList.size());

            // populate the combo box with disk deviceIDs
            diskList.forEach(disk-> diskIdComboBox.addItem(disk.getDeviceId()));
            // populate fields and editor panes for the first entry in the combo box
            populate(diskList);
            // add a listener to the combo box to re-populate fields on new selection
            diskIdComboBox.addActionListener(selectAction -> populate(diskList));

        } catch (InterruptedException e) {
            log.error("Disk Fetch Interrupted", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error("Disk Fetch Failed", e);
        }
    }

    private void populate(List<Win32DiskDriveToPartitionAndLogicalDisk> diskList) {

        String selectedDiskId = String.valueOf(diskIdComboBox.getSelectedItem());

        Optional<Win32DiskDriveToPartitionAndLogicalDisk> optionalDisk = diskList
                .stream()
                .filter(disk-> disk.getDeviceId()!=null && disk.getDeviceId().equals(selectedDiskId))
                .findFirst();

        if(optionalDisk.isEmpty())
            return;

        Win32DiskDriveToPartitionAndLogicalDisk disk = optionalDisk.get();
        Win32DiskDrive diskDrive = disk.getDiskDrive();
        List<Win32DiskPartition> diskPartitionList = disk.getDiskPartitionList();
        List<Win32LogicalDisk> logicalDiskList = disk.getLogicalDiskList();

        if(diskDrive!=null) {
            diskFields.get(0).setText(diskDrive.getPnpDeviceId());
            diskFields.get(1).setText(diskDrive.getCaption());
            diskFields.get(2).setText(diskDrive.getModel());
            diskFields.get(3).setText(diskDrive.getFirmwareRevision());
            diskFields.get(4).setText(diskDrive.getInterfaceType());
            diskFields.get(5).setText(String.valueOf(diskDrive.getSerialNumber()).trim());
            diskFields.get(6).setText(WMISizeUtility.parseToGBString(diskDrive.getSize()));
            diskFields.get(7).setText(String.valueOf(diskDrive.getPartitions()));
            diskFields.get(8).setText(diskDrive.getCapabilityDescriptions()==null ? "N/A" : diskDrive.getCapabilityDescriptions().toString());
            diskFields.get(9).setText(diskDrive.getStatus());
        }

        JEditorPane partitionPane = diskEditorPanes.get(0);
        JEditorPane volumePane = diskEditorPanes.get(1);
        // reset their contents on every invoke of this function
        partitionPane.setText(null);
        volumePane.setText(null);

        if (diskPartitionList != null && !diskPartitionList.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<html><body>");

            diskPartitionList.forEach(partition -> stringBuilder
                    .append("<b>Device ID:</b> ").append(partition.getDeviceId()).append("<br>")
                    .append("<b>Name:</b> ").append(partition.getName()).append("<br>")
                    .append("<b>Description:</b> ").append(partition.getDescription()).append("<br>")
                    .append("<b>Disk Index:</b> ").append(partition.getDiskIndex()).append("<br>")
                    .append("<b>Type:</b> ").append(partition.getType()).append("<br>")
                    .append("<b>Bootable:</b> ").append(WMIBooleanUtility.resolveBoolean(partition.isBootable())).append("<br>")
                    .append("<b>Primary Partition:</b> ").append(WMIBooleanUtility.resolveBoolean(partition.isPrimaryPartition())).append("<br>")
                    .append("<b>Boot Partition:</b> ").append(WMIBooleanUtility.resolveBoolean(partition.isBootPartition())).append("<br>")
                    .append("<b>Block Size (bytes):</b> ").append(partition.getBlockSize()).append("<br>")
                    .append("<b>Number of Blocks:</b> ").append(partition.getNumberOfBlocks()).append("<br>")
                    .append("<b>Total Size:</b> ").append(WMISizeUtility.parseToGBString(partition.getSize()))
                    .append("<br><br>")
            );

            stringBuilder.append("</body></html>");
            partitionPane.setText(stringBuilder.toString());
        }

        if (logicalDiskList != null && !logicalDiskList.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<html><body>");

            logicalDiskList.forEach(logicalDisk -> stringBuilder
                    .append("<b>Device ID:</b> ").append(logicalDisk.getDeviceId()).append("<br>")
                    .append("<b>Volume Name:</b> ").append(logicalDisk.getVolumeName()).append("<br>")
                    .append("<b>Description:</b> ").append(logicalDisk.getDescription()).append("<br>")
                    .append("<b>Drive Type:</b> ").append(WMIConstants.resolveWMILogicalDiskDriveType(logicalDisk.getDriveType())).append("<br>")
                    .append("<b>Media Type:</b> ").append(WMIConstants.resolveWMILogicalDiskMediaType(logicalDisk.getMediaType())).append("<br>")
                    .append("<b>File System:</b> ").append(logicalDisk.getFileSystem()).append("<br>")
                    .append("<b>Total Size:</b> ").append(WMISizeUtility.parseToGBString(logicalDisk.getSize())).append("<br>")
                    .append("<b>Free Space:</b> ").append(WMISizeUtility.parseToGBString(logicalDisk.getFreeSpace())).append("<br>")
                    .append("<b>Compressed:</b> ").append(WMIBooleanUtility.resolveBoolean(logicalDisk.isCompressed())).append("<br>")
                    .append("<b>Supports File Compression:</b> ").append(WMIBooleanUtility.resolveBoolean(logicalDisk.supportsFileBasedCompression())).append("<br>")
                    .append("<b>Supports Disk Quotas:</b> ").append(WMIBooleanUtility.resolveBoolean(logicalDisk.supportsDiskQuotas())).append("<br>")
                    .append("<b>Volume Serial Number:</b> ").append(logicalDisk.getVolumeSerialNumber())
                    .append("<br><br>")
            );

            stringBuilder.append("</body></html>");
            volumePane.setText(stringBuilder.toString());
        }

    }
}
