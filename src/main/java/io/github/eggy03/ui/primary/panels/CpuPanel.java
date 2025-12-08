package io.github.eggy03.ui.primary.panels;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class CpuPanel extends JPanel {

	private static final long serialVersionUID = 2423707166878662262L;
	private JTextField hardwareIdTextField;
	private JTextField coreTextField;
	private JTextField threadTextField;
	private JTextField factoryClockTextField;
	private JTextField cpuNameTextField;
	private JTextField versionTextField;
	private JTextField familyTextField;
	private JTextField steppingTextField;
	private JTextField manufacturerTextField;
	private JTextField captionTextField;
	private JTextField processorIdTextField;
	private JTextField enabledCoresTextField;
	private JTextField enabledThreadsTextField;
	private JTextField reservedTextField;
	private JTextField addressWidthTextField;
	private JTextField socketTextField;
	private JTextField baseClockTextField;
	
	public JPanel getPanel() {
		return this;
	}

	/**
	 * Create the panel.
	 */
	public CpuPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0};
		setLayout(gridBagLayout);
		
		setHardwareIdPanel();
		setCpuPanel();
	}
	
	private void setHardwareIdPanel() {
		
		JPanel hardwareIdPanel = new JPanel();
		hardwareIdPanel.setBorder(new TitledBorder(null, "HardwareID", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_hardwareIdPanel = new GridBagConstraints();
		gbc_hardwareIdPanel.insets = new Insets(0, 0, 5, 0);
		gbc_hardwareIdPanel.fill = GridBagConstraints.BOTH;
		gbc_hardwareIdPanel.gridx = 0;
		gbc_hardwareIdPanel.gridy = 0;
		add(hardwareIdPanel, gbc_hardwareIdPanel);
		GridBagLayout gbl_hardwareIdPanel = new GridBagLayout();
		gbl_hardwareIdPanel.columnWidths = new int[]{956, 0, 0};
		gbl_hardwareIdPanel.rowHeights = new int[]{21, 0};
		gbl_hardwareIdPanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_hardwareIdPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		hardwareIdPanel.setLayout(gbl_hardwareIdPanel);
		
		hardwareIdTextField = new JTextField();
		GridBagConstraints gbc_hardwareIdTf = new GridBagConstraints();
		gbc_hardwareIdTf.insets = new Insets(0, 0, 0, 5);
		gbc_hardwareIdTf.fill = GridBagConstraints.BOTH;
		gbc_hardwareIdTf.gridx = 0;
		gbc_hardwareIdTf.gridy = 0;
		hardwareIdPanel.add(hardwareIdTextField, gbc_hardwareIdTf);
		hardwareIdTextField.setColumns(10);
		
		JButton copyHwid = new JButton("Button");
		GridBagConstraints gbc_copyHwid = new GridBagConstraints();
		gbc_copyHwid.gridx = 1;
		gbc_copyHwid.gridy = 0;
		hardwareIdPanel.add(copyHwid, gbc_copyHwid);
		
	}
	
	private void setCpuPanel() {
		
		JPanel cpuPanel = new JPanel();
		cpuPanel.setBorder(new TitledBorder(null, "CPU", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_cpuPanel = new GridBagConstraints();
		gbc_cpuPanel.insets = new Insets(0, 0, 5, 0);
		gbc_cpuPanel.fill = GridBagConstraints.BOTH;
		gbc_cpuPanel.gridx = 0;
		gbc_cpuPanel.gridy = 1;
		add(cpuPanel, gbc_cpuPanel);
		cpuPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		// PRIMARY INFO PANEL
		JPanel primaryInfoPanel = new JPanel();
		primaryInfoPanel.setBorder(new TitledBorder(null, "Primary Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cpuPanel.add(primaryInfoPanel);
		GridBagLayout gbl_primaryInfoPanel = new GridBagLayout();
		gbl_primaryInfoPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_primaryInfoPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_primaryInfoPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_primaryInfoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		primaryInfoPanel.setLayout(gbl_primaryInfoPanel);
		
		JLabel cpuIdLabel = new JLabel("CPU#");
		GridBagConstraints gbc_cpuIdLabel = new GridBagConstraints();
		gbc_cpuIdLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cpuIdLabel.anchor = GridBagConstraints.EAST;
		gbc_cpuIdLabel.gridx = 0;
		gbc_cpuIdLabel.gridy = 0;
		primaryInfoPanel.add(cpuIdLabel, gbc_cpuIdLabel);
		
		JComboBox<Integer> cpuIdComboBox = new JComboBox<>();
		GridBagConstraints gbc_cpuIdComboBox = new GridBagConstraints();
		gbc_cpuIdComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_cpuIdComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_cpuIdComboBox.gridx = 1;
		gbc_cpuIdComboBox.gridy = 0;
		primaryInfoPanel.add(cpuIdComboBox, gbc_cpuIdComboBox);
		
		JLabel cpuNameLabel = new JLabel("Name");
		GridBagConstraints gbc_cpuNameLabel = new GridBagConstraints();
		gbc_cpuNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cpuNameLabel.anchor = GridBagConstraints.EAST;
		gbc_cpuNameLabel.gridx = 2;
		gbc_cpuNameLabel.gridy = 0;
		primaryInfoPanel.add(cpuNameLabel, gbc_cpuNameLabel);
		
		cpuNameTextField = new JTextField();
		cpuNameTextField.setEditable(false);
		GridBagConstraints gbc_cpuNameTextField = new GridBagConstraints();
		gbc_cpuNameTextField.gridwidth = 3;
		gbc_cpuNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_cpuNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_cpuNameTextField.gridx = 3;
		gbc_cpuNameTextField.gridy = 0;
		primaryInfoPanel.add(cpuNameTextField, gbc_cpuNameTextField);
		cpuNameTextField.setColumns(10);
		
		JLabel coreLabel = new JLabel("Cores");
		GridBagConstraints gbc_coreLabel = new GridBagConstraints();
		gbc_coreLabel.anchor = GridBagConstraints.EAST;
		gbc_coreLabel.insets = new Insets(0, 0, 5, 5);
		gbc_coreLabel.gridx = 0;
		gbc_coreLabel.gridy = 1;
		primaryInfoPanel.add(coreLabel, gbc_coreLabel);
		
		coreTextField = new JTextField();
		coreTextField.setEditable(false);
		coreTextField.setColumns(10);
		GridBagConstraints gbc_coreTextField = new GridBagConstraints();
		gbc_coreTextField.insets = new Insets(0, 0, 5, 5);
		gbc_coreTextField.fill = GridBagConstraints.BOTH;
		gbc_coreTextField.gridx = 1;
		gbc_coreTextField.gridy = 1;
		primaryInfoPanel.add(coreTextField, gbc_coreTextField);
		
		JLabel threaLabel = new JLabel("Threads");
		GridBagConstraints gbc_threaLabel = new GridBagConstraints();
		gbc_threaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_threaLabel.anchor = GridBagConstraints.EAST;
		gbc_threaLabel.gridx = 2;
		gbc_threaLabel.gridy = 1;
		primaryInfoPanel.add(threaLabel, gbc_threaLabel);
		
		threadTextField = new JTextField();
		threadTextField.setEditable(false);
		threadTextField.setColumns(10);
		GridBagConstraints gbc_threadTextField = new GridBagConstraints();
		gbc_threadTextField.insets = new Insets(0, 0, 5, 5);
		gbc_threadTextField.fill = GridBagConstraints.BOTH;
		gbc_threadTextField.gridx = 3;
		gbc_threadTextField.gridy = 1;
		primaryInfoPanel.add(threadTextField, gbc_threadTextField);
		
		JLabel effectiveClockLabel = new JLabel("Effective Clock");
		GridBagConstraints gbc_effectiveClockLabel = new GridBagConstraints();
		gbc_effectiveClockLabel.insets = new Insets(0, 0, 5, 5);
		gbc_effectiveClockLabel.anchor = GridBagConstraints.EAST;
		gbc_effectiveClockLabel.gridx = 4;
		gbc_effectiveClockLabel.gridy = 1;
		primaryInfoPanel.add(effectiveClockLabel, gbc_effectiveClockLabel);
		
		factoryClockTextField = new JTextField();
		factoryClockTextField.setEditable(false);
		GridBagConstraints gbc_factoryClockTextField = new GridBagConstraints();
		gbc_factoryClockTextField.insets = new Insets(0, 0, 5, 0);
		gbc_factoryClockTextField.fill = GridBagConstraints.BOTH;
		gbc_factoryClockTextField.gridx = 5;
		gbc_factoryClockTextField.gridy = 1;
		primaryInfoPanel.add(factoryClockTextField, gbc_factoryClockTextField);
		factoryClockTextField.setColumns(10);
		
		JLabel addressWidthLabel = new JLabel("Address Width");
		GridBagConstraints gbc_addressWidthLabel = new GridBagConstraints();
		gbc_addressWidthLabel.anchor = GridBagConstraints.EAST;
		gbc_addressWidthLabel.insets = new Insets(0, 0, 0, 5);
		gbc_addressWidthLabel.gridx = 0;
		gbc_addressWidthLabel.gridy = 2;
		primaryInfoPanel.add(addressWidthLabel, gbc_addressWidthLabel);
		
		addressWidthTextField = new JTextField();
		addressWidthTextField.setEditable(false);
		GridBagConstraints gbc_addressWidthTextField = new GridBagConstraints();
		gbc_addressWidthTextField.insets = new Insets(0, 0, 0, 5);
		gbc_addressWidthTextField.fill = GridBagConstraints.BOTH;
		gbc_addressWidthTextField.gridx = 1;
		gbc_addressWidthTextField.gridy = 2;
		primaryInfoPanel.add(addressWidthTextField, gbc_addressWidthTextField);
		addressWidthTextField.setColumns(10);
		
		JLabel socketLabel = new JLabel("Socket");
		GridBagConstraints gbc_socketLabel = new GridBagConstraints();
		gbc_socketLabel.anchor = GridBagConstraints.EAST;
		gbc_socketLabel.insets = new Insets(0, 0, 0, 5);
		gbc_socketLabel.gridx = 2;
		gbc_socketLabel.gridy = 2;
		primaryInfoPanel.add(socketLabel, gbc_socketLabel);
		
		socketTextField = new JTextField();
		socketTextField.setEditable(false);
		GridBagConstraints gbc_socketTextField = new GridBagConstraints();
		gbc_socketTextField.insets = new Insets(0, 0, 0, 5);
		gbc_socketTextField.fill = GridBagConstraints.BOTH;
		gbc_socketTextField.gridx = 3;
		gbc_socketTextField.gridy = 2;
		primaryInfoPanel.add(socketTextField, gbc_socketTextField);
		socketTextField.setColumns(10);
		
		JLabel baseClockLabel = new JLabel("Base Clock");
		GridBagConstraints gbc_baseClockLabel = new GridBagConstraints();
		gbc_baseClockLabel.anchor = GridBagConstraints.EAST;
		gbc_baseClockLabel.insets = new Insets(0, 0, 0, 5);
		gbc_baseClockLabel.gridx = 4;
		gbc_baseClockLabel.gridy = 2;
		primaryInfoPanel.add(baseClockLabel, gbc_baseClockLabel);
		
		baseClockTextField = new JTextField();
		baseClockTextField.setEditable(false);
		GridBagConstraints gbc_baseClockTextField = new GridBagConstraints();
		gbc_baseClockTextField.fill = GridBagConstraints.BOTH;
		gbc_baseClockTextField.gridx = 5;
		gbc_baseClockTextField.gridy = 2;
		primaryInfoPanel.add(baseClockTextField, gbc_baseClockTextField);
		baseClockTextField.setColumns(10);
		
		// SECONDARY INFO PANEL
		JPanel secondaryInfoPanel = new JPanel();
		secondaryInfoPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Secondary Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		cpuPanel.add(secondaryInfoPanel);
		GridBagLayout gbl_secondaryInfoPanel = new GridBagLayout();
		gbl_secondaryInfoPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_secondaryInfoPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_secondaryInfoPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_secondaryInfoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		secondaryInfoPanel.setLayout(gbl_secondaryInfoPanel);
		
		JLabel versionLabel = new JLabel("Version");
		GridBagConstraints gbc_versionLabel = new GridBagConstraints();
		gbc_versionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_versionLabel.anchor = GridBagConstraints.EAST;
		gbc_versionLabel.gridx = 0;
		gbc_versionLabel.gridy = 0;
		secondaryInfoPanel.add(versionLabel, gbc_versionLabel);
		
		versionTextField = new JTextField();
		versionTextField.setEditable(false);
		GridBagConstraints gbc_versionTextField = new GridBagConstraints();
		gbc_versionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_versionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_versionTextField.gridx = 1;
		gbc_versionTextField.gridy = 0;
		secondaryInfoPanel.add(versionTextField, gbc_versionTextField);
		versionTextField.setColumns(10);
		
		JLabel familyLabel = new JLabel("Family");
		GridBagConstraints gbc_familyLabel = new GridBagConstraints();
		gbc_familyLabel.insets = new Insets(0, 0, 5, 5);
		gbc_familyLabel.anchor = GridBagConstraints.EAST;
		gbc_familyLabel.gridx = 2;
		gbc_familyLabel.gridy = 0;
		secondaryInfoPanel.add(familyLabel, gbc_familyLabel);
		
		familyTextField = new JTextField();
		familyTextField.setEditable(false);
		GridBagConstraints gbc_familyTextField = new GridBagConstraints();
		gbc_familyTextField.insets = new Insets(0, 0, 5, 5);
		gbc_familyTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_familyTextField.gridx = 3;
		gbc_familyTextField.gridy = 0;
		secondaryInfoPanel.add(familyTextField, gbc_familyTextField);
		familyTextField.setColumns(10);
		
		JLabel steppingLabel = new JLabel("Stepping");
		GridBagConstraints gbc_steppingLabel = new GridBagConstraints();
		gbc_steppingLabel.insets = new Insets(0, 0, 5, 5);
		gbc_steppingLabel.anchor = GridBagConstraints.EAST;
		gbc_steppingLabel.gridx = 4;
		gbc_steppingLabel.gridy = 0;
		secondaryInfoPanel.add(steppingLabel, gbc_steppingLabel);
		
		steppingTextField = new JTextField();
		steppingTextField.setEditable(false);
		GridBagConstraints gbc_steppingTextField = new GridBagConstraints();
		gbc_steppingTextField.insets = new Insets(0, 0, 5, 0);
		gbc_steppingTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_steppingTextField.gridx = 5;
		gbc_steppingTextField.gridy = 0;
		secondaryInfoPanel.add(steppingTextField, gbc_steppingTextField);
		steppingTextField.setColumns(10);
		
		JLabel manufacturerLabel = new JLabel("Manufacturer");
		GridBagConstraints gbc_manufacturerLabel = new GridBagConstraints();
		gbc_manufacturerLabel.anchor = GridBagConstraints.EAST;
		gbc_manufacturerLabel.insets = new Insets(0, 0, 5, 5);
		gbc_manufacturerLabel.gridx = 0;
		gbc_manufacturerLabel.gridy = 1;
		secondaryInfoPanel.add(manufacturerLabel, gbc_manufacturerLabel);
		
		manufacturerTextField = new JTextField();
		manufacturerTextField.setEditable(false);
		GridBagConstraints gbc_manufacturerTextField = new GridBagConstraints();
		gbc_manufacturerTextField.insets = new Insets(0, 0, 5, 5);
		gbc_manufacturerTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_manufacturerTextField.gridx = 1;
		gbc_manufacturerTextField.gridy = 1;
		secondaryInfoPanel.add(manufacturerTextField, gbc_manufacturerTextField);
		manufacturerTextField.setColumns(10);
		
		JLabel captionLabel = new JLabel("Caption");
		GridBagConstraints gbc_captionLabel = new GridBagConstraints();
		gbc_captionLabel.anchor = GridBagConstraints.EAST;
		gbc_captionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_captionLabel.gridx = 2;
		gbc_captionLabel.gridy = 1;
		secondaryInfoPanel.add(captionLabel, gbc_captionLabel);
		
		captionTextField = new JTextField();
		captionTextField.setEditable(false);
		GridBagConstraints gbc_captionTextField = new GridBagConstraints();
		gbc_captionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_captionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_captionTextField.gridx = 3;
		gbc_captionTextField.gridy = 1;
		secondaryInfoPanel.add(captionTextField, gbc_captionTextField);
		captionTextField.setColumns(10);
		
		JLabel processorIdLabel = new JLabel("Processor ID");
		GridBagConstraints gbc_processorIdLabel = new GridBagConstraints();
		gbc_processorIdLabel.anchor = GridBagConstraints.EAST;
		gbc_processorIdLabel.insets = new Insets(0, 0, 5, 5);
		gbc_processorIdLabel.gridx = 4;
		gbc_processorIdLabel.gridy = 1;
		secondaryInfoPanel.add(processorIdLabel, gbc_processorIdLabel);
		
		processorIdTextField = new JTextField();
		processorIdTextField.setEditable(false);
		GridBagConstraints gbc_processorIdTextField = new GridBagConstraints();
		gbc_processorIdTextField.insets = new Insets(0, 0, 5, 0);
		gbc_processorIdTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_processorIdTextField.gridx = 5;
		gbc_processorIdTextField.gridy = 1;
		secondaryInfoPanel.add(processorIdTextField, gbc_processorIdTextField);
		processorIdTextField.setColumns(10);
		
		JLabel enabledCoresLabel = new JLabel("Enabled Cores");
		GridBagConstraints gbc_enabledCoresLabel = new GridBagConstraints();
		gbc_enabledCoresLabel.anchor = GridBagConstraints.EAST;
		gbc_enabledCoresLabel.insets = new Insets(0, 0, 0, 5);
		gbc_enabledCoresLabel.gridx = 0;
		gbc_enabledCoresLabel.gridy = 2;
		secondaryInfoPanel.add(enabledCoresLabel, gbc_enabledCoresLabel);
		
		enabledCoresTextField = new JTextField();
		enabledCoresTextField.setEditable(false);
		GridBagConstraints gbc_enabledCoresTextField = new GridBagConstraints();
		gbc_enabledCoresTextField.insets = new Insets(0, 0, 0, 5);
		gbc_enabledCoresTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_enabledCoresTextField.gridx = 1;
		gbc_enabledCoresTextField.gridy = 2;
		secondaryInfoPanel.add(enabledCoresTextField, gbc_enabledCoresTextField);
		enabledCoresTextField.setColumns(10);
		
		JLabel enabledThreadsLabel = new JLabel("Enabled Threads");
		GridBagConstraints gbc_enabledThreadsLabel = new GridBagConstraints();
		gbc_enabledThreadsLabel.anchor = GridBagConstraints.EAST;
		gbc_enabledThreadsLabel.insets = new Insets(0, 0, 0, 5);
		gbc_enabledThreadsLabel.gridx = 2;
		gbc_enabledThreadsLabel.gridy = 2;
		secondaryInfoPanel.add(enabledThreadsLabel, gbc_enabledThreadsLabel);
		
		enabledThreadsTextField = new JTextField();
		enabledThreadsTextField.setEditable(false);
		GridBagConstraints gbc_enabledThreadsTextField = new GridBagConstraints();
		gbc_enabledThreadsTextField.insets = new Insets(0, 0, 0, 5);
		gbc_enabledThreadsTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_enabledThreadsTextField.gridx = 3;
		gbc_enabledThreadsTextField.gridy = 2;
		secondaryInfoPanel.add(enabledThreadsTextField, gbc_enabledThreadsTextField);
		enabledThreadsTextField.setColumns(10);
		
		JLabel reservedLabel = new JLabel("RESERVED");
		GridBagConstraints gbc_reservedLabel = new GridBagConstraints();
		gbc_reservedLabel.anchor = GridBagConstraints.EAST;
		gbc_reservedLabel.insets = new Insets(0, 0, 0, 5);
		gbc_reservedLabel.gridx = 4;
		gbc_reservedLabel.gridy = 2;
		secondaryInfoPanel.add(reservedLabel, gbc_reservedLabel);
		
		reservedTextField = new JTextField();
		reservedTextField.setText("RESERVED_FOR_FUTURE");
		reservedTextField.setEditable(false);
		GridBagConstraints gbc_reservedTextField = new GridBagConstraints();
		gbc_reservedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_reservedTextField.gridx = 5;
		gbc_reservedTextField.gridy = 2;
		secondaryInfoPanel.add(reservedTextField, gbc_reservedTextField);
		reservedTextField.setColumns(10);
	}
	
	
}
