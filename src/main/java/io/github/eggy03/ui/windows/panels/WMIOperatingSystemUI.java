package io.github.eggy03.ui.windows.panels;

import io.github.eggy03.ui.windows.worker.WMIOperatingSystemWorker;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.SwingConstants;

public class WMIOperatingSystemUI extends JPanel {
	
	// OS
	private JComboBox<String> osCurrentOsComboBox;
	private JLabel osCoverLabel;
	
	private JTextField osCaptionTextField;
	private JTextField osVersionTextField;
	private JTextField osBuildNumberTextField;
	private JTextField osManufacturerTextField;
	private JTextField osArchitectureTextField;
	private JTextField osInstallDateTextField;
	private JTextField osLastBootupTimeTextField;
	private JTextField osSerialNumberTextField;
	private JTextField osLanguagesTextField;
	private JTextField osPrimaryTextField;
	private JTextField osDistributedTextField;
	private JTextField osPortableTextField;
	private JTextField osDeviceNameTextField;
	private JTextField osUserCountTextField;
	private JTextField osRegisteredUserTextField;
	private JTextField osSystemDriveTextField;
	private JTextField osWindowsDirectoryTextField;
	private JTextField osSystemDirectoryTextField;
	
	// User Account
	private JComboBox<String> userAccountSIDComboBox;

	private JTextField userNameTextField;
	private JTextField userCaptionTextField;
	private JTextField userDomainTextField;
	private JTextField userDescriptionTextField;
	private JTextField userPasswordRequiredTextField;
	private JTextField userPasswordChangeableTextField;
	private JTextField userPasswordExpiresTextField;
	private JTextField userLocalAccountTextField;
	private JTextField userDisabledTextField;
	private JTextField userLockedOutTextField;
	private JTextField userAccountTypeTextField;
	private JTextField userSIDTypeTextField;
	private JTextField userStatusTextField;
	
	public JPanel getPanel() {
		return this;
	}
	
	public WMIOperatingSystemUI() {
		setLayout(new BorderLayout(0, 0));
		
		setOsPanel();
		setUserPanel();
		setWorker();
	}
	
	private void setOsPanel() {
		JScrollPane operatingSystemScrollPane = new JScrollPane();
		add(operatingSystemScrollPane, BorderLayout.CENTER);
		
		JPanel operatingSystemPanel = new JPanel();
		operatingSystemScrollPane.setViewportView(operatingSystemPanel);
		operatingSystemPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Operating System", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gblOperatingSystemPanel = new GridBagLayout();
		gblOperatingSystemPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gblOperatingSystemPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gblOperatingSystemPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gblOperatingSystemPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		operatingSystemPanel.setLayout(gblOperatingSystemPanel);
		
		JLabel osCurrrentOsLabel = new JLabel("CurrentOS");
		GridBagConstraints gbcOsCurrrentOsLabel = new GridBagConstraints();
		gbcOsCurrrentOsLabel.insets = new Insets(0, 0, 5, 5);
		gbcOsCurrrentOsLabel.anchor = GridBagConstraints.WEST;
		gbcOsCurrrentOsLabel.gridx = 0;
		gbcOsCurrrentOsLabel.gridy = 0;
		operatingSystemPanel.add(osCurrrentOsLabel, gbcOsCurrrentOsLabel);
		
		osCurrentOsComboBox = new JComboBox<>();
		GridBagConstraints gbcOsCurrentOsComboBox = new GridBagConstraints();
		gbcOsCurrentOsComboBox.gridwidth = 5;
		gbcOsCurrentOsComboBox.insets = new Insets(0, 0, 5, 0);
		gbcOsCurrentOsComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbcOsCurrentOsComboBox.gridx = 1;
		gbcOsCurrentOsComboBox.gridy = 0;
		operatingSystemPanel.add(osCurrentOsComboBox, gbcOsCurrentOsComboBox);
		
		JLabel osCaptionLabel = new JLabel("Caption");
		GridBagConstraints gbcOsCaptionLabel = new GridBagConstraints();
		gbcOsCaptionLabel.anchor = GridBagConstraints.WEST;
		gbcOsCaptionLabel.insets = new Insets(0, 0, 5, 5);
		gbcOsCaptionLabel.gridx = 0;
		gbcOsCaptionLabel.gridy = 1;
		operatingSystemPanel.add(osCaptionLabel, gbcOsCaptionLabel);
		
		osCaptionTextField = new JTextField();
		osCaptionTextField.setEditable(false);
		GridBagConstraints gbcOsCaptionTextField = new GridBagConstraints();
		gbcOsCaptionTextField.gridwidth = 3;
		gbcOsCaptionTextField.insets = new Insets(0, 0, 5, 5);
		gbcOsCaptionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOsCaptionTextField.gridx = 1;
		gbcOsCaptionTextField.gridy = 1;
		operatingSystemPanel.add(osCaptionTextField, gbcOsCaptionTextField);
		osCaptionTextField.setColumns(10);
		
		JPanel osCoverPanel = new JPanel();
		osCoverPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), " OS Cover", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbcOsCoverPanel = new GridBagConstraints();
		gbcOsCoverPanel.fill = GridBagConstraints.BOTH;
		gbcOsCoverPanel.gridheight = 4;
		gbcOsCoverPanel.gridwidth = 2;
		gbcOsCoverPanel.insets = new Insets(0, 0, 5, 5);
		gbcOsCoverPanel.gridx = 4;
		gbcOsCoverPanel.gridy = 1;
		operatingSystemPanel.add(osCoverPanel, gbcOsCoverPanel);
		osCoverPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		osCoverLabel = new JLabel("");
		osCoverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		osCoverPanel.add(osCoverLabel);
		
		JLabel osVersionLabel = new JLabel("Version");
		GridBagConstraints gbcOsVersionLabel = new GridBagConstraints();
		gbcOsVersionLabel.anchor = GridBagConstraints.WEST;
		gbcOsVersionLabel.insets = new Insets(0, 0, 5, 5);
		gbcOsVersionLabel.gridx = 0;
		gbcOsVersionLabel.gridy = 2;
		operatingSystemPanel.add(osVersionLabel, gbcOsVersionLabel);
		
		osVersionTextField = new JTextField();
		osVersionTextField.setEditable(false);
		GridBagConstraints gbcOsVersionTextField = new GridBagConstraints();
		gbcOsVersionTextField.insets = new Insets(0, 0, 5, 5);
		gbcOsVersionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOsVersionTextField.gridx = 1;
		gbcOsVersionTextField.gridy = 2;
		operatingSystemPanel.add(osVersionTextField, gbcOsVersionTextField);
		osVersionTextField.setColumns(10);
		
		JLabel osBuildNumberLabel = new JLabel("Build Number");
		GridBagConstraints gbcOsBuildNumberLabel = new GridBagConstraints();
		gbcOsBuildNumberLabel.anchor = GridBagConstraints.WEST;
		gbcOsBuildNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbcOsBuildNumberLabel.gridx = 2;
		gbcOsBuildNumberLabel.gridy = 2;
		operatingSystemPanel.add(osBuildNumberLabel, gbcOsBuildNumberLabel);
		
		osBuildNumberTextField = new JTextField();
		osBuildNumberTextField.setEditable(false);
		GridBagConstraints gbcOsBuildNumberTextField = new GridBagConstraints();
		gbcOsBuildNumberTextField.insets = new Insets(0, 0, 5, 5);
		gbcOsBuildNumberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOsBuildNumberTextField.gridx = 3;
		gbcOsBuildNumberTextField.gridy = 2;
		operatingSystemPanel.add(osBuildNumberTextField, gbcOsBuildNumberTextField);
		osBuildNumberTextField.setColumns(10);
		
		JLabel osManufacturerLabel = new JLabel("Manufacturer");
		GridBagConstraints gbcOsManufacturerLabel = new GridBagConstraints();
		gbcOsManufacturerLabel.anchor = GridBagConstraints.WEST;
		gbcOsManufacturerLabel.insets = new Insets(0, 0, 5, 5);
		gbcOsManufacturerLabel.gridx = 0;
		gbcOsManufacturerLabel.gridy = 3;
		operatingSystemPanel.add(osManufacturerLabel, gbcOsManufacturerLabel);
		
		osManufacturerTextField = new JTextField();
		osManufacturerTextField.setEditable(false);
		GridBagConstraints gbcOsManufacturerTextField = new GridBagConstraints();
		gbcOsManufacturerTextField.insets = new Insets(0, 0, 5, 5);
		gbcOsManufacturerTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOsManufacturerTextField.gridx = 1;
		gbcOsManufacturerTextField.gridy = 3;
		operatingSystemPanel.add(osManufacturerTextField, gbcOsManufacturerTextField);
		osManufacturerTextField.setColumns(10);
		
		JLabel osArchitectureLabel = new JLabel("Architecture");
		GridBagConstraints gbcOsArchitectureLabel = new GridBagConstraints();
		gbcOsArchitectureLabel.anchor = GridBagConstraints.WEST;
		gbcOsArchitectureLabel.insets = new Insets(0, 0, 5, 5);
		gbcOsArchitectureLabel.gridx = 2;
		gbcOsArchitectureLabel.gridy = 3;
		operatingSystemPanel.add(osArchitectureLabel, gbcOsArchitectureLabel);
		
		osArchitectureTextField = new JTextField();
		osArchitectureTextField.setEditable(false);
		GridBagConstraints gbcOsArchitectureTextField = new GridBagConstraints();
		gbcOsArchitectureTextField.insets = new Insets(0, 0, 5, 5);
		gbcOsArchitectureTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOsArchitectureTextField.gridx = 3;
		gbcOsArchitectureTextField.gridy = 3;
		operatingSystemPanel.add(osArchitectureTextField, gbcOsArchitectureTextField);
		osArchitectureTextField.setColumns(10);
		
		JLabel osInstallDateLabel = new JLabel("Install Date");
		GridBagConstraints gbcOsInstallDateLabel = new GridBagConstraints();
		gbcOsInstallDateLabel.anchor = GridBagConstraints.WEST;
		gbcOsInstallDateLabel.insets = new Insets(0, 0, 5, 5);
		gbcOsInstallDateLabel.gridx = 0;
		gbcOsInstallDateLabel.gridy = 4;
		operatingSystemPanel.add(osInstallDateLabel, gbcOsInstallDateLabel);
		
		osInstallDateTextField = new JTextField();
		osInstallDateTextField.setEditable(false);
		GridBagConstraints gbcOsInstallDateTextField = new GridBagConstraints();
		gbcOsInstallDateTextField.insets = new Insets(0, 0, 5, 5);
		gbcOsInstallDateTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOsInstallDateTextField.gridx = 1;
		gbcOsInstallDateTextField.gridy = 4;
		operatingSystemPanel.add(osInstallDateTextField, gbcOsInstallDateTextField);
		osInstallDateTextField.setColumns(10);
		
		JLabel osLastBootupTimeLabel = new JLabel("Last Bootup Time");
		GridBagConstraints gbcOsLastBootupTimeLabel = new GridBagConstraints();
		gbcOsLastBootupTimeLabel.anchor = GridBagConstraints.WEST;
		gbcOsLastBootupTimeLabel.insets = new Insets(0, 0, 5, 5);
		gbcOsLastBootupTimeLabel.gridx = 2;
		gbcOsLastBootupTimeLabel.gridy = 4;
		operatingSystemPanel.add(osLastBootupTimeLabel, gbcOsLastBootupTimeLabel);
		
		osLastBootupTimeTextField = new JTextField();
		osLastBootupTimeTextField.setEditable(false);
		GridBagConstraints gbcOsLastBootupTimeTextField = new GridBagConstraints();
		gbcOsLastBootupTimeTextField.insets = new Insets(0, 0, 5, 5);
		gbcOsLastBootupTimeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOsLastBootupTimeTextField.gridx = 3;
		gbcOsLastBootupTimeTextField.gridy = 4;
		operatingSystemPanel.add(osLastBootupTimeTextField, gbcOsLastBootupTimeTextField);
		osLastBootupTimeTextField.setColumns(10);
		
		JLabel osSerialNumberLabel = new JLabel("Serial Number");
		GridBagConstraints gbcOsSerialNumberLabel = new GridBagConstraints();
		gbcOsSerialNumberLabel.anchor = GridBagConstraints.WEST;
		gbcOsSerialNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbcOsSerialNumberLabel.gridx = 0;
		gbcOsSerialNumberLabel.gridy = 5;
		operatingSystemPanel.add(osSerialNumberLabel, gbcOsSerialNumberLabel);
		
		osSerialNumberTextField = new JTextField();
		osSerialNumberTextField.setEditable(false);
		GridBagConstraints gbcOsSerialNumberTextField = new GridBagConstraints();
		gbcOsSerialNumberTextField.gridwidth = 3;
		gbcOsSerialNumberTextField.insets = new Insets(0, 0, 5, 5);
		gbcOsSerialNumberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOsSerialNumberTextField.gridx = 1;
		gbcOsSerialNumberTextField.gridy = 5;
		operatingSystemPanel.add(osSerialNumberTextField, gbcOsSerialNumberTextField);
		osSerialNumberTextField.setColumns(10);
		
		JLabel osLanguagesLabel = new JLabel("Languages");
		GridBagConstraints gbcOsLanguagesLabel = new GridBagConstraints();
		gbcOsLanguagesLabel.anchor = GridBagConstraints.WEST;
		gbcOsLanguagesLabel.insets = new Insets(0, 0, 5, 5);
		gbcOsLanguagesLabel.gridx = 4;
		gbcOsLanguagesLabel.gridy = 5;
		operatingSystemPanel.add(osLanguagesLabel, gbcOsLanguagesLabel);
		
		osLanguagesTextField = new JTextField();
		osLanguagesTextField.setEditable(false);
		GridBagConstraints gbcOsLanguagesTextField = new GridBagConstraints();
		gbcOsLanguagesTextField.insets = new Insets(0, 0, 5, 0);
		gbcOsLanguagesTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOsLanguagesTextField.gridx = 5;
		gbcOsLanguagesTextField.gridy = 5;
		operatingSystemPanel.add(osLanguagesTextField, gbcOsLanguagesTextField);
		osLanguagesTextField.setColumns(10);
		
		JLabel osPrimaryLabel = new JLabel("Primary");
		GridBagConstraints gbcOsPrimaryLabel = new GridBagConstraints();
		gbcOsPrimaryLabel.anchor = GridBagConstraints.WEST;
		gbcOsPrimaryLabel.insets = new Insets(0, 0, 5, 5);
		gbcOsPrimaryLabel.gridx = 0;
		gbcOsPrimaryLabel.gridy = 6;
		operatingSystemPanel.add(osPrimaryLabel, gbcOsPrimaryLabel);
		
		osPrimaryTextField = new JTextField();
		osPrimaryTextField.setEditable(false);
		GridBagConstraints gbcOsPrimaryTextField = new GridBagConstraints();
		gbcOsPrimaryTextField.insets = new Insets(0, 0, 5, 5);
		gbcOsPrimaryTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOsPrimaryTextField.gridx = 1;
		gbcOsPrimaryTextField.gridy = 6;
		operatingSystemPanel.add(osPrimaryTextField, gbcOsPrimaryTextField);
		osPrimaryTextField.setColumns(10);
		
		JLabel osDistributedLabel = new JLabel("Distributed");
		GridBagConstraints gbcOsDistributedLabel = new GridBagConstraints();
		gbcOsDistributedLabel.anchor = GridBagConstraints.WEST;
		gbcOsDistributedLabel.insets = new Insets(0, 0, 5, 5);
		gbcOsDistributedLabel.gridx = 2;
		gbcOsDistributedLabel.gridy = 6;
		operatingSystemPanel.add(osDistributedLabel, gbcOsDistributedLabel);
		
		osDistributedTextField = new JTextField();
		osDistributedTextField.setEditable(false);
		GridBagConstraints gbcOsDistributedTextField = new GridBagConstraints();
		gbcOsDistributedTextField.insets = new Insets(0, 0, 5, 5);
		gbcOsDistributedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOsDistributedTextField.gridx = 3;
		gbcOsDistributedTextField.gridy = 6;
		operatingSystemPanel.add(osDistributedTextField, gbcOsDistributedTextField);
		osDistributedTextField.setColumns(10);
		
		JLabel osPortableLabel = new JLabel("Portable");
		GridBagConstraints gbcOsPortableLabel = new GridBagConstraints();
		gbcOsPortableLabel.anchor = GridBagConstraints.WEST;
		gbcOsPortableLabel.insets = new Insets(0, 0, 5, 5);
		gbcOsPortableLabel.gridx = 4;
		gbcOsPortableLabel.gridy = 6;
		operatingSystemPanel.add(osPortableLabel, gbcOsPortableLabel);
		
		osPortableTextField = new JTextField();
		osPortableTextField.setEditable(false);
		GridBagConstraints gbcOsPortableTextField = new GridBagConstraints();
		gbcOsPortableTextField.insets = new Insets(0, 0, 5, 0);
		gbcOsPortableTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOsPortableTextField.gridx = 5;
		gbcOsPortableTextField.gridy = 6;
		operatingSystemPanel.add(osPortableTextField, gbcOsPortableTextField);
		osPortableTextField.setColumns(10);
		
		JLabel osDeviceNameLabel = new JLabel("Device Name");
		GridBagConstraints gbcOsDeviceNameLabel = new GridBagConstraints();
		gbcOsDeviceNameLabel.anchor = GridBagConstraints.WEST;
		gbcOsDeviceNameLabel.insets = new Insets(0, 0, 5, 5);
		gbcOsDeviceNameLabel.gridx = 0;
		gbcOsDeviceNameLabel.gridy = 7;
		operatingSystemPanel.add(osDeviceNameLabel, gbcOsDeviceNameLabel);
		
		osDeviceNameTextField = new JTextField();
		osDeviceNameTextField.setEditable(false);
		GridBagConstraints gbcOsDeviceNameTextField = new GridBagConstraints();
		gbcOsDeviceNameTextField.insets = new Insets(0, 0, 5, 5);
		gbcOsDeviceNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOsDeviceNameTextField.gridx = 1;
		gbcOsDeviceNameTextField.gridy = 7;
		operatingSystemPanel.add(osDeviceNameTextField, gbcOsDeviceNameTextField);
		osDeviceNameTextField.setColumns(10);
		
		JLabel osUserCountLabel = new JLabel("User Count");
		GridBagConstraints gbcOsUserCountLabel = new GridBagConstraints();
		gbcOsUserCountLabel.anchor = GridBagConstraints.WEST;
		gbcOsUserCountLabel.insets = new Insets(0, 0, 5, 5);
		gbcOsUserCountLabel.gridx = 2;
		gbcOsUserCountLabel.gridy = 7;
		operatingSystemPanel.add(osUserCountLabel, gbcOsUserCountLabel);
		
		osUserCountTextField = new JTextField();
		osUserCountTextField.setEditable(false);
		GridBagConstraints gbcOsUserCountTextField = new GridBagConstraints();
		gbcOsUserCountTextField.insets = new Insets(0, 0, 5, 5);
		gbcOsUserCountTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOsUserCountTextField.gridx = 3;
		gbcOsUserCountTextField.gridy = 7;
		operatingSystemPanel.add(osUserCountTextField, gbcOsUserCountTextField);
		osUserCountTextField.setColumns(10);
		
		JLabel osRegisteredUserLabel = new JLabel("Registered User");
		GridBagConstraints gbcOsRegisteredUserLabel = new GridBagConstraints();
		gbcOsRegisteredUserLabel.anchor = GridBagConstraints.WEST;
		gbcOsRegisteredUserLabel.insets = new Insets(0, 0, 5, 5);
		gbcOsRegisteredUserLabel.gridx = 4;
		gbcOsRegisteredUserLabel.gridy = 7;
		operatingSystemPanel.add(osRegisteredUserLabel, gbcOsRegisteredUserLabel);
		
		osRegisteredUserTextField = new JTextField();
		osRegisteredUserTextField.setEditable(false);
		GridBagConstraints gbcOsRegisteredUserTextField = new GridBagConstraints();
		gbcOsRegisteredUserTextField.insets = new Insets(0, 0, 5, 0);
		gbcOsRegisteredUserTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOsRegisteredUserTextField.gridx = 5;
		gbcOsRegisteredUserTextField.gridy = 7;
		operatingSystemPanel.add(osRegisteredUserTextField, gbcOsRegisteredUserTextField);
		osRegisteredUserTextField.setColumns(10);
		
		JLabel osSystemDriveLabel = new JLabel("System Drive");
		GridBagConstraints gbcOsSystemDriveLabel = new GridBagConstraints();
		gbcOsSystemDriveLabel.anchor = GridBagConstraints.WEST;
		gbcOsSystemDriveLabel.insets = new Insets(0, 0, 0, 5);
		gbcOsSystemDriveLabel.gridx = 0;
		gbcOsSystemDriveLabel.gridy = 8;
		operatingSystemPanel.add(osSystemDriveLabel, gbcOsSystemDriveLabel);
		
		osSystemDriveTextField = new JTextField();
		osSystemDriveTextField.setEditable(false);
		GridBagConstraints gbcOsSystemDriveTextField = new GridBagConstraints();
		gbcOsSystemDriveTextField.insets = new Insets(0, 0, 0, 5);
		gbcOsSystemDriveTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOsSystemDriveTextField.gridx = 1;
		gbcOsSystemDriveTextField.gridy = 8;
		operatingSystemPanel.add(osSystemDriveTextField, gbcOsSystemDriveTextField);
		osSystemDriveTextField.setColumns(10);
		
		JLabel osWindowsDirectoryLabel = new JLabel("Windows Directory");
		GridBagConstraints gbcOsWindowsDirectoryLabel = new GridBagConstraints();
		gbcOsWindowsDirectoryLabel.anchor = GridBagConstraints.WEST;
		gbcOsWindowsDirectoryLabel.insets = new Insets(0, 0, 0, 5);
		gbcOsWindowsDirectoryLabel.gridx = 2;
		gbcOsWindowsDirectoryLabel.gridy = 8;
		operatingSystemPanel.add(osWindowsDirectoryLabel, gbcOsWindowsDirectoryLabel);
		
		osWindowsDirectoryTextField = new JTextField();
		osWindowsDirectoryTextField.setEditable(false);
		GridBagConstraints gbcOsWindowsDirectoryTextField = new GridBagConstraints();
		gbcOsWindowsDirectoryTextField.insets = new Insets(0, 0, 0, 5);
		gbcOsWindowsDirectoryTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOsWindowsDirectoryTextField.gridx = 3;
		gbcOsWindowsDirectoryTextField.gridy = 8;
		operatingSystemPanel.add(osWindowsDirectoryTextField, gbcOsWindowsDirectoryTextField);
		osWindowsDirectoryTextField.setColumns(10);
		
		JLabel osSystemDirectoryLabel = new JLabel("System Directory");
		GridBagConstraints gbcOsSystemDirectoryLabel = new GridBagConstraints();
		gbcOsSystemDirectoryLabel.anchor = GridBagConstraints.WEST;
		gbcOsSystemDirectoryLabel.insets = new Insets(0, 0, 0, 5);
		gbcOsSystemDirectoryLabel.gridx = 4;
		gbcOsSystemDirectoryLabel.gridy = 8;
		operatingSystemPanel.add(osSystemDirectoryLabel, gbcOsSystemDirectoryLabel);
		
		osSystemDirectoryTextField = new JTextField();
		osSystemDirectoryTextField.setEditable(false);
		GridBagConstraints gbcOsSystemDirectoryTextField = new GridBagConstraints();
		gbcOsSystemDirectoryTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOsSystemDirectoryTextField.gridx = 5;
		gbcOsSystemDirectoryTextField.gridy = 8;
		operatingSystemPanel.add(osSystemDirectoryTextField, gbcOsSystemDirectoryTextField);
		osSystemDirectoryTextField.setColumns(10);
		
	}
	
	private void setUserPanel() {
		JScrollPane userScrollPane = new JScrollPane();
		add(userScrollPane, BorderLayout.SOUTH);
		
		JPanel userPanel = new JPanel();
		userScrollPane.setViewportView(userPanel);
		userPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "User", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gblUserPanel = new GridBagLayout();
		gblUserPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gblUserPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gblUserPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gblUserPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		userPanel.setLayout(gblUserPanel);
		
		JLabel userSIDLabel = new JLabel("SID");
		GridBagConstraints gbcUserSIDLabel = new GridBagConstraints();
		gbcUserSIDLabel.insets = new Insets(0, 0, 5, 5);
		gbcUserSIDLabel.anchor = GridBagConstraints.WEST;
		gbcUserSIDLabel.gridx = 0;
		gbcUserSIDLabel.gridy = 0;
		userPanel.add(userSIDLabel, gbcUserSIDLabel);
		
		userAccountSIDComboBox = new JComboBox<>();
		GridBagConstraints gbcUserSIDComboBox = new GridBagConstraints();
		gbcUserSIDComboBox.gridwidth = 5;
		gbcUserSIDComboBox.insets = new Insets(0, 0, 5, 0);
		gbcUserSIDComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbcUserSIDComboBox.gridx = 1;
		gbcUserSIDComboBox.gridy = 0;
		userPanel.add(userAccountSIDComboBox, gbcUserSIDComboBox);
		
		JLabel userNameLabel = new JLabel("Name");
		GridBagConstraints gbcUserNameLabel = new GridBagConstraints();
		gbcUserNameLabel.anchor = GridBagConstraints.WEST;
		gbcUserNameLabel.insets = new Insets(0, 0, 5, 5);
		gbcUserNameLabel.gridx = 0;
		gbcUserNameLabel.gridy = 1;
		userPanel.add(userNameLabel, gbcUserNameLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setEditable(false);
		GridBagConstraints gbcUserNameTextField = new GridBagConstraints();
		gbcUserNameTextField.insets = new Insets(0, 0, 5, 5);
		gbcUserNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcUserNameTextField.gridx = 1;
		gbcUserNameTextField.gridy = 1;
		userPanel.add(userNameTextField, gbcUserNameTextField);
		userNameTextField.setColumns(10);
		
		JLabel userCaptionLabel = new JLabel("Caption");
		GridBagConstraints gbcUserCaptionLabel = new GridBagConstraints();
		gbcUserCaptionLabel.insets = new Insets(0, 0, 5, 5);
		gbcUserCaptionLabel.anchor = GridBagConstraints.WEST;
		gbcUserCaptionLabel.gridx = 2;
		gbcUserCaptionLabel.gridy = 1;
		userPanel.add(userCaptionLabel, gbcUserCaptionLabel);
		
		userCaptionTextField = new JTextField();
		userCaptionTextField.setEditable(false);
		GridBagConstraints gbcUserCaptionTextField = new GridBagConstraints();
		gbcUserCaptionTextField.insets = new Insets(0, 0, 5, 5);
		gbcUserCaptionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcUserCaptionTextField.gridx = 3;
		gbcUserCaptionTextField.gridy = 1;
		userPanel.add(userCaptionTextField, gbcUserCaptionTextField);
		userCaptionTextField.setColumns(10);
		
		JLabel userDomainLabel = new JLabel("Domain");
		GridBagConstraints gbcUserDomainLabel = new GridBagConstraints();
		gbcUserDomainLabel.insets = new Insets(0, 0, 5, 5);
		gbcUserDomainLabel.anchor = GridBagConstraints.WEST;
		gbcUserDomainLabel.gridx = 4;
		gbcUserDomainLabel.gridy = 1;
		userPanel.add(userDomainLabel, gbcUserDomainLabel);
		
		userDomainTextField = new JTextField();
		userDomainTextField.setEditable(false);
		GridBagConstraints gbcUserDomainTextField = new GridBagConstraints();
		gbcUserDomainTextField.insets = new Insets(0, 0, 5, 0);
		gbcUserDomainTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcUserDomainTextField.gridx = 5;
		gbcUserDomainTextField.gridy = 1;
		userPanel.add(userDomainTextField, gbcUserDomainTextField);
		userDomainTextField.setColumns(10);
		
		JLabel userDescriptionLabel = new JLabel("Description");
		GridBagConstraints gbcUserDescriptionLabel = new GridBagConstraints();
		gbcUserDescriptionLabel.anchor = GridBagConstraints.WEST;
		gbcUserDescriptionLabel.insets = new Insets(0, 0, 5, 5);
		gbcUserDescriptionLabel.gridx = 0;
		gbcUserDescriptionLabel.gridy = 2;
		userPanel.add(userDescriptionLabel, gbcUserDescriptionLabel);
		
		userDescriptionTextField = new JTextField();
		userDescriptionTextField.setEditable(false);
		GridBagConstraints gbcUserDescriptionTextField = new GridBagConstraints();
		gbcUserDescriptionTextField.insets = new Insets(0, 0, 5, 0);
		gbcUserDescriptionTextField.gridwidth = 5;
		gbcUserDescriptionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcUserDescriptionTextField.gridx = 1;
		gbcUserDescriptionTextField.gridy = 2;
		userPanel.add(userDescriptionTextField, gbcUserDescriptionTextField);
		userDescriptionTextField.setColumns(10);
		
		JLabel userPasswordRequiredLabel = new JLabel("Password Required");
		GridBagConstraints gbcUserPasswordRequiredLabel = new GridBagConstraints();
		gbcUserPasswordRequiredLabel.anchor = GridBagConstraints.WEST;
		gbcUserPasswordRequiredLabel.insets = new Insets(0, 0, 5, 5);
		gbcUserPasswordRequiredLabel.gridx = 0;
		gbcUserPasswordRequiredLabel.gridy = 3;
		userPanel.add(userPasswordRequiredLabel, gbcUserPasswordRequiredLabel);
		
		userPasswordRequiredTextField = new JTextField();
		userPasswordRequiredTextField.setEditable(false);
		GridBagConstraints gbcUserPasswordRequiredTextField = new GridBagConstraints();
		gbcUserPasswordRequiredTextField.insets = new Insets(0, 0, 5, 5);
		gbcUserPasswordRequiredTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcUserPasswordRequiredTextField.gridx = 1;
		gbcUserPasswordRequiredTextField.gridy = 3;
		userPanel.add(userPasswordRequiredTextField, gbcUserPasswordRequiredTextField);
		userPasswordRequiredTextField.setColumns(10);
		
		JLabel userPasswordChangeableLabel = new JLabel("Password Changeable");
		GridBagConstraints gbcUserPasswordChangeableLabel = new GridBagConstraints();
		gbcUserPasswordChangeableLabel.anchor = GridBagConstraints.WEST;
		gbcUserPasswordChangeableLabel.insets = new Insets(0, 0, 5, 5);
		gbcUserPasswordChangeableLabel.gridx = 2;
		gbcUserPasswordChangeableLabel.gridy = 3;
		userPanel.add(userPasswordChangeableLabel, gbcUserPasswordChangeableLabel);
		
		userPasswordChangeableTextField = new JTextField();
		userPasswordChangeableTextField.setEditable(false);
		GridBagConstraints gbcUserPasswordChangeableTextField = new GridBagConstraints();
		gbcUserPasswordChangeableTextField.insets = new Insets(0, 0, 5, 5);
		gbcUserPasswordChangeableTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcUserPasswordChangeableTextField.gridx = 3;
		gbcUserPasswordChangeableTextField.gridy = 3;
		userPanel.add(userPasswordChangeableTextField, gbcUserPasswordChangeableTextField);
		userPasswordChangeableTextField.setColumns(10);
		
		JLabel userPasswordExpiresLabel = new JLabel("Password Expires");
		GridBagConstraints gbcUserPasswordExpiresLabel = new GridBagConstraints();
		gbcUserPasswordExpiresLabel.anchor = GridBagConstraints.WEST;
		gbcUserPasswordExpiresLabel.insets = new Insets(0, 0, 5, 5);
		gbcUserPasswordExpiresLabel.gridx = 4;
		gbcUserPasswordExpiresLabel.gridy = 3;
		userPanel.add(userPasswordExpiresLabel, gbcUserPasswordExpiresLabel);
		
		userPasswordExpiresTextField = new JTextField();
		userPasswordExpiresTextField.setEditable(false);
		GridBagConstraints gbcUserPasswordExpiresTextField = new GridBagConstraints();
		gbcUserPasswordExpiresTextField.insets = new Insets(0, 0, 5, 0);
		gbcUserPasswordExpiresTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcUserPasswordExpiresTextField.gridx = 5;
		gbcUserPasswordExpiresTextField.gridy = 3;
		userPanel.add(userPasswordExpiresTextField, gbcUserPasswordExpiresTextField);
		userPasswordExpiresTextField.setColumns(10);
		
		JLabel userLocalAccountLabel = new JLabel("Local Account");
		GridBagConstraints gbcUserLocalAccountLabel = new GridBagConstraints();
		gbcUserLocalAccountLabel.anchor = GridBagConstraints.WEST;
		gbcUserLocalAccountLabel.insets = new Insets(0, 0, 5, 5);
		gbcUserLocalAccountLabel.gridx = 0;
		gbcUserLocalAccountLabel.gridy = 4;
		userPanel.add(userLocalAccountLabel, gbcUserLocalAccountLabel);
		
		userLocalAccountTextField = new JTextField();
		userLocalAccountTextField.setEditable(false);
		GridBagConstraints gbcUserLocalAccountTextField = new GridBagConstraints();
		gbcUserLocalAccountTextField.insets = new Insets(0, 0, 5, 5);
		gbcUserLocalAccountTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcUserLocalAccountTextField.gridx = 1;
		gbcUserLocalAccountTextField.gridy = 4;
		userPanel.add(userLocalAccountTextField, gbcUserLocalAccountTextField);
		userLocalAccountTextField.setColumns(10);
		
		JLabel userDisabledLabel = new JLabel("Disabled");
		GridBagConstraints gbcUserDisabledLabel = new GridBagConstraints();
		gbcUserDisabledLabel.anchor = GridBagConstraints.WEST;
		gbcUserDisabledLabel.insets = new Insets(0, 0, 5, 5);
		gbcUserDisabledLabel.gridx = 2;
		gbcUserDisabledLabel.gridy = 4;
		userPanel.add(userDisabledLabel, gbcUserDisabledLabel);
		
		userDisabledTextField = new JTextField();
		userDisabledTextField.setEditable(false);
		GridBagConstraints gbcUserDisabledTextField = new GridBagConstraints();
		gbcUserDisabledTextField.insets = new Insets(0, 0, 5, 5);
		gbcUserDisabledTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcUserDisabledTextField.gridx = 3;
		gbcUserDisabledTextField.gridy = 4;
		userPanel.add(userDisabledTextField, gbcUserDisabledTextField);
		userDisabledTextField.setColumns(10);
		
		JLabel userLockedOutLabel = new JLabel("Locked Out");
		GridBagConstraints gbcUserLockedOutLabel = new GridBagConstraints();
		gbcUserLockedOutLabel.anchor = GridBagConstraints.WEST;
		gbcUserLockedOutLabel.insets = new Insets(0, 0, 5, 5);
		gbcUserLockedOutLabel.gridx = 4;
		gbcUserLockedOutLabel.gridy = 4;
		userPanel.add(userLockedOutLabel, gbcUserLockedOutLabel);
		
		userLockedOutTextField = new JTextField();
		userLockedOutTextField.setEditable(false);
		GridBagConstraints gbcUserLockedOutTextField = new GridBagConstraints();
		gbcUserLockedOutTextField.insets = new Insets(0, 0, 5, 0);
		gbcUserLockedOutTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcUserLockedOutTextField.gridx = 5;
		gbcUserLockedOutTextField.gridy = 4;
		userPanel.add(userLockedOutTextField, gbcUserLockedOutTextField);
		userLockedOutTextField.setColumns(10);
		
		JLabel userAccountTypeLabel = new JLabel("Account Type");
		GridBagConstraints gbcUserAccountTypeLabel = new GridBagConstraints();
		gbcUserAccountTypeLabel.anchor = GridBagConstraints.WEST;
		gbcUserAccountTypeLabel.insets = new Insets(0, 0, 0, 5);
		gbcUserAccountTypeLabel.gridx = 0;
		gbcUserAccountTypeLabel.gridy = 5;
		userPanel.add(userAccountTypeLabel, gbcUserAccountTypeLabel);
		
		userAccountTypeTextField = new JTextField();
		userAccountTypeTextField.setEditable(false);
		GridBagConstraints gbcUserAccountTypeTextField = new GridBagConstraints();
		gbcUserAccountTypeTextField.insets = new Insets(0, 0, 0, 5);
		gbcUserAccountTypeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcUserAccountTypeTextField.gridx = 1;
		gbcUserAccountTypeTextField.gridy = 5;
		userPanel.add(userAccountTypeTextField, gbcUserAccountTypeTextField);
		userAccountTypeTextField.setColumns(10);
		
		JLabel userSIDTypeLabel = new JLabel("SID Type");
		GridBagConstraints gbcUserSIDTypeLabel = new GridBagConstraints();
		gbcUserSIDTypeLabel.anchor = GridBagConstraints.WEST;
		gbcUserSIDTypeLabel.insets = new Insets(0, 0, 0, 5);
		gbcUserSIDTypeLabel.gridx = 2;
		gbcUserSIDTypeLabel.gridy = 5;
		userPanel.add(userSIDTypeLabel, gbcUserSIDTypeLabel);
		
		userSIDTypeTextField = new JTextField();
		userSIDTypeTextField.setEditable(false);
		GridBagConstraints gbcUserSIDTypeTextField = new GridBagConstraints();
		gbcUserSIDTypeTextField.insets = new Insets(0, 0, 0, 5);
		gbcUserSIDTypeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcUserSIDTypeTextField.gridx = 3;
		gbcUserSIDTypeTextField.gridy = 5;
		userPanel.add(userSIDTypeTextField, gbcUserSIDTypeTextField);
		userSIDTypeTextField.setColumns(10);
		
		JLabel userStatusLabel = new JLabel("Status");
		GridBagConstraints gbcUserStatusLabel = new GridBagConstraints();
		gbcUserStatusLabel.anchor = GridBagConstraints.WEST;
		gbcUserStatusLabel.insets = new Insets(0, 0, 0, 5);
		gbcUserStatusLabel.gridx = 4;
		gbcUserStatusLabel.gridy = 5;
		userPanel.add(userStatusLabel, gbcUserStatusLabel);
		
		userStatusTextField = new JTextField();
		userStatusTextField.setEditable(false);
		GridBagConstraints gbcUserStatusTextField = new GridBagConstraints();
		gbcUserStatusTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcUserStatusTextField.gridx = 5;
		gbcUserStatusTextField.gridy = 5;
		userPanel.add(userStatusTextField, gbcUserStatusTextField);
		userStatusTextField.setColumns(10);
	}
	
	private void setWorker() {

		List<JTextField> osFields = List.of(osCaptionTextField, osVersionTextField, osBuildNumberTextField,
		osManufacturerTextField, osArchitectureTextField, osInstallDateTextField, osLastBootupTimeTextField,
		osSerialNumberTextField, osLanguagesTextField, osPrimaryTextField, osDistributedTextField,
		osPortableTextField, osDeviceNameTextField, osUserCountTextField, osRegisteredUserTextField,
		osSystemDriveTextField, osWindowsDirectoryTextField, osSystemDirectoryTextField);
		
		new WMIOperatingSystemWorker(osCurrentOsComboBox, osFields, osCoverLabel).execute();

		List<JTextField> userAccountFields = List.of(userNameTextField, userCaptionTextField, userDomainTextField,
		userDescriptionTextField, userPasswordRequiredTextField, userPasswordChangeableTextField,
		userPasswordExpiresTextField, userLocalAccountTextField, userDisabledTextField,
		userLockedOutTextField, userAccountTypeTextField, userSIDTypeTextField, userStatusTextField);

		new WMIUserAccountWorker(userAccountSIDComboBox, userAccountFields).execute();
		
	}

}
