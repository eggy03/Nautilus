/*
 * SPDX-License-Identifier: GPL-3.0-or-later
 * Copyright (C) 2026 Egg-03
 */
package io.github.eggy03.ui.windows.worker;

import io.github.eggy03.cimari.entity.compounded.Win32DiskDriveToPartitionAndLogicalDisk;
import io.github.eggy03.cimari.entity.storage.Win32DiskDrive;
import io.github.eggy03.cimari.entity.storage.Win32DiskPartition;
import io.github.eggy03.cimari.entity.storage.Win32LogicalDisk;
import io.github.eggy03.cimari.service.compounded.Win32DiskDriveToPartitionAndLogicalDiskService;
import io.github.eggy03.ui.common.constant.TerminalConstant;
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
import java.util.Objects;
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
        return new Win32DiskDriveToPartitionAndLogicalDiskService().get(TerminalConstant.TIMEOUT_SIXTY_SECONDS);
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
            diskList.forEach(disk-> diskIdComboBox.addItem(disk.deviceId()));
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
                .filter(Objects::nonNull)
                .filter(disk-> Objects.equals(disk.deviceId(), selectedDiskId))
                .findFirst();

        if(optionalDisk.isEmpty())
            return;

        Win32DiskDriveToPartitionAndLogicalDisk disk = optionalDisk.get();
        Win32DiskDrive diskDrive = disk.diskDrive();
        List<Win32DiskPartition> diskPartitionList = disk.diskPartitionList();
        List<Win32LogicalDisk> logicalDiskList = disk.logicalDiskList();

        if(diskDrive!=null) {
            diskFields.get(0).setText(diskDrive.pnpDeviceId());
            diskFields.get(1).setText(diskDrive.caption());
            diskFields.get(2).setText(diskDrive.model());
            diskFields.get(3).setText(diskDrive.firmwareRevision());
            diskFields.get(4).setText(diskDrive.interfaceType());
            diskFields.get(5).setText(String.valueOf(diskDrive.serialNumber()).trim());
            diskFields.get(6).setText(WMISizeUtility.parseToGBString(diskDrive.size()));
            diskFields.get(7).setText(String.valueOf(diskDrive.partitions()));
            diskFields.get(8).setText(diskDrive.capabilityDescriptions()==null ? "N/A" : diskDrive.capabilityDescriptions().toString());
            diskFields.get(9).setText(diskDrive.status());
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
                    .append("<b>Device ID:</b> ").append(partition.deviceId()).append("<br>")
                    .append("<b>Name:</b> ").append(partition.name()).append("<br>")
                    .append("<b>Description:</b> ").append(partition.description()).append("<br>")
                    .append("<b>Disk Index:</b> ").append(partition.diskIndex()).append("<br>")
                    .append("<b>Type:</b> ").append(partition.type()).append("<br>")
                    .append("<b>Bootable:</b> ").append(WMIBooleanUtility.resolveBoolean(partition.bootable())).append("<br>")
                    .append("<b>Primary Partition:</b> ").append(WMIBooleanUtility.resolveBoolean(partition.primaryPartition())).append("<br>")
                    .append("<b>Boot Partition:</b> ").append(WMIBooleanUtility.resolveBoolean(partition.bootPartition())).append("<br>")
                    .append("<b>Block Size (bytes):</b> ").append(partition.blockSize()).append("<br>")
                    .append("<b>Number of Blocks:</b> ").append(partition.numberOfBlocks()).append("<br>")
                    .append("<b>Total Size:</b> ").append(WMISizeUtility.parseToGBString(partition.size()))
                    .append("<br><br>")
            );

            stringBuilder.append("</body></html>");
            partitionPane.setText(stringBuilder.toString());
        }

        if (logicalDiskList != null && !logicalDiskList.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<html><body>");

            logicalDiskList.forEach(logicalDisk -> stringBuilder
                    .append("<b>Device ID:</b> ").append(logicalDisk.deviceId()).append("<br>")
                    .append("<b>Volume Name:</b> ").append(logicalDisk.volumeName()).append("<br>")
                    .append("<b>Description:</b> ").append(logicalDisk.description()).append("<br>")
                    .append("<b>Drive Type:</b> ").append(WMIConstants.resolveWMILogicalDiskDriveType(logicalDisk.driveType())).append("<br>")
                    .append("<b>Media Type:</b> ").append(WMIConstants.resolveWMILogicalDiskMediaType(logicalDisk.mediaType())).append("<br>")
                    .append("<b>File System:</b> ").append(logicalDisk.fileSystem()).append("<br>")
                    .append("<b>Total Size:</b> ").append(WMISizeUtility.parseToGBString(logicalDisk.size())).append("<br>")
                    .append("<b>Free Space:</b> ").append(WMISizeUtility.parseToGBString(logicalDisk.freeSpace())).append("<br>")
                    .append("<b>Compressed:</b> ").append(WMIBooleanUtility.resolveBoolean(logicalDisk.compressed())).append("<br>")
                    .append("<b>Supports File Compression:</b> ").append(WMIBooleanUtility.resolveBoolean(logicalDisk.supportsFileBasedCompression())).append("<br>")
                    .append("<b>Supports Disk Quotas:</b> ").append(WMIBooleanUtility.resolveBoolean(logicalDisk.supportsDiskQuotas())).append("<br>")
                    .append("<b>Volume Serial Number:</b> ").append(logicalDisk.volumeSerialNumber())
                    .append("<br><br>")
            );

            stringBuilder.append("</body></html>");
            volumePane.setText(stringBuilder.toString());
        }

    }
}
