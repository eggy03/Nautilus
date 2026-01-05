package io.github.eggy03.ui.windows.panels;

import io.github.eggy03.ui.windows.worker.WMIPhysicalMemoryPanelWorker;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;

public class WMIPhysicalMemoryPanelUI extends JPanel {

	private JComboBox<String> slotComboBox;
	private JTextField nameTextField;
	private JTextField manufacturerTextField;
	private JTextField modelTextField;
	private JTextField oidTextField;
	private JTextField partNumberTextField;
	private JTextField serialTextField;
	private JTextField formFactorTextField;
	private JTextField bankLabelTextField;
	private JTextField capacityTextField;
	private JTextField dataWidthTextField;
	private JTextField speedTextField;
	private JTextField configSpeedTextField;
	private JTextField deviceLocatorTextField;
	
	public JPanel getPanel() {
		return this;
	}

	/**
	 * Create the panel.
	 */
	public WMIPhysicalMemoryPanelUI() {
		setUI();
		setWorker();
	}
	
	private void setUI() {
		
		setLayout(new GridLayout(1, 0, 0, 0));
		
		// add panel
		JPanel memoryPanel = new JPanel();
		memoryPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Memory", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gblMemoryPanel = new GridBagLayout();
		gblMemoryPanel.columnWidths = new int[]{0, 0, 0};
		gblMemoryPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gblMemoryPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gblMemoryPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		memoryPanel.setLayout(gblMemoryPanel);
		
		JLabel slotLabel = new JLabel("Slot#");
		GridBagConstraints gbcSlotLabel = new GridBagConstraints();
		gbcSlotLabel.insets = new Insets(0, 0, 5, 5);
		gbcSlotLabel.anchor = GridBagConstraints.WEST;
		gbcSlotLabel.gridx = 0;
		gbcSlotLabel.gridy = 0;
		memoryPanel.add(slotLabel, gbcSlotLabel);
		
		slotComboBox = new JComboBox<>();
		GridBagConstraints gbcSlotComboBox = new GridBagConstraints();
		gbcSlotComboBox.insets = new Insets(0, 0, 5, 0);
		gbcSlotComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbcSlotComboBox.gridx = 1;
		gbcSlotComboBox.gridy = 0;
		memoryPanel.add(slotComboBox, gbcSlotComboBox);
		
		JLabel nameLabel = new JLabel("Name");
		GridBagConstraints gbcNameLabel = new GridBagConstraints();
		gbcNameLabel.anchor = GridBagConstraints.WEST;
		gbcNameLabel.insets = new Insets(0, 0, 5, 5);
		gbcNameLabel.gridx = 0;
		gbcNameLabel.gridy = 1;
		memoryPanel.add(nameLabel, gbcNameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setEditable(false);
		GridBagConstraints gbcNameTextField = new GridBagConstraints();
		gbcNameTextField.insets = new Insets(0, 0, 5, 0);
		gbcNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcNameTextField.gridx = 1;
		gbcNameTextField.gridy = 1;
		memoryPanel.add(nameTextField, gbcNameTextField);
		nameTextField.setColumns(10);
		
		JLabel manufacturerLabel = new JLabel("Manufacturer");
		GridBagConstraints gbcManufacturerLabel = new GridBagConstraints();
		gbcManufacturerLabel.anchor = GridBagConstraints.WEST;
		gbcManufacturerLabel.insets = new Insets(0, 0, 5, 5);
		gbcManufacturerLabel.gridx = 0;
		gbcManufacturerLabel.gridy = 2;
		memoryPanel.add(manufacturerLabel, gbcManufacturerLabel);
		
		manufacturerTextField = new JTextField();
		manufacturerTextField.setEditable(false);
		manufacturerTextField.setColumns(10);
		GridBagConstraints gbcManufacturerTextField = new GridBagConstraints();
		gbcManufacturerTextField.insets = new Insets(0, 0, 5, 0);
		gbcManufacturerTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcManufacturerTextField.gridx = 1;
		gbcManufacturerTextField.gridy = 2;
		memoryPanel.add(manufacturerTextField, gbcManufacturerTextField);
		
		JLabel modelLabel = new JLabel("Model");
		GridBagConstraints gbcModelLabel = new GridBagConstraints();
		gbcModelLabel.anchor = GridBagConstraints.WEST;
		gbcModelLabel.insets = new Insets(0, 0, 5, 5);
		gbcModelLabel.gridx = 0;
		gbcModelLabel.gridy = 3;
		memoryPanel.add(modelLabel, gbcModelLabel);
		
		modelTextField = new JTextField();
		modelTextField.setEditable(false);
		modelTextField.setColumns(10);
		GridBagConstraints gbcModelTextField = new GridBagConstraints();
		gbcModelTextField.insets = new Insets(0, 0, 5, 0);
		gbcModelTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcModelTextField.gridx = 1;
		gbcModelTextField.gridy = 3;
		memoryPanel.add(modelTextField, gbcModelTextField);
		
		JLabel otherIdLabel = new JLabel("Other ID");
		GridBagConstraints gbcOtherIdLabel = new GridBagConstraints();
		gbcOtherIdLabel.anchor = GridBagConstraints.WEST;
		gbcOtherIdLabel.insets = new Insets(0, 0, 5, 5);
		gbcOtherIdLabel.gridx = 0;
		gbcOtherIdLabel.gridy = 4;
		memoryPanel.add(otherIdLabel, gbcOtherIdLabel);
		
		oidTextField = new JTextField();
		oidTextField.setEditable(false);
		oidTextField.setColumns(10);
		GridBagConstraints gbcOidTextField = new GridBagConstraints();
		gbcOidTextField.insets = new Insets(0, 0, 5, 0);
		gbcOidTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcOidTextField.gridx = 1;
		gbcOidTextField.gridy = 4;
		memoryPanel.add(oidTextField, gbcOidTextField);
		
		JLabel partNumberLabel = new JLabel("Part Number");
		GridBagConstraints gbcPartNumberLabel = new GridBagConstraints();
		gbcPartNumberLabel.anchor = GridBagConstraints.WEST;
		gbcPartNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbcPartNumberLabel.gridx = 0;
		gbcPartNumberLabel.gridy = 5;
		memoryPanel.add(partNumberLabel, gbcPartNumberLabel);
		
		partNumberTextField = new JTextField();
		partNumberTextField.setEditable(false);
		partNumberTextField.setColumns(10);
		GridBagConstraints gbcPartNumberTextField = new GridBagConstraints();
		gbcPartNumberTextField.insets = new Insets(0, 0, 5, 0);
		gbcPartNumberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcPartNumberTextField.gridx = 1;
		gbcPartNumberTextField.gridy = 5;
		memoryPanel.add(partNumberTextField, gbcPartNumberTextField);
		
		JLabel serialNumberLabel = new JLabel("Serial Number");
		GridBagConstraints gbcSerialNumberLabel = new GridBagConstraints();
		gbcSerialNumberLabel.anchor = GridBagConstraints.WEST;
		gbcSerialNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbcSerialNumberLabel.gridx = 0;
		gbcSerialNumberLabel.gridy = 6;
		memoryPanel.add(serialNumberLabel, gbcSerialNumberLabel);
		
		serialTextField = new JTextField();
		serialTextField.setEditable(false);
		serialTextField.setColumns(10);
		GridBagConstraints gbcSerialTextField = new GridBagConstraints();
		gbcSerialTextField.insets = new Insets(0, 0, 5, 0);
		gbcSerialTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcSerialTextField.gridx = 1;
		gbcSerialTextField.gridy = 6;
		memoryPanel.add(serialTextField, gbcSerialTextField);
		
		JLabel formFactorLabel = new JLabel("Form Factor");
		GridBagConstraints gbcFormFactorLabel = new GridBagConstraints();
		gbcFormFactorLabel.anchor = GridBagConstraints.WEST;
		gbcFormFactorLabel.insets = new Insets(0, 0, 5, 5);
		gbcFormFactorLabel.gridx = 0;
		gbcFormFactorLabel.gridy = 7;
		memoryPanel.add(formFactorLabel, gbcFormFactorLabel);
		
		formFactorTextField = new JTextField();
		formFactorTextField.setEditable(false);
		formFactorTextField.setColumns(10);
		GridBagConstraints gbcFormFactorTextField = new GridBagConstraints();
		gbcFormFactorTextField.insets = new Insets(0, 0, 5, 0);
		gbcFormFactorTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcFormFactorTextField.gridx = 1;
		gbcFormFactorTextField.gridy = 7;
		memoryPanel.add(formFactorTextField, gbcFormFactorTextField);
		
		JLabel bankLabel = new JLabel("Bank Label");
		GridBagConstraints gbcBankLabel = new GridBagConstraints();
		gbcBankLabel.anchor = GridBagConstraints.WEST;
		gbcBankLabel.insets = new Insets(0, 0, 5, 5);
		gbcBankLabel.gridx = 0;
		gbcBankLabel.gridy = 8;
		memoryPanel.add(bankLabel, gbcBankLabel);
		
		bankLabelTextField = new JTextField();
		bankLabelTextField.setEditable(false);
		bankLabelTextField.setColumns(10);
		GridBagConstraints gbcBankLabelTextField = new GridBagConstraints();
		gbcBankLabelTextField.insets = new Insets(0, 0, 5, 0);
		gbcBankLabelTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBankLabelTextField.gridx = 1;
		gbcBankLabelTextField.gridy = 8;
		memoryPanel.add(bankLabelTextField, gbcBankLabelTextField);
		
		JLabel capacityLabel = new JLabel("Capacity");
		GridBagConstraints gbcCapacityLabel = new GridBagConstraints();
		gbcCapacityLabel.anchor = GridBagConstraints.WEST;
		gbcCapacityLabel.insets = new Insets(0, 0, 5, 5);
		gbcCapacityLabel.gridx = 0;
		gbcCapacityLabel.gridy = 9;
		memoryPanel.add(capacityLabel, gbcCapacityLabel);
		
		capacityTextField = new JTextField();
		capacityTextField.setEditable(false);
		capacityTextField.setColumns(10);
		GridBagConstraints gbcCapacityTextField = new GridBagConstraints();
		gbcCapacityTextField.insets = new Insets(0, 0, 5, 0);
		gbcCapacityTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcCapacityTextField.gridx = 1;
		gbcCapacityTextField.gridy = 9;
		memoryPanel.add(capacityTextField, gbcCapacityTextField);
		
		JLabel dataWidthLabel = new JLabel("Data Width");
		GridBagConstraints gbcDataWidthLabel = new GridBagConstraints();
		gbcDataWidthLabel.anchor = GridBagConstraints.WEST;
		gbcDataWidthLabel.insets = new Insets(0, 0, 5, 5);
		gbcDataWidthLabel.gridx = 0;
		gbcDataWidthLabel.gridy = 10;
		memoryPanel.add(dataWidthLabel, gbcDataWidthLabel);
		
		dataWidthTextField = new JTextField();
		dataWidthTextField.setEditable(false);
		dataWidthTextField.setColumns(10);
		GridBagConstraints gbcDataWidthTextField = new GridBagConstraints();
		gbcDataWidthTextField.insets = new Insets(0, 0, 5, 0);
		gbcDataWidthTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcDataWidthTextField.gridx = 1;
		gbcDataWidthTextField.gridy = 10;
		memoryPanel.add(dataWidthTextField, gbcDataWidthTextField);
		
		JLabel speedLabel = new JLabel("Speed");
		GridBagConstraints gbcSpeedLabel = new GridBagConstraints();
		gbcSpeedLabel.anchor = GridBagConstraints.WEST;
		gbcSpeedLabel.insets = new Insets(0, 0, 5, 5);
		gbcSpeedLabel.gridx = 0;
		gbcSpeedLabel.gridy = 11;
		memoryPanel.add(speedLabel, gbcSpeedLabel);
		
		speedTextField = new JTextField();
		speedTextField.setEditable(false);
		speedTextField.setColumns(10);
		GridBagConstraints gbcSpeedTextField = new GridBagConstraints();
		gbcSpeedTextField.insets = new Insets(0, 0, 5, 0);
		gbcSpeedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcSpeedTextField.gridx = 1;
		gbcSpeedTextField.gridy = 11;
		memoryPanel.add(speedTextField, gbcSpeedTextField);
		
		JLabel configSpeedLabel = new JLabel("Configured Speed");
		GridBagConstraints gbcConfigSpeedLabel = new GridBagConstraints();
		gbcConfigSpeedLabel.anchor = GridBagConstraints.WEST;
		gbcConfigSpeedLabel.insets = new Insets(0, 0, 5, 5);
		gbcConfigSpeedLabel.gridx = 0;
		gbcConfigSpeedLabel.gridy = 12;
		memoryPanel.add(configSpeedLabel, gbcConfigSpeedLabel);
		
		configSpeedTextField = new JTextField();
		configSpeedTextField.setEditable(false);
		configSpeedTextField.setColumns(10);
		GridBagConstraints gbcConfigSpeedTextField = new GridBagConstraints();
		gbcConfigSpeedTextField.insets = new Insets(0, 0, 5, 0);
		gbcConfigSpeedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcConfigSpeedTextField.gridx = 1;
		gbcConfigSpeedTextField.gridy = 12;
		memoryPanel.add(configSpeedTextField, gbcConfigSpeedTextField);
		
		JLabel deviceLocatorLabel = new JLabel("Device Locator");
		GridBagConstraints gbcDeviceLocatorLabel = new GridBagConstraints();
		gbcDeviceLocatorLabel.anchor = GridBagConstraints.WEST;
		gbcDeviceLocatorLabel.insets = new Insets(0, 0, 0, 5);
		gbcDeviceLocatorLabel.gridx = 0;
		gbcDeviceLocatorLabel.gridy = 13;
		memoryPanel.add(deviceLocatorLabel, gbcDeviceLocatorLabel);
		
		deviceLocatorTextField = new JTextField();
		deviceLocatorTextField.setEditable(false);
		deviceLocatorTextField.setColumns(10);
		GridBagConstraints gbcDeviceLocatorTextField = new GridBagConstraints();
		gbcDeviceLocatorTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcDeviceLocatorTextField.gridx = 1;
		gbcDeviceLocatorTextField.gridy = 13;
		memoryPanel.add(deviceLocatorTextField, gbcDeviceLocatorTextField);
		
		// add scroll-pane to the panel
		JScrollPane memoryScrollPane = new JScrollPane();
		memoryScrollPane.setViewportView(memoryPanel);
		add(memoryScrollPane);
	}
	
	private void setWorker() {

		List<JTextField> memoryFields = List.of(nameTextField, manufacturerTextField, modelTextField, oidTextField,
		partNumberTextField, serialTextField, formFactorTextField, bankLabelTextField, capacityTextField,
		dataWidthTextField, speedTextField, configSpeedTextField, deviceLocatorTextField);

		new WMIPhysicalMemoryPanelWorker(slotComboBox, memoryFields).execute();
	}

}
