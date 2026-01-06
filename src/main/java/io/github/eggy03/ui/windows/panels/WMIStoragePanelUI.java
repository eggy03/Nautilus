package io.github.eggy03.ui.windows.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import io.github.eggy03.ui.windows.worker.WMIStorageWorker;

public class WMIStoragePanelUI extends JPanel {
	
	private JComboBox<String> diskDeviceIdComboBox;

	private JTextField diskPnpDeviceIdTextField;
	private JTextField diskCaptionTextField;
	private JTextField diskModelTextField;
	private JTextField diskFirmwareRevisionTextField;
	private JTextField diskInterfaceTypeTextField;
	private JTextField diskSerialNumberTextField;
	private JTextField diskSizeTextField;
	private JTextField diskPartitionsTextField;
	private JTextField diskCapabilitiesTextField;
	private JTextField diskStatusTextField;

	private JEditorPane diskPartitionEditorPane;
	private JEditorPane diskVolumeEditorPane;
	
	public JPanel getPanel() {
		return this;
	}

	/**
	 * Create the panel.
	 */
	public WMIStoragePanelUI() {
		setLayout(new GridLayout(2, 0, 0, 0));
		
		setDiskDrivePanel();
		setDiskPartitionAndVolumePane();
		setWorker();
	}
	
	private void setDiskDrivePanel() {
		
		JScrollPane diskDriveScrollPane = new JScrollPane();
		add(diskDriveScrollPane);
		
		JPanel diskDrivePanel = new JPanel();
		diskDrivePanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Disk Drive", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		diskDriveScrollPane.setViewportView(diskDrivePanel);
		GridBagLayout gblDiskDrivePanel = new GridBagLayout();
		gblDiskDrivePanel.columnWidths = new int[]{0, 0, 0};
		gblDiskDrivePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gblDiskDrivePanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gblDiskDrivePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		diskDrivePanel.setLayout(gblDiskDrivePanel);
		
		JLabel diskDeviceIdLabel = new JLabel("Disk#");
		GridBagConstraints gbcDiskDeviceIdLabel = new GridBagConstraints();
		gbcDiskDeviceIdLabel.insets = new Insets(0, 0, 5, 5);
		gbcDiskDeviceIdLabel.anchor = GridBagConstraints.WEST;
		gbcDiskDeviceIdLabel.gridx = 0;
		gbcDiskDeviceIdLabel.gridy = 0;
		diskDrivePanel.add(diskDeviceIdLabel, gbcDiskDeviceIdLabel);
		
		diskDeviceIdComboBox = new JComboBox<>();
		GridBagConstraints gbcDiskDeviceIdComboBox = new GridBagConstraints();
		gbcDiskDeviceIdComboBox.insets = new Insets(0, 0, 5, 0);
		gbcDiskDeviceIdComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbcDiskDeviceIdComboBox.gridx = 1;
		gbcDiskDeviceIdComboBox.gridy = 0;
		diskDrivePanel.add(diskDeviceIdComboBox, gbcDiskDeviceIdComboBox);
		
		JLabel diskPnpDeviceIdLabel = new JLabel("PnP DeviceID");
		GridBagConstraints gbcDiskPnpDeviceIdLabel = new GridBagConstraints();
		gbcDiskPnpDeviceIdLabel.anchor = GridBagConstraints.WEST;
		gbcDiskPnpDeviceIdLabel.insets = new Insets(0, 0, 5, 5);
		gbcDiskPnpDeviceIdLabel.gridx = 0;
		gbcDiskPnpDeviceIdLabel.gridy = 1;
		diskDrivePanel.add(diskPnpDeviceIdLabel, gbcDiskPnpDeviceIdLabel);
		
		diskPnpDeviceIdTextField = new JTextField();
		diskPnpDeviceIdTextField.setEditable(false);
		GridBagConstraints gbcDiskPnpDeviceIdTextField = new GridBagConstraints();
		gbcDiskPnpDeviceIdTextField.insets = new Insets(0, 0, 5, 0);
		gbcDiskPnpDeviceIdTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcDiskPnpDeviceIdTextField.gridx = 1;
		gbcDiskPnpDeviceIdTextField.gridy = 1;
		diskDrivePanel.add(diskPnpDeviceIdTextField, gbcDiskPnpDeviceIdTextField);
		diskPnpDeviceIdTextField.setColumns(10);
		
		JLabel diskCaptionLabel = new JLabel("Name");
		GridBagConstraints gbcDiskCaptionLabel = new GridBagConstraints();
		gbcDiskCaptionLabel.anchor = GridBagConstraints.WEST;
		gbcDiskCaptionLabel.insets = new Insets(0, 0, 5, 5);
		gbcDiskCaptionLabel.gridx = 0;
		gbcDiskCaptionLabel.gridy = 2;
		diskDrivePanel.add(diskCaptionLabel, gbcDiskCaptionLabel);
		
		diskCaptionTextField = new JTextField();
		diskCaptionTextField.setEditable(false);
		GridBagConstraints gbcDiskCaptionTextField = new GridBagConstraints();
		gbcDiskCaptionTextField.insets = new Insets(0, 0, 5, 0);
		gbcDiskCaptionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcDiskCaptionTextField.gridx = 1;
		gbcDiskCaptionTextField.gridy = 2;
		diskDrivePanel.add(diskCaptionTextField, gbcDiskCaptionTextField);
		diskCaptionTextField.setColumns(10);
		
		JLabel diskModelLabel = new JLabel("Model");
		GridBagConstraints gbcDiskModelLabel = new GridBagConstraints();
		gbcDiskModelLabel.anchor = GridBagConstraints.WEST;
		gbcDiskModelLabel.insets = new Insets(0, 0, 5, 5);
		gbcDiskModelLabel.gridx = 0;
		gbcDiskModelLabel.gridy = 3;
		diskDrivePanel.add(diskModelLabel, gbcDiskModelLabel);
		
		diskModelTextField = new JTextField();
		diskModelTextField.setEditable(false);
		GridBagConstraints gbcDiskModelTextField = new GridBagConstraints();
		gbcDiskModelTextField.insets = new Insets(0, 0, 5, 0);
		gbcDiskModelTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcDiskModelTextField.gridx = 1;
		gbcDiskModelTextField.gridy = 3;
		diskDrivePanel.add(diskModelTextField, gbcDiskModelTextField);
		diskModelTextField.setColumns(10);
		
		JLabel diskFirmwareRevisionLabel = new JLabel("Firmware");
		GridBagConstraints gbcDiskFirmwareRevisionLabel = new GridBagConstraints();
		gbcDiskFirmwareRevisionLabel.anchor = GridBagConstraints.WEST;
		gbcDiskFirmwareRevisionLabel.insets = new Insets(0, 0, 5, 5);
		gbcDiskFirmwareRevisionLabel.gridx = 0;
		gbcDiskFirmwareRevisionLabel.gridy = 4;
		diskDrivePanel.add(diskFirmwareRevisionLabel, gbcDiskFirmwareRevisionLabel);
		
		diskFirmwareRevisionTextField = new JTextField();
		diskFirmwareRevisionTextField.setEditable(false);
		GridBagConstraints gbcDiskFirmwareRevisionTextField = new GridBagConstraints();
		gbcDiskFirmwareRevisionTextField.insets = new Insets(0, 0, 5, 0);
		gbcDiskFirmwareRevisionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcDiskFirmwareRevisionTextField.gridx = 1;
		gbcDiskFirmwareRevisionTextField.gridy = 4;
		diskDrivePanel.add(diskFirmwareRevisionTextField, gbcDiskFirmwareRevisionTextField);
		diskFirmwareRevisionTextField.setColumns(10);
		
		JLabel diskInterfaceTypeLabel = new JLabel("Interface");
		GridBagConstraints gbcDiskInterfaceTypeLabel = new GridBagConstraints();
		gbcDiskInterfaceTypeLabel.anchor = GridBagConstraints.WEST;
		gbcDiskInterfaceTypeLabel.insets = new Insets(0, 0, 5, 5);
		gbcDiskInterfaceTypeLabel.gridx = 0;
		gbcDiskInterfaceTypeLabel.gridy = 5;
		diskDrivePanel.add(diskInterfaceTypeLabel, gbcDiskInterfaceTypeLabel);
		
		diskInterfaceTypeTextField = new JTextField();
		diskInterfaceTypeTextField.setEditable(false);
		GridBagConstraints gbcDiskInterfaceTypeTextField = new GridBagConstraints();
		gbcDiskInterfaceTypeTextField.insets = new Insets(0, 0, 5, 0);
		gbcDiskInterfaceTypeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcDiskInterfaceTypeTextField.gridx = 1;
		gbcDiskInterfaceTypeTextField.gridy = 5;
		diskDrivePanel.add(diskInterfaceTypeTextField, gbcDiskInterfaceTypeTextField);
		diskInterfaceTypeTextField.setColumns(10);
		
		JLabel diskSerialNumberLabel = new JLabel("Serial Number");
		GridBagConstraints gbcDiskSerialNumberLabel = new GridBagConstraints();
		gbcDiskSerialNumberLabel.anchor = GridBagConstraints.WEST;
		gbcDiskSerialNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbcDiskSerialNumberLabel.gridx = 0;
		gbcDiskSerialNumberLabel.gridy = 6;
		diskDrivePanel.add(diskSerialNumberLabel, gbcDiskSerialNumberLabel);
		
		diskSerialNumberTextField = new JTextField();
		diskSerialNumberTextField.setEditable(false);
		GridBagConstraints gbcDiskSerialNumberTextField = new GridBagConstraints();
		gbcDiskSerialNumberTextField.insets = new Insets(0, 0, 5, 0);
		gbcDiskSerialNumberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcDiskSerialNumberTextField.gridx = 1;
		gbcDiskSerialNumberTextField.gridy = 6;
		diskDrivePanel.add(diskSerialNumberTextField, gbcDiskSerialNumberTextField);
		diskSerialNumberTextField.setColumns(10);
		
		JLabel diskSizeLabel = new JLabel("Size");
		GridBagConstraints gbcDiskSizeLabel = new GridBagConstraints();
		gbcDiskSizeLabel.anchor = GridBagConstraints.WEST;
		gbcDiskSizeLabel.insets = new Insets(0, 0, 5, 5);
		gbcDiskSizeLabel.gridx = 0;
		gbcDiskSizeLabel.gridy = 7;
		diskDrivePanel.add(diskSizeLabel, gbcDiskSizeLabel);
		
		diskSizeTextField = new JTextField();
		diskSizeTextField.setEditable(false);
		GridBagConstraints gbcDiskSizeTextField = new GridBagConstraints();
		gbcDiskSizeTextField.insets = new Insets(0, 0, 5, 0);
		gbcDiskSizeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcDiskSizeTextField.gridx = 1;
		gbcDiskSizeTextField.gridy = 7;
		diskDrivePanel.add(diskSizeTextField, gbcDiskSizeTextField);
		diskSizeTextField.setColumns(10);
		
		JLabel diskPartitionsLabel = new JLabel("Partitions");
		GridBagConstraints gbcDiskPartitionsLabel = new GridBagConstraints();
		gbcDiskPartitionsLabel.anchor = GridBagConstraints.WEST;
		gbcDiskPartitionsLabel.insets = new Insets(0, 0, 5, 5);
		gbcDiskPartitionsLabel.gridx = 0;
		gbcDiskPartitionsLabel.gridy = 8;
		diskDrivePanel.add(diskPartitionsLabel, gbcDiskPartitionsLabel);
		
		diskPartitionsTextField = new JTextField();
		diskPartitionsTextField.setEditable(false);
		GridBagConstraints gbcDiskPartitionsTextField = new GridBagConstraints();
		gbcDiskPartitionsTextField.insets = new Insets(0, 0, 5, 0);
		gbcDiskPartitionsTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcDiskPartitionsTextField.gridx = 1;
		gbcDiskPartitionsTextField.gridy = 8;
		diskDrivePanel.add(diskPartitionsTextField, gbcDiskPartitionsTextField);
		diskPartitionsTextField.setColumns(10);
		
		JLabel diskCapabilitiesLabel = new JLabel("Capabilities");
		GridBagConstraints gbcDiskCapabilitiesLabel = new GridBagConstraints();
		gbcDiskCapabilitiesLabel.anchor = GridBagConstraints.WEST;
		gbcDiskCapabilitiesLabel.insets = new Insets(0, 0, 5, 5);
		gbcDiskCapabilitiesLabel.gridx = 0;
		gbcDiskCapabilitiesLabel.gridy = 9;
		diskDrivePanel.add(diskCapabilitiesLabel, gbcDiskCapabilitiesLabel);
		
		diskCapabilitiesTextField = new JTextField();
		diskCapabilitiesTextField.setEditable(false);
		GridBagConstraints gbcDiskCapabilitiesTextField = new GridBagConstraints();
		gbcDiskCapabilitiesTextField.insets = new Insets(0, 0, 5, 0);
		gbcDiskCapabilitiesTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcDiskCapabilitiesTextField.gridx = 1;
		gbcDiskCapabilitiesTextField.gridy = 9;
		diskDrivePanel.add(diskCapabilitiesTextField, gbcDiskCapabilitiesTextField);
		diskCapabilitiesTextField.setColumns(10);
		
		JLabel diskStatusLabel = new JLabel("Status");
		GridBagConstraints gbcDiskStatusLabel = new GridBagConstraints();
		gbcDiskStatusLabel.anchor = GridBagConstraints.WEST;
		gbcDiskStatusLabel.insets = new Insets(0, 0, 0, 5);
		gbcDiskStatusLabel.gridx = 0;
		gbcDiskStatusLabel.gridy = 10;
		diskDrivePanel.add(diskStatusLabel, gbcDiskStatusLabel);
		
		diskStatusTextField = new JTextField();
		diskStatusTextField.setEditable(false);
		GridBagConstraints gbcDiskStatusTextField = new GridBagConstraints();
		gbcDiskStatusTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcDiskStatusTextField.gridx = 1;
		gbcDiskStatusTextField.gridy = 10;
		diskDrivePanel.add(diskStatusTextField, gbcDiskStatusTextField);
		diskStatusTextField.setColumns(10);
	}
	
	private void setDiskPartitionAndVolumePane() {
		
		JTabbedPane diskPartitionAndVolumePane = new JTabbedPane(JTabbedPane.TOP);
		add(diskPartitionAndVolumePane);
		
		// partition
		JPanel diskPartitionPanel = new JPanel();
		diskPartitionPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Partition Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		diskPartitionPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane diskPartitionScrollPane = new JScrollPane();
		diskPartitionPanel.add(diskPartitionScrollPane);
		
		diskPartitionEditorPane = new JEditorPane();
		diskPartitionEditorPane.setContentType("text/html");
		diskPartitionScrollPane.setViewportView(diskPartitionEditorPane);
		diskPartitionEditorPane.setEditable(false);
		
		// volume
		JPanel diskVolumePanel = new JPanel();
		diskVolumePanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Volume Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		diskVolumePanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane diskVolumeScrollPane = new JScrollPane();
		diskVolumePanel.add(diskVolumeScrollPane);
		
		diskVolumeEditorPane = new JEditorPane();
		diskVolumeEditorPane.setContentType("text/html");
		diskVolumeScrollPane.setViewportView(diskVolumeEditorPane);
		diskVolumeEditorPane.setEditable(false);
		
		// add panels to the tabbed pane
		diskPartitionAndVolumePane.addTab("Disk Partition", new FlatSVGIcon(WMIStoragePanelUI.class.getResource("/icons/tab_icons_material_green/DiskPartition.svg")), diskPartitionPanel, null);
		diskPartitionAndVolumePane.addTab("Logical Volume", new FlatSVGIcon(WMIStoragePanelUI.class.getResource("/icons/tab_icons_material_green/LogicalVolume.svg")), diskVolumePanel, null);
	}
	
	private void setWorker() {

		List<JTextField> storageFields = List.of(diskPnpDeviceIdTextField, diskCaptionTextField, diskModelTextField,
		diskFirmwareRevisionTextField, diskInterfaceTypeTextField, diskSerialNumberTextField, diskSizeTextField,
		diskPartitionsTextField, diskCapabilitiesTextField, diskStatusTextField);

		List<JEditorPane> editorPanes = List.of(diskPartitionEditorPane, diskVolumeEditorPane);

		new WMIStorageWorker(diskDeviceIdComboBox, storageFields, editorPanes).execute();
	}

}
