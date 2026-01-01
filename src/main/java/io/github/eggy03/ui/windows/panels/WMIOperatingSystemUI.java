package io.github.eggy03.ui.windows.panels;

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
	private JComboBox<String> userSIDComboBox;
	private JTextField userNameTextField;
	private JTextField userCaptionTextField;
	private JTextField userDomainTextField;
	private JTextField userDescriptionTextField;
	private JTextField userPassowrdRequiredTextField;
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
		GridBagLayout gbl_operatingSystemPanel = new GridBagLayout();
		gbl_operatingSystemPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_operatingSystemPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_operatingSystemPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_operatingSystemPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		operatingSystemPanel.setLayout(gbl_operatingSystemPanel);
		
		JLabel osCurrrentOsLabel = new JLabel("CurrentOS");
		GridBagConstraints gbc_osCurrrentOsLabel = new GridBagConstraints();
		gbc_osCurrrentOsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_osCurrrentOsLabel.anchor = GridBagConstraints.WEST;
		gbc_osCurrrentOsLabel.gridx = 0;
		gbc_osCurrrentOsLabel.gridy = 0;
		operatingSystemPanel.add(osCurrrentOsLabel, gbc_osCurrrentOsLabel);
		
		osCurrentOsComboBox = new JComboBox<>();
		GridBagConstraints gbc_osCurrentOsComboBox = new GridBagConstraints();
		gbc_osCurrentOsComboBox.gridwidth = 5;
		gbc_osCurrentOsComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_osCurrentOsComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_osCurrentOsComboBox.gridx = 1;
		gbc_osCurrentOsComboBox.gridy = 0;
		operatingSystemPanel.add(osCurrentOsComboBox, gbc_osCurrentOsComboBox);
		
		JLabel osCaptionLabel = new JLabel("Caption");
		GridBagConstraints gbc_osCaptionLabel = new GridBagConstraints();
		gbc_osCaptionLabel.anchor = GridBagConstraints.WEST;
		gbc_osCaptionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_osCaptionLabel.gridx = 0;
		gbc_osCaptionLabel.gridy = 1;
		operatingSystemPanel.add(osCaptionLabel, gbc_osCaptionLabel);
		
		osCaptionTextField = new JTextField();
		osCaptionTextField.setEditable(false);
		GridBagConstraints gbc_osCaptionTextField = new GridBagConstraints();
		gbc_osCaptionTextField.gridwidth = 3;
		gbc_osCaptionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_osCaptionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_osCaptionTextField.gridx = 1;
		gbc_osCaptionTextField.gridy = 1;
		operatingSystemPanel.add(osCaptionTextField, gbc_osCaptionTextField);
		osCaptionTextField.setColumns(10);
		
		JPanel osCoverPanel = new JPanel();
		osCoverPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), " OS Cover", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_osCoverPanel = new GridBagConstraints();
		gbc_osCoverPanel.fill = GridBagConstraints.BOTH;
		gbc_osCoverPanel.gridheight = 4;
		gbc_osCoverPanel.gridwidth = 2;
		gbc_osCoverPanel.insets = new Insets(0, 0, 5, 5);
		gbc_osCoverPanel.gridx = 4;
		gbc_osCoverPanel.gridy = 1;
		operatingSystemPanel.add(osCoverPanel, gbc_osCoverPanel);
		osCoverPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		osCoverLabel = new JLabel("");
		osCoverPanel.add(osCoverLabel);
		
		JLabel osVersionLabel = new JLabel("Version");
		GridBagConstraints gbc_osVersionLabel = new GridBagConstraints();
		gbc_osVersionLabel.anchor = GridBagConstraints.WEST;
		gbc_osVersionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_osVersionLabel.gridx = 0;
		gbc_osVersionLabel.gridy = 2;
		operatingSystemPanel.add(osVersionLabel, gbc_osVersionLabel);
		
		osVersionTextField = new JTextField();
		osVersionTextField.setEditable(false);
		GridBagConstraints gbc_osVersionTextField = new GridBagConstraints();
		gbc_osVersionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_osVersionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_osVersionTextField.gridx = 1;
		gbc_osVersionTextField.gridy = 2;
		operatingSystemPanel.add(osVersionTextField, gbc_osVersionTextField);
		osVersionTextField.setColumns(10);
		
		JLabel osBuildNumberLabel = new JLabel("Build Number");
		GridBagConstraints gbc_osBuildNumberLabel = new GridBagConstraints();
		gbc_osBuildNumberLabel.anchor = GridBagConstraints.WEST;
		gbc_osBuildNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_osBuildNumberLabel.gridx = 2;
		gbc_osBuildNumberLabel.gridy = 2;
		operatingSystemPanel.add(osBuildNumberLabel, gbc_osBuildNumberLabel);
		
		osBuildNumberTextField = new JTextField();
		osBuildNumberTextField.setEditable(false);
		GridBagConstraints gbc_osBuildNumberTextField = new GridBagConstraints();
		gbc_osBuildNumberTextField.insets = new Insets(0, 0, 5, 5);
		gbc_osBuildNumberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_osBuildNumberTextField.gridx = 3;
		gbc_osBuildNumberTextField.gridy = 2;
		operatingSystemPanel.add(osBuildNumberTextField, gbc_osBuildNumberTextField);
		osBuildNumberTextField.setColumns(10);
		
		JLabel osManufacturerLabel = new JLabel("Manufacturer");
		GridBagConstraints gbc_osManufacturerLabel = new GridBagConstraints();
		gbc_osManufacturerLabel.anchor = GridBagConstraints.WEST;
		gbc_osManufacturerLabel.insets = new Insets(0, 0, 5, 5);
		gbc_osManufacturerLabel.gridx = 0;
		gbc_osManufacturerLabel.gridy = 3;
		operatingSystemPanel.add(osManufacturerLabel, gbc_osManufacturerLabel);
		
		osManufacturerTextField = new JTextField();
		osManufacturerTextField.setEditable(false);
		GridBagConstraints gbc_osManufacturerTextField = new GridBagConstraints();
		gbc_osManufacturerTextField.insets = new Insets(0, 0, 5, 5);
		gbc_osManufacturerTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_osManufacturerTextField.gridx = 1;
		gbc_osManufacturerTextField.gridy = 3;
		operatingSystemPanel.add(osManufacturerTextField, gbc_osManufacturerTextField);
		osManufacturerTextField.setColumns(10);
		
		JLabel osArchitectureLabel = new JLabel("Architecture");
		GridBagConstraints gbc_osArchitectureLabel = new GridBagConstraints();
		gbc_osArchitectureLabel.anchor = GridBagConstraints.WEST;
		gbc_osArchitectureLabel.insets = new Insets(0, 0, 5, 5);
		gbc_osArchitectureLabel.gridx = 2;
		gbc_osArchitectureLabel.gridy = 3;
		operatingSystemPanel.add(osArchitectureLabel, gbc_osArchitectureLabel);
		
		osArchitectureTextField = new JTextField();
		osArchitectureTextField.setEditable(false);
		GridBagConstraints gbc_osArchitectureTextField = new GridBagConstraints();
		gbc_osArchitectureTextField.insets = new Insets(0, 0, 5, 5);
		gbc_osArchitectureTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_osArchitectureTextField.gridx = 3;
		gbc_osArchitectureTextField.gridy = 3;
		operatingSystemPanel.add(osArchitectureTextField, gbc_osArchitectureTextField);
		osArchitectureTextField.setColumns(10);
		
		JLabel osInstallDateLabel = new JLabel("Install Date");
		GridBagConstraints gbc_osInstallDateLabel = new GridBagConstraints();
		gbc_osInstallDateLabel.anchor = GridBagConstraints.WEST;
		gbc_osInstallDateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_osInstallDateLabel.gridx = 0;
		gbc_osInstallDateLabel.gridy = 4;
		operatingSystemPanel.add(osInstallDateLabel, gbc_osInstallDateLabel);
		
		osInstallDateTextField = new JTextField();
		osInstallDateTextField.setEditable(false);
		GridBagConstraints gbc_osInstallDateTextField = new GridBagConstraints();
		gbc_osInstallDateTextField.insets = new Insets(0, 0, 5, 5);
		gbc_osInstallDateTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_osInstallDateTextField.gridx = 1;
		gbc_osInstallDateTextField.gridy = 4;
		operatingSystemPanel.add(osInstallDateTextField, gbc_osInstallDateTextField);
		osInstallDateTextField.setColumns(10);
		
		JLabel osLastBootupTimeLabel = new JLabel("Last Bootup Time");
		GridBagConstraints gbc_osLastBootupTimeLabel = new GridBagConstraints();
		gbc_osLastBootupTimeLabel.anchor = GridBagConstraints.WEST;
		gbc_osLastBootupTimeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_osLastBootupTimeLabel.gridx = 2;
		gbc_osLastBootupTimeLabel.gridy = 4;
		operatingSystemPanel.add(osLastBootupTimeLabel, gbc_osLastBootupTimeLabel);
		
		osLastBootupTimeTextField = new JTextField();
		osLastBootupTimeTextField.setEditable(false);
		GridBagConstraints gbc_osLastBootupTimeTextField = new GridBagConstraints();
		gbc_osLastBootupTimeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_osLastBootupTimeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_osLastBootupTimeTextField.gridx = 3;
		gbc_osLastBootupTimeTextField.gridy = 4;
		operatingSystemPanel.add(osLastBootupTimeTextField, gbc_osLastBootupTimeTextField);
		osLastBootupTimeTextField.setColumns(10);
		
		JLabel osSerialNumberLabel = new JLabel("Serial Number");
		GridBagConstraints gbc_osSerialNumberLabel = new GridBagConstraints();
		gbc_osSerialNumberLabel.anchor = GridBagConstraints.WEST;
		gbc_osSerialNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_osSerialNumberLabel.gridx = 0;
		gbc_osSerialNumberLabel.gridy = 5;
		operatingSystemPanel.add(osSerialNumberLabel, gbc_osSerialNumberLabel);
		
		osSerialNumberTextField = new JTextField();
		osSerialNumberTextField.setEditable(false);
		GridBagConstraints gbc_osSerialNumberTextField = new GridBagConstraints();
		gbc_osSerialNumberTextField.gridwidth = 3;
		gbc_osSerialNumberTextField.insets = new Insets(0, 0, 5, 5);
		gbc_osSerialNumberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_osSerialNumberTextField.gridx = 1;
		gbc_osSerialNumberTextField.gridy = 5;
		operatingSystemPanel.add(osSerialNumberTextField, gbc_osSerialNumberTextField);
		osSerialNumberTextField.setColumns(10);
		
		JLabel osLanguagesLabel = new JLabel("Languages");
		GridBagConstraints gbc_osLanguagesLabel = new GridBagConstraints();
		gbc_osLanguagesLabel.anchor = GridBagConstraints.WEST;
		gbc_osLanguagesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_osLanguagesLabel.gridx = 4;
		gbc_osLanguagesLabel.gridy = 5;
		operatingSystemPanel.add(osLanguagesLabel, gbc_osLanguagesLabel);
		
		osLanguagesTextField = new JTextField();
		osLanguagesTextField.setEditable(false);
		GridBagConstraints gbc_osLanguagesTextField = new GridBagConstraints();
		gbc_osLanguagesTextField.insets = new Insets(0, 0, 5, 0);
		gbc_osLanguagesTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_osLanguagesTextField.gridx = 5;
		gbc_osLanguagesTextField.gridy = 5;
		operatingSystemPanel.add(osLanguagesTextField, gbc_osLanguagesTextField);
		osLanguagesTextField.setColumns(10);
		
		JLabel osPrimaryLabel = new JLabel("Primary");
		GridBagConstraints gbc_osPrimaryLabel = new GridBagConstraints();
		gbc_osPrimaryLabel.anchor = GridBagConstraints.WEST;
		gbc_osPrimaryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_osPrimaryLabel.gridx = 0;
		gbc_osPrimaryLabel.gridy = 6;
		operatingSystemPanel.add(osPrimaryLabel, gbc_osPrimaryLabel);
		
		osPrimaryTextField = new JTextField();
		osPrimaryTextField.setEditable(false);
		GridBagConstraints gbc_osPrimaryTextField = new GridBagConstraints();
		gbc_osPrimaryTextField.insets = new Insets(0, 0, 5, 5);
		gbc_osPrimaryTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_osPrimaryTextField.gridx = 1;
		gbc_osPrimaryTextField.gridy = 6;
		operatingSystemPanel.add(osPrimaryTextField, gbc_osPrimaryTextField);
		osPrimaryTextField.setColumns(10);
		
		JLabel osDistributedLabel = new JLabel("Distributed");
		GridBagConstraints gbc_osDistributedLabel = new GridBagConstraints();
		gbc_osDistributedLabel.anchor = GridBagConstraints.WEST;
		gbc_osDistributedLabel.insets = new Insets(0, 0, 5, 5);
		gbc_osDistributedLabel.gridx = 2;
		gbc_osDistributedLabel.gridy = 6;
		operatingSystemPanel.add(osDistributedLabel, gbc_osDistributedLabel);
		
		osDistributedTextField = new JTextField();
		osDistributedTextField.setEditable(false);
		GridBagConstraints gbc_osDistributedTextField = new GridBagConstraints();
		gbc_osDistributedTextField.insets = new Insets(0, 0, 5, 5);
		gbc_osDistributedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_osDistributedTextField.gridx = 3;
		gbc_osDistributedTextField.gridy = 6;
		operatingSystemPanel.add(osDistributedTextField, gbc_osDistributedTextField);
		osDistributedTextField.setColumns(10);
		
		JLabel osPortableLabel = new JLabel("Portable");
		GridBagConstraints gbc_osPortableLabel = new GridBagConstraints();
		gbc_osPortableLabel.anchor = GridBagConstraints.WEST;
		gbc_osPortableLabel.insets = new Insets(0, 0, 5, 5);
		gbc_osPortableLabel.gridx = 4;
		gbc_osPortableLabel.gridy = 6;
		operatingSystemPanel.add(osPortableLabel, gbc_osPortableLabel);
		
		osPortableTextField = new JTextField();
		osPortableTextField.setEditable(false);
		GridBagConstraints gbc_osPortableTextField = new GridBagConstraints();
		gbc_osPortableTextField.insets = new Insets(0, 0, 5, 0);
		gbc_osPortableTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_osPortableTextField.gridx = 5;
		gbc_osPortableTextField.gridy = 6;
		operatingSystemPanel.add(osPortableTextField, gbc_osPortableTextField);
		osPortableTextField.setColumns(10);
		
		JLabel osDeviceNameLabel = new JLabel("Device Name");
		GridBagConstraints gbc_osDeviceNameLabel = new GridBagConstraints();
		gbc_osDeviceNameLabel.anchor = GridBagConstraints.WEST;
		gbc_osDeviceNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_osDeviceNameLabel.gridx = 0;
		gbc_osDeviceNameLabel.gridy = 7;
		operatingSystemPanel.add(osDeviceNameLabel, gbc_osDeviceNameLabel);
		
		osDeviceNameTextField = new JTextField();
		osDeviceNameTextField.setEditable(false);
		GridBagConstraints gbc_osDeviceNameTextField = new GridBagConstraints();
		gbc_osDeviceNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_osDeviceNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_osDeviceNameTextField.gridx = 1;
		gbc_osDeviceNameTextField.gridy = 7;
		operatingSystemPanel.add(osDeviceNameTextField, gbc_osDeviceNameTextField);
		osDeviceNameTextField.setColumns(10);
		
		JLabel osUserCountLabel = new JLabel("User Count");
		GridBagConstraints gbc_osUserCountLabel = new GridBagConstraints();
		gbc_osUserCountLabel.anchor = GridBagConstraints.WEST;
		gbc_osUserCountLabel.insets = new Insets(0, 0, 5, 5);
		gbc_osUserCountLabel.gridx = 2;
		gbc_osUserCountLabel.gridy = 7;
		operatingSystemPanel.add(osUserCountLabel, gbc_osUserCountLabel);
		
		osUserCountTextField = new JTextField();
		osUserCountTextField.setEditable(false);
		GridBagConstraints gbc_osUserCountTextField = new GridBagConstraints();
		gbc_osUserCountTextField.insets = new Insets(0, 0, 5, 5);
		gbc_osUserCountTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_osUserCountTextField.gridx = 3;
		gbc_osUserCountTextField.gridy = 7;
		operatingSystemPanel.add(osUserCountTextField, gbc_osUserCountTextField);
		osUserCountTextField.setColumns(10);
		
		JLabel osRegisteredUserLabel = new JLabel("Registered User");
		GridBagConstraints gbc_osRegisteredUserLabel = new GridBagConstraints();
		gbc_osRegisteredUserLabel.anchor = GridBagConstraints.WEST;
		gbc_osRegisteredUserLabel.insets = new Insets(0, 0, 5, 5);
		gbc_osRegisteredUserLabel.gridx = 4;
		gbc_osRegisteredUserLabel.gridy = 7;
		operatingSystemPanel.add(osRegisteredUserLabel, gbc_osRegisteredUserLabel);
		
		osRegisteredUserTextField = new JTextField();
		osRegisteredUserTextField.setEditable(false);
		GridBagConstraints gbc_osRegisteredUserTextField = new GridBagConstraints();
		gbc_osRegisteredUserTextField.insets = new Insets(0, 0, 5, 0);
		gbc_osRegisteredUserTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_osRegisteredUserTextField.gridx = 5;
		gbc_osRegisteredUserTextField.gridy = 7;
		operatingSystemPanel.add(osRegisteredUserTextField, gbc_osRegisteredUserTextField);
		osRegisteredUserTextField.setColumns(10);
		
		JLabel osSystemDriveLabel = new JLabel("System Drive");
		GridBagConstraints gbc_osSystemDriveLabel = new GridBagConstraints();
		gbc_osSystemDriveLabel.anchor = GridBagConstraints.WEST;
		gbc_osSystemDriveLabel.insets = new Insets(0, 0, 0, 5);
		gbc_osSystemDriveLabel.gridx = 0;
		gbc_osSystemDriveLabel.gridy = 8;
		operatingSystemPanel.add(osSystemDriveLabel, gbc_osSystemDriveLabel);
		
		osSystemDriveTextField = new JTextField();
		osSystemDriveTextField.setEditable(false);
		GridBagConstraints gbc_osSystemDriveTextField = new GridBagConstraints();
		gbc_osSystemDriveTextField.insets = new Insets(0, 0, 0, 5);
		gbc_osSystemDriveTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_osSystemDriveTextField.gridx = 1;
		gbc_osSystemDriveTextField.gridy = 8;
		operatingSystemPanel.add(osSystemDriveTextField, gbc_osSystemDriveTextField);
		osSystemDriveTextField.setColumns(10);
		
		JLabel osWindowsDirectoryLabel = new JLabel("Windows Directory");
		GridBagConstraints gbc_osWindowsDirectoryLabel = new GridBagConstraints();
		gbc_osWindowsDirectoryLabel.anchor = GridBagConstraints.WEST;
		gbc_osWindowsDirectoryLabel.insets = new Insets(0, 0, 0, 5);
		gbc_osWindowsDirectoryLabel.gridx = 2;
		gbc_osWindowsDirectoryLabel.gridy = 8;
		operatingSystemPanel.add(osWindowsDirectoryLabel, gbc_osWindowsDirectoryLabel);
		
		osWindowsDirectoryTextField = new JTextField();
		osWindowsDirectoryTextField.setEditable(false);
		GridBagConstraints gbc_osWindowsDirectoryTextField = new GridBagConstraints();
		gbc_osWindowsDirectoryTextField.insets = new Insets(0, 0, 0, 5);
		gbc_osWindowsDirectoryTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_osWindowsDirectoryTextField.gridx = 3;
		gbc_osWindowsDirectoryTextField.gridy = 8;
		operatingSystemPanel.add(osWindowsDirectoryTextField, gbc_osWindowsDirectoryTextField);
		osWindowsDirectoryTextField.setColumns(10);
		
		JLabel osSystemDirectoryLabel = new JLabel("System Directory");
		GridBagConstraints gbc_osSystemDirectoryLabel = new GridBagConstraints();
		gbc_osSystemDirectoryLabel.anchor = GridBagConstraints.WEST;
		gbc_osSystemDirectoryLabel.insets = new Insets(0, 0, 0, 5);
		gbc_osSystemDirectoryLabel.gridx = 4;
		gbc_osSystemDirectoryLabel.gridy = 8;
		operatingSystemPanel.add(osSystemDirectoryLabel, gbc_osSystemDirectoryLabel);
		
		osSystemDirectoryTextField = new JTextField();
		osSystemDirectoryTextField.setEditable(false);
		GridBagConstraints gbc_osSystemDirectoryTextField = new GridBagConstraints();
		gbc_osSystemDirectoryTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_osSystemDirectoryTextField.gridx = 5;
		gbc_osSystemDirectoryTextField.gridy = 8;
		operatingSystemPanel.add(osSystemDirectoryTextField, gbc_osSystemDirectoryTextField);
		osSystemDirectoryTextField.setColumns(10);
		
	}
	
	private void setUserPanel() {
		JScrollPane userScrollPane = new JScrollPane();
		add(userScrollPane, BorderLayout.SOUTH);
		
		JPanel userPanel = new JPanel();
		userScrollPane.setViewportView(userPanel);
		userPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "User", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_userPanel = new GridBagLayout();
		gbl_userPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_userPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_userPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_userPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		userPanel.setLayout(gbl_userPanel);
		
		JLabel userSIDLabel = new JLabel("SID");
		GridBagConstraints gbc_userSIDLabel = new GridBagConstraints();
		gbc_userSIDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userSIDLabel.anchor = GridBagConstraints.WEST;
		gbc_userSIDLabel.gridx = 0;
		gbc_userSIDLabel.gridy = 0;
		userPanel.add(userSIDLabel, gbc_userSIDLabel);
		
		userSIDComboBox = new JComboBox<>();
		GridBagConstraints gbc_userSIDComboBox = new GridBagConstraints();
		gbc_userSIDComboBox.gridwidth = 5;
		gbc_userSIDComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_userSIDComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_userSIDComboBox.gridx = 1;
		gbc_userSIDComboBox.gridy = 0;
		userPanel.add(userSIDComboBox, gbc_userSIDComboBox);
		
		JLabel userNameLabel = new JLabel("Name");
		GridBagConstraints gbc_userNameLabel = new GridBagConstraints();
		gbc_userNameLabel.anchor = GridBagConstraints.WEST;
		gbc_userNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userNameLabel.gridx = 0;
		gbc_userNameLabel.gridy = 1;
		userPanel.add(userNameLabel, gbc_userNameLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setEditable(false);
		GridBagConstraints gbc_userNameTextField = new GridBagConstraints();
		gbc_userNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_userNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userNameTextField.gridx = 1;
		gbc_userNameTextField.gridy = 1;
		userPanel.add(userNameTextField, gbc_userNameTextField);
		userNameTextField.setColumns(10);
		
		JLabel userCaptionLabel = new JLabel("Caption");
		GridBagConstraints gbc_userCaptionLabel = new GridBagConstraints();
		gbc_userCaptionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userCaptionLabel.anchor = GridBagConstraints.WEST;
		gbc_userCaptionLabel.gridx = 2;
		gbc_userCaptionLabel.gridy = 1;
		userPanel.add(userCaptionLabel, gbc_userCaptionLabel);
		
		userCaptionTextField = new JTextField();
		userCaptionTextField.setEditable(false);
		GridBagConstraints gbc_userCaptionTextField = new GridBagConstraints();
		gbc_userCaptionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_userCaptionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userCaptionTextField.gridx = 3;
		gbc_userCaptionTextField.gridy = 1;
		userPanel.add(userCaptionTextField, gbc_userCaptionTextField);
		userCaptionTextField.setColumns(10);
		
		JLabel userDomainLabel = new JLabel("Domain");
		GridBagConstraints gbc_userDomainLabel = new GridBagConstraints();
		gbc_userDomainLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userDomainLabel.anchor = GridBagConstraints.WEST;
		gbc_userDomainLabel.gridx = 4;
		gbc_userDomainLabel.gridy = 1;
		userPanel.add(userDomainLabel, gbc_userDomainLabel);
		
		userDomainTextField = new JTextField();
		userDomainTextField.setEditable(false);
		GridBagConstraints gbc_userDomainTextField = new GridBagConstraints();
		gbc_userDomainTextField.insets = new Insets(0, 0, 5, 0);
		gbc_userDomainTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userDomainTextField.gridx = 5;
		gbc_userDomainTextField.gridy = 1;
		userPanel.add(userDomainTextField, gbc_userDomainTextField);
		userDomainTextField.setColumns(10);
		
		JLabel userDescriptionLabel = new JLabel("Description");
		GridBagConstraints gbc_userDescriptionLabel = new GridBagConstraints();
		gbc_userDescriptionLabel.anchor = GridBagConstraints.WEST;
		gbc_userDescriptionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userDescriptionLabel.gridx = 0;
		gbc_userDescriptionLabel.gridy = 2;
		userPanel.add(userDescriptionLabel, gbc_userDescriptionLabel);
		
		userDescriptionTextField = new JTextField();
		userDescriptionTextField.setEditable(false);
		GridBagConstraints gbc_userDescriptionTextField = new GridBagConstraints();
		gbc_userDescriptionTextField.insets = new Insets(0, 0, 5, 0);
		gbc_userDescriptionTextField.gridwidth = 5;
		gbc_userDescriptionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userDescriptionTextField.gridx = 1;
		gbc_userDescriptionTextField.gridy = 2;
		userPanel.add(userDescriptionTextField, gbc_userDescriptionTextField);
		userDescriptionTextField.setColumns(10);
		
		JLabel userPasswordRequiredLabel = new JLabel("Password Required");
		GridBagConstraints gbc_userPasswordRequiredLabel = new GridBagConstraints();
		gbc_userPasswordRequiredLabel.anchor = GridBagConstraints.WEST;
		gbc_userPasswordRequiredLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userPasswordRequiredLabel.gridx = 0;
		gbc_userPasswordRequiredLabel.gridy = 3;
		userPanel.add(userPasswordRequiredLabel, gbc_userPasswordRequiredLabel);
		
		userPassowrdRequiredTextField = new JTextField();
		userPassowrdRequiredTextField.setEditable(false);
		GridBagConstraints gbc_userPassowrdRequiredTextField = new GridBagConstraints();
		gbc_userPassowrdRequiredTextField.insets = new Insets(0, 0, 5, 5);
		gbc_userPassowrdRequiredTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userPassowrdRequiredTextField.gridx = 1;
		gbc_userPassowrdRequiredTextField.gridy = 3;
		userPanel.add(userPassowrdRequiredTextField, gbc_userPassowrdRequiredTextField);
		userPassowrdRequiredTextField.setColumns(10);
		
		JLabel userPasswordChangeableLabel = new JLabel("Password Changeable");
		GridBagConstraints gbc_userPasswordChangeableLabel = new GridBagConstraints();
		gbc_userPasswordChangeableLabel.anchor = GridBagConstraints.WEST;
		gbc_userPasswordChangeableLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userPasswordChangeableLabel.gridx = 2;
		gbc_userPasswordChangeableLabel.gridy = 3;
		userPanel.add(userPasswordChangeableLabel, gbc_userPasswordChangeableLabel);
		
		userPasswordChangeableTextField = new JTextField();
		userPasswordChangeableTextField.setEditable(false);
		GridBagConstraints gbc_userPasswordChangeableTextField = new GridBagConstraints();
		gbc_userPasswordChangeableTextField.insets = new Insets(0, 0, 5, 5);
		gbc_userPasswordChangeableTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userPasswordChangeableTextField.gridx = 3;
		gbc_userPasswordChangeableTextField.gridy = 3;
		userPanel.add(userPasswordChangeableTextField, gbc_userPasswordChangeableTextField);
		userPasswordChangeableTextField.setColumns(10);
		
		JLabel userPasswordExpiresLabel = new JLabel("Password Expires");
		GridBagConstraints gbc_userPasswordExpiresLabel = new GridBagConstraints();
		gbc_userPasswordExpiresLabel.anchor = GridBagConstraints.WEST;
		gbc_userPasswordExpiresLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userPasswordExpiresLabel.gridx = 4;
		gbc_userPasswordExpiresLabel.gridy = 3;
		userPanel.add(userPasswordExpiresLabel, gbc_userPasswordExpiresLabel);
		
		userPasswordExpiresTextField = new JTextField();
		userPasswordExpiresTextField.setEditable(false);
		GridBagConstraints gbc_userPasswordExpiresTextField = new GridBagConstraints();
		gbc_userPasswordExpiresTextField.insets = new Insets(0, 0, 5, 0);
		gbc_userPasswordExpiresTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userPasswordExpiresTextField.gridx = 5;
		gbc_userPasswordExpiresTextField.gridy = 3;
		userPanel.add(userPasswordExpiresTextField, gbc_userPasswordExpiresTextField);
		userPasswordExpiresTextField.setColumns(10);
		
		JLabel userLocalAccountLabel = new JLabel("Local Account");
		GridBagConstraints gbc_userLocalAccountLabel = new GridBagConstraints();
		gbc_userLocalAccountLabel.anchor = GridBagConstraints.WEST;
		gbc_userLocalAccountLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userLocalAccountLabel.gridx = 0;
		gbc_userLocalAccountLabel.gridy = 4;
		userPanel.add(userLocalAccountLabel, gbc_userLocalAccountLabel);
		
		userLocalAccountTextField = new JTextField();
		userLocalAccountTextField.setEditable(false);
		GridBagConstraints gbc_userLocalAccountTextField = new GridBagConstraints();
		gbc_userLocalAccountTextField.insets = new Insets(0, 0, 5, 5);
		gbc_userLocalAccountTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userLocalAccountTextField.gridx = 1;
		gbc_userLocalAccountTextField.gridy = 4;
		userPanel.add(userLocalAccountTextField, gbc_userLocalAccountTextField);
		userLocalAccountTextField.setColumns(10);
		
		JLabel userDisabledLabel = new JLabel("Disabled");
		GridBagConstraints gbc_userDisabledLabel = new GridBagConstraints();
		gbc_userDisabledLabel.anchor = GridBagConstraints.WEST;
		gbc_userDisabledLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userDisabledLabel.gridx = 2;
		gbc_userDisabledLabel.gridy = 4;
		userPanel.add(userDisabledLabel, gbc_userDisabledLabel);
		
		userDisabledTextField = new JTextField();
		userDisabledTextField.setEditable(false);
		GridBagConstraints gbc_userDisabledTextField = new GridBagConstraints();
		gbc_userDisabledTextField.insets = new Insets(0, 0, 5, 5);
		gbc_userDisabledTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userDisabledTextField.gridx = 3;
		gbc_userDisabledTextField.gridy = 4;
		userPanel.add(userDisabledTextField, gbc_userDisabledTextField);
		userDisabledTextField.setColumns(10);
		
		JLabel userLockedOutLabel = new JLabel("Locked Out");
		GridBagConstraints gbc_userLockedOutLabel = new GridBagConstraints();
		gbc_userLockedOutLabel.anchor = GridBagConstraints.WEST;
		gbc_userLockedOutLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userLockedOutLabel.gridx = 4;
		gbc_userLockedOutLabel.gridy = 4;
		userPanel.add(userLockedOutLabel, gbc_userLockedOutLabel);
		
		userLockedOutTextField = new JTextField();
		userLockedOutTextField.setEditable(false);
		GridBagConstraints gbc_userLockedOutTextField = new GridBagConstraints();
		gbc_userLockedOutTextField.insets = new Insets(0, 0, 5, 0);
		gbc_userLockedOutTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userLockedOutTextField.gridx = 5;
		gbc_userLockedOutTextField.gridy = 4;
		userPanel.add(userLockedOutTextField, gbc_userLockedOutTextField);
		userLockedOutTextField.setColumns(10);
		
		JLabel userAccountTypeLabel = new JLabel("Account Type");
		GridBagConstraints gbc_userAccountTypeLabel = new GridBagConstraints();
		gbc_userAccountTypeLabel.anchor = GridBagConstraints.WEST;
		gbc_userAccountTypeLabel.insets = new Insets(0, 0, 0, 5);
		gbc_userAccountTypeLabel.gridx = 0;
		gbc_userAccountTypeLabel.gridy = 5;
		userPanel.add(userAccountTypeLabel, gbc_userAccountTypeLabel);
		
		userAccountTypeTextField = new JTextField();
		userAccountTypeTextField.setEditable(false);
		GridBagConstraints gbc_userAccountTypeTextField = new GridBagConstraints();
		gbc_userAccountTypeTextField.insets = new Insets(0, 0, 0, 5);
		gbc_userAccountTypeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userAccountTypeTextField.gridx = 1;
		gbc_userAccountTypeTextField.gridy = 5;
		userPanel.add(userAccountTypeTextField, gbc_userAccountTypeTextField);
		userAccountTypeTextField.setColumns(10);
		
		JLabel userSIDTypeLabel = new JLabel("SID Type");
		GridBagConstraints gbc_userSIDTypeLabel = new GridBagConstraints();
		gbc_userSIDTypeLabel.anchor = GridBagConstraints.WEST;
		gbc_userSIDTypeLabel.insets = new Insets(0, 0, 0, 5);
		gbc_userSIDTypeLabel.gridx = 2;
		gbc_userSIDTypeLabel.gridy = 5;
		userPanel.add(userSIDTypeLabel, gbc_userSIDTypeLabel);
		
		userSIDTypeTextField = new JTextField();
		userSIDTypeTextField.setEditable(false);
		GridBagConstraints gbc_userSIDTypeTextField = new GridBagConstraints();
		gbc_userSIDTypeTextField.insets = new Insets(0, 0, 0, 5);
		gbc_userSIDTypeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userSIDTypeTextField.gridx = 3;
		gbc_userSIDTypeTextField.gridy = 5;
		userPanel.add(userSIDTypeTextField, gbc_userSIDTypeTextField);
		userSIDTypeTextField.setColumns(10);
		
		JLabel userStatusLabel = new JLabel("Status");
		GridBagConstraints gbc_userStatusLabel = new GridBagConstraints();
		gbc_userStatusLabel.anchor = GridBagConstraints.WEST;
		gbc_userStatusLabel.insets = new Insets(0, 0, 0, 5);
		gbc_userStatusLabel.gridx = 4;
		gbc_userStatusLabel.gridy = 5;
		userPanel.add(userStatusLabel, gbc_userStatusLabel);
		
		userStatusTextField = new JTextField();
		userStatusTextField.setEditable(false);
		GridBagConstraints gbc_userStatusTextField = new GridBagConstraints();
		gbc_userStatusTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userStatusTextField.gridx = 5;
		gbc_userStatusTextField.gridy = 5;
		userPanel.add(userStatusTextField, gbc_userStatusTextField);
		userStatusTextField.setColumns(10);
	}
	
	private void setWorker() {
		
	}

}
