package io.github.eggy03.ui.primary.panels;

import io.github.eggy03.ui.primary.worker.CpuWorker;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.Serial;
import java.util.List;

public class CpuPanel extends JPanel {

	@Serial
	private static final long serialVersionUID = 2423707166878662262L;
	private JTextField hardwareIdTextField;
    JComboBox<String> cpuIdComboBox;
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
	private JTextField l1TextField;
	private JTextField l2TextField;
	private JTextField l3TextField;
	private JTextField l4TextField;
    
	
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
        new CpuWorker(cpuIdComboBox, List.of(
                hardwareIdTextField,
                coreTextField,
                threadTextField,
                factoryClockTextField,
                cpuNameTextField,
                versionTextField,
                familyTextField,
                steppingTextField,
                manufacturerTextField,
                captionTextField,
                processorIdTextField,
                enabledCoresTextField,
                enabledThreadsTextField,
                reservedTextField,
                addressWidthTextField,
                socketTextField,
                baseClockTextField,
                l1TextField,
                l2TextField,
                l3TextField,
                l4TextField
        )).execute();
	}
	
	private void setHardwareIdPanel() {
		
		JPanel hardwareIdPanel = new JPanel();
		hardwareIdPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "HardwareID", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GridBagConstraints gbcHardwareIdPanel = new GridBagConstraints();
		gbcHardwareIdPanel.insets = new Insets(0, 0, 5, 0);
		gbcHardwareIdPanel.fill = GridBagConstraints.BOTH;
		gbcHardwareIdPanel.gridx = 0;
		gbcHardwareIdPanel.gridy = 0;
		add(hardwareIdPanel, gbcHardwareIdPanel);
        GridBagLayout gblHardwareIdPanel = new GridBagLayout();
        gblHardwareIdPanel.columnWidths = new int[]{956, 0, 0};
        gblHardwareIdPanel.rowHeights = new int[]{21, 0};
        gblHardwareIdPanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
        gblHardwareIdPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		hardwareIdPanel.setLayout(gblHardwareIdPanel);


		hardwareIdTextField = new JTextField();
		GridBagConstraints gbcHardwareIdTf = new GridBagConstraints();
		gbcHardwareIdTf.insets = new Insets(0, 0, 0, 5);
		gbcHardwareIdTf.fill = GridBagConstraints.BOTH;
		gbcHardwareIdTf.gridx = 0;
		gbcHardwareIdTf.gridy = 0;
		hardwareIdPanel.add(hardwareIdTextField, gbcHardwareIdTf);
		hardwareIdTextField.setColumns(10);
		
		JButton copyHwid = new JButton("Button");
		GridBagConstraints gbcCopyHwid = new GridBagConstraints();
		gbcCopyHwid.gridx = 1;
		gbcCopyHwid.gridy = 0;
		hardwareIdPanel.add(copyHwid, gbcCopyHwid);
		
	}
	
	private void setCpuPanel() {
		
		JPanel cpuPanel = new JPanel();
		cpuPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "CPU", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbcCpuPanel = new GridBagConstraints();
		gbcCpuPanel.insets = new Insets(0, 0, 5, 0);
		gbcCpuPanel.fill = GridBagConstraints.BOTH;
		gbcCpuPanel.gridx = 0;
		gbcCpuPanel.gridy = 1;
		add(cpuPanel, gbcCpuPanel);
		cpuPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		// PRIMARY INFO PANEL
		JPanel primaryInfoPanel = new JPanel();
		primaryInfoPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Primary Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cpuPanel.add(primaryInfoPanel);
		GridBagLayout gblPrimaryInfoPanel = new GridBagLayout();
		gblPrimaryInfoPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gblPrimaryInfoPanel.rowHeights = new int[]{0, 0, 0, 0};
		gblPrimaryInfoPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gblPrimaryInfoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		primaryInfoPanel.setLayout(gblPrimaryInfoPanel);
		
		JLabel cpuIdLabel = new JLabel("CPU#");
		GridBagConstraints gbcCpuIdLabel = new GridBagConstraints();
		gbcCpuIdLabel.insets = new Insets(0, 0, 5, 5);
		gbcCpuIdLabel.anchor = GridBagConstraints.EAST;
		gbcCpuIdLabel.gridx = 0;
		gbcCpuIdLabel.gridy = 0;
		primaryInfoPanel.add(cpuIdLabel, gbcCpuIdLabel);

        cpuIdComboBox = new JComboBox<>();
		GridBagConstraints gbcCpuIdComboBox = new GridBagConstraints();
		gbcCpuIdComboBox.insets = new Insets(0, 0, 5, 5);
		gbcCpuIdComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbcCpuIdComboBox.gridx = 1;
		gbcCpuIdComboBox.gridy = 0;
		primaryInfoPanel.add(cpuIdComboBox, gbcCpuIdComboBox);
		
		JLabel cpuNameLabel = new JLabel("Name");
		GridBagConstraints gbcCpuNameLabel = new GridBagConstraints();
		gbcCpuNameLabel.insets = new Insets(0, 0, 5, 5);
		gbcCpuNameLabel.anchor = GridBagConstraints.EAST;
		gbcCpuNameLabel.gridx = 2;
		gbcCpuNameLabel.gridy = 0;
		primaryInfoPanel.add(cpuNameLabel, gbcCpuNameLabel);
		
		cpuNameTextField = new JTextField();
		cpuNameTextField.setEditable(false);
		GridBagConstraints gbcCpuNameTextField = new GridBagConstraints();
		gbcCpuNameTextField.gridwidth = 3;
		gbcCpuNameTextField.insets = new Insets(0, 0, 5, 0);
		gbcCpuNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcCpuNameTextField.gridx = 3;
		gbcCpuNameTextField.gridy = 0;
		primaryInfoPanel.add(cpuNameTextField, gbcCpuNameTextField);
		cpuNameTextField.setColumns(10);
		
		JLabel coreLabel = new JLabel("Cores");
		GridBagConstraints gbcCoreLabel = new GridBagConstraints();
		gbcCoreLabel.anchor = GridBagConstraints.EAST;
		gbcCoreLabel.insets = new Insets(0, 0, 5, 5);
		gbcCoreLabel.gridx = 0;
		gbcCoreLabel.gridy = 1;
		primaryInfoPanel.add(coreLabel, gbcCoreLabel);
		
		coreTextField = new JTextField();
		coreTextField.setEditable(false);
		coreTextField.setColumns(10);
		GridBagConstraints gbcCoreTextField = new GridBagConstraints();
		gbcCoreTextField.insets = new Insets(0, 0, 5, 5);
		gbcCoreTextField.fill = GridBagConstraints.BOTH;
		gbcCoreTextField.gridx = 1;
		gbcCoreTextField.gridy = 1;
		primaryInfoPanel.add(coreTextField, gbcCoreTextField);
		
		JLabel threadLabel = new JLabel("Threads");
		GridBagConstraints gbcThreadLabel = new GridBagConstraints();
		gbcThreadLabel.insets = new Insets(0, 0, 5, 5);
		gbcThreadLabel.anchor = GridBagConstraints.EAST;
		gbcThreadLabel.gridx = 2;
		gbcThreadLabel.gridy = 1;
		primaryInfoPanel.add(threadLabel, gbcThreadLabel);
		
		threadTextField = new JTextField();
		threadTextField.setEditable(false);
		threadTextField.setColumns(10);
		GridBagConstraints gbcThreadTextField = new GridBagConstraints();
		gbcThreadTextField.insets = new Insets(0, 0, 5, 5);
		gbcThreadTextField.fill = GridBagConstraints.BOTH;
		gbcThreadTextField.gridx = 3;
		gbcThreadTextField.gridy = 1;
		primaryInfoPanel.add(threadTextField, gbcThreadTextField);
		
		JLabel effectiveClockLabel = new JLabel("Effective Clock");
		GridBagConstraints gbcEffectiveClockLabel = new GridBagConstraints();
		gbcEffectiveClockLabel.insets = new Insets(0, 0, 5, 5);
		gbcEffectiveClockLabel.anchor = GridBagConstraints.EAST;
		gbcEffectiveClockLabel.gridx = 4;
		gbcEffectiveClockLabel.gridy = 1;
		primaryInfoPanel.add(effectiveClockLabel, gbcEffectiveClockLabel);
		
		factoryClockTextField = new JTextField();
		factoryClockTextField.setEditable(false);
		GridBagConstraints gbcFactoryClockTextField = new GridBagConstraints();
		gbcFactoryClockTextField.insets = new Insets(0, 0, 5, 0);
		gbcFactoryClockTextField.fill = GridBagConstraints.BOTH;
		gbcFactoryClockTextField.gridx = 5;
		gbcFactoryClockTextField.gridy = 1;
		primaryInfoPanel.add(factoryClockTextField, gbcFactoryClockTextField);
		factoryClockTextField.setColumns(10);
		
		JLabel addressWidthLabel = new JLabel("Address Width");
		GridBagConstraints gbcAddressWidthLabel = new GridBagConstraints();
		gbcAddressWidthLabel.anchor = GridBagConstraints.EAST;
		gbcAddressWidthLabel.insets = new Insets(0, 0, 0, 5);
		gbcAddressWidthLabel.gridx = 0;
		gbcAddressWidthLabel.gridy = 2;
		primaryInfoPanel.add(addressWidthLabel, gbcAddressWidthLabel);
		
		addressWidthTextField = new JTextField();
		addressWidthTextField.setEditable(false);
		GridBagConstraints gbcAddressWidthTextField = new GridBagConstraints();
		gbcAddressWidthTextField.insets = new Insets(0, 0, 0, 5);
		gbcAddressWidthTextField.fill = GridBagConstraints.BOTH;
		gbcAddressWidthTextField.gridx = 1;
		gbcAddressWidthTextField.gridy = 2;
		primaryInfoPanel.add(addressWidthTextField, gbcAddressWidthTextField);
		addressWidthTextField.setColumns(10);
		
		JLabel socketLabel = new JLabel("Socket");
		GridBagConstraints gbcSocketLabel = new GridBagConstraints();
		gbcSocketLabel.anchor = GridBagConstraints.EAST;
		gbcSocketLabel.insets = new Insets(0, 0, 0, 5);
		gbcSocketLabel.gridx = 2;
		gbcSocketLabel.gridy = 2;
		primaryInfoPanel.add(socketLabel, gbcSocketLabel);
		
		socketTextField = new JTextField();
		socketTextField.setEditable(false);
		GridBagConstraints gbcSocketTextField = new GridBagConstraints();
		gbcSocketTextField.insets = new Insets(0, 0, 0, 5);
		gbcSocketTextField.fill = GridBagConstraints.BOTH;
		gbcSocketTextField.gridx = 3;
		gbcSocketTextField.gridy = 2;
		primaryInfoPanel.add(socketTextField, gbcSocketTextField);
		socketTextField.setColumns(10);
		
		JLabel baseClockLabel = new JLabel("Base Clock");
		GridBagConstraints gbcBaseClockLabel = new GridBagConstraints();
		gbcBaseClockLabel.anchor = GridBagConstraints.EAST;
		gbcBaseClockLabel.insets = new Insets(0, 0, 0, 5);
		gbcBaseClockLabel.gridx = 4;
		gbcBaseClockLabel.gridy = 2;
		primaryInfoPanel.add(baseClockLabel, gbcBaseClockLabel);
		
		baseClockTextField = new JTextField();
		baseClockTextField.setEditable(false);
		GridBagConstraints gbcBaseClockTextField = new GridBagConstraints();
		gbcBaseClockTextField.fill = GridBagConstraints.BOTH;
		gbcBaseClockTextField.gridx = 5;
		gbcBaseClockTextField.gridy = 2;
		primaryInfoPanel.add(baseClockTextField, gbcBaseClockTextField);
		baseClockTextField.setColumns(10);
		
		// SECONDARY INFO PANEL
		JPanel secondaryInfoPanel = new JPanel();
		secondaryInfoPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Secondary Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cpuPanel.add(secondaryInfoPanel);
		GridBagLayout gblSecondaryInfoPanel = new GridBagLayout();
		gblSecondaryInfoPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gblSecondaryInfoPanel.rowHeights = new int[]{0, 0, 0, 0};
		gblSecondaryInfoPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gblSecondaryInfoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		secondaryInfoPanel.setLayout(gblSecondaryInfoPanel);
		
		JLabel versionLabel = new JLabel("Version");
		GridBagConstraints gbcVersionLabel = new GridBagConstraints();
		gbcVersionLabel.insets = new Insets(0, 0, 5, 5);
		gbcVersionLabel.anchor = GridBagConstraints.EAST;
		gbcVersionLabel.gridx = 0;
		gbcVersionLabel.gridy = 0;
		secondaryInfoPanel.add(versionLabel, gbcVersionLabel);
		
		versionTextField = new JTextField();
		versionTextField.setEditable(false);
		GridBagConstraints gbcVersionTextField = new GridBagConstraints();
		gbcVersionTextField.insets = new Insets(0, 0, 5, 5);
		gbcVersionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcVersionTextField.gridx = 1;
		gbcVersionTextField.gridy = 0;
		secondaryInfoPanel.add(versionTextField, gbcVersionTextField);
		versionTextField.setColumns(10);
		
		JLabel familyLabel = new JLabel("Family");
		GridBagConstraints gbcFamilyLabel = new GridBagConstraints();
		gbcFamilyLabel.insets = new Insets(0, 0, 5, 5);
		gbcFamilyLabel.anchor = GridBagConstraints.EAST;
		gbcFamilyLabel.gridx = 2;
		gbcFamilyLabel.gridy = 0;
		secondaryInfoPanel.add(familyLabel, gbcFamilyLabel);
		
		familyTextField = new JTextField();
		familyTextField.setEditable(false);
		GridBagConstraints gbcFamilyTextField = new GridBagConstraints();
		gbcFamilyTextField.insets = new Insets(0, 0, 5, 5);
		gbcFamilyTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcFamilyTextField.gridx = 3;
		gbcFamilyTextField.gridy = 0;
		secondaryInfoPanel.add(familyTextField, gbcFamilyTextField);
		familyTextField.setColumns(10);
		
		JLabel steppingLabel = new JLabel("Stepping");
		GridBagConstraints gbcSteppingLabel = new GridBagConstraints();
		gbcSteppingLabel.insets = new Insets(0, 0, 5, 5);
		gbcSteppingLabel.anchor = GridBagConstraints.EAST;
		gbcSteppingLabel.gridx = 4;
		gbcSteppingLabel.gridy = 0;
		secondaryInfoPanel.add(steppingLabel, gbcSteppingLabel);
		
		steppingTextField = new JTextField();
		steppingTextField.setEditable(false);
		GridBagConstraints gbcSteppingTextField = new GridBagConstraints();
		gbcSteppingTextField.insets = new Insets(0, 0, 5, 0);
		gbcSteppingTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcSteppingTextField.gridx = 5;
		gbcSteppingTextField.gridy = 0;
		secondaryInfoPanel.add(steppingTextField, gbcSteppingTextField);
		steppingTextField.setColumns(10);
		
		JLabel manufacturerLabel = new JLabel("Manufacturer");
		GridBagConstraints gbcManufacturerLabel = new GridBagConstraints();
		gbcManufacturerLabel.anchor = GridBagConstraints.EAST;
		gbcManufacturerLabel.insets = new Insets(0, 0, 5, 5);
		gbcManufacturerLabel.gridx = 0;
		gbcManufacturerLabel.gridy = 1;
		secondaryInfoPanel.add(manufacturerLabel, gbcManufacturerLabel);
		
		manufacturerTextField = new JTextField();
		manufacturerTextField.setEditable(false);
		GridBagConstraints gbcManufacturerTextField = new GridBagConstraints();
		gbcManufacturerTextField.insets = new Insets(0, 0, 5, 5);
		gbcManufacturerTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcManufacturerTextField.gridx = 1;
		gbcManufacturerTextField.gridy = 1;
		secondaryInfoPanel.add(manufacturerTextField, gbcManufacturerTextField);
		manufacturerTextField.setColumns(10);
		
		JLabel captionLabel = new JLabel("Caption");
		GridBagConstraints gbcCaptionLabel = new GridBagConstraints();
		gbcCaptionLabel.anchor = GridBagConstraints.EAST;
		gbcCaptionLabel.insets = new Insets(0, 0, 5, 5);
		gbcCaptionLabel.gridx = 2;
		gbcCaptionLabel.gridy = 1;
		secondaryInfoPanel.add(captionLabel, gbcCaptionLabel);
		
		captionTextField = new JTextField();
		captionTextField.setEditable(false);
		GridBagConstraints gbcCaptionTextField = new GridBagConstraints();
		gbcCaptionTextField.insets = new Insets(0, 0, 5, 5);
		gbcCaptionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcCaptionTextField.gridx = 3;
		gbcCaptionTextField.gridy = 1;
		secondaryInfoPanel.add(captionTextField, gbcCaptionTextField);
		captionTextField.setColumns(10);
		
		JLabel processorIdLabel = new JLabel("Processor ID");
		GridBagConstraints gbcProcessorIdLabel = new GridBagConstraints();
		gbcProcessorIdLabel.anchor = GridBagConstraints.EAST;
		gbcProcessorIdLabel.insets = new Insets(0, 0, 5, 5);
		gbcProcessorIdLabel.gridx = 4;
		gbcProcessorIdLabel.gridy = 1;
		secondaryInfoPanel.add(processorIdLabel, gbcProcessorIdLabel);
		
		processorIdTextField = new JTextField();
		processorIdTextField.setEditable(false);
		GridBagConstraints gbcProcessorIdTextField = new GridBagConstraints();
		gbcProcessorIdTextField.insets = new Insets(0, 0, 5, 0);
		gbcProcessorIdTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcProcessorIdTextField.gridx = 5;
		gbcProcessorIdTextField.gridy = 1;
		secondaryInfoPanel.add(processorIdTextField, gbcProcessorIdTextField);
		processorIdTextField.setColumns(10);
		
		JLabel enabledCoresLabel = new JLabel("Enabled Cores");
		GridBagConstraints gbcEnabledCoresLabel = new GridBagConstraints();
		gbcEnabledCoresLabel.anchor = GridBagConstraints.EAST;
		gbcEnabledCoresLabel.insets = new Insets(0, 0, 0, 5);
		gbcEnabledCoresLabel.gridx = 0;
		gbcEnabledCoresLabel.gridy = 2;
		secondaryInfoPanel.add(enabledCoresLabel, gbcEnabledCoresLabel);
		
		enabledCoresTextField = new JTextField();
		enabledCoresTextField.setEditable(false);
		GridBagConstraints gbcEnabledCoresTextField = new GridBagConstraints();
		gbcEnabledCoresTextField.insets = new Insets(0, 0, 0, 5);
		gbcEnabledCoresTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcEnabledCoresTextField.gridx = 1;
		gbcEnabledCoresTextField.gridy = 2;
		secondaryInfoPanel.add(enabledCoresTextField, gbcEnabledCoresTextField);
		enabledCoresTextField.setColumns(10);
		
		JLabel enabledThreadsLabel = new JLabel("Enabled Threads");
		GridBagConstraints gbcEnabledThreadsLabel = new GridBagConstraints();
		gbcEnabledThreadsLabel.anchor = GridBagConstraints.EAST;
		gbcEnabledThreadsLabel.insets = new Insets(0, 0, 0, 5);
		gbcEnabledThreadsLabel.gridx = 2;
		gbcEnabledThreadsLabel.gridy = 2;
		secondaryInfoPanel.add(enabledThreadsLabel, gbcEnabledThreadsLabel);
		
		enabledThreadsTextField = new JTextField();
		enabledThreadsTextField.setEditable(false);
		GridBagConstraints gbcEnabledThreadsTextField = new GridBagConstraints();
		gbcEnabledThreadsTextField.insets = new Insets(0, 0, 0, 5);
		gbcEnabledThreadsTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcEnabledThreadsTextField.gridx = 3;
		gbcEnabledThreadsTextField.gridy = 2;
		secondaryInfoPanel.add(enabledThreadsTextField, gbcEnabledThreadsTextField);
		enabledThreadsTextField.setColumns(10);
		
		JLabel reservedLabel = new JLabel("RESERVED");
		GridBagConstraints gbcReservedLabel = new GridBagConstraints();
		gbcReservedLabel.anchor = GridBagConstraints.EAST;
		gbcReservedLabel.insets = new Insets(0, 0, 0, 5);
		gbcReservedLabel.gridx = 4;
		gbcReservedLabel.gridy = 2;
		secondaryInfoPanel.add(reservedLabel, gbcReservedLabel);
		
		reservedTextField = new JTextField();
		reservedTextField.setText("RESERVED_FOR_FUTURE");
		reservedTextField.setEditable(false);
		GridBagConstraints gbcReservedTextField = new GridBagConstraints();
		gbcReservedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcReservedTextField.gridx = 5;
		gbcReservedTextField.gridy = 2;
		secondaryInfoPanel.add(reservedTextField, gbcReservedTextField);
		reservedTextField.setColumns(10);
		
		// CACHE PANEL
		JPanel cachePanel = new JPanel();
		cachePanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Cache Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cpuPanel.add(cachePanel);
		cachePanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel cacheSizePanel = new JPanel();
		cacheSizePanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Cache Sizes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cachePanel.add(cacheSizePanel);
		GridBagLayout gblCacheSizePanel = new GridBagLayout();
		gblCacheSizePanel.columnWidths = new int[]{0, 0, 0};
		gblCacheSizePanel.rowHeights = new int[]{0, 0, 0, 0};
		gblCacheSizePanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gblCacheSizePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		cacheSizePanel.setLayout(gblCacheSizePanel);
		
		JLabel l1Label = new JLabel("L1 Cache");
		GridBagConstraints gbcL1Label = new GridBagConstraints();
		gbcL1Label.insets = new Insets(0, 0, 5, 5);
		gbcL1Label.anchor = GridBagConstraints.EAST;
		gbcL1Label.gridx = 0;
		gbcL1Label.gridy = 0;
		cacheSizePanel.add(l1Label, gbcL1Label);
		
		l1TextField = new JTextField();
		l1TextField.setEditable(false);
		GridBagConstraints gbcL1TextField = new GridBagConstraints();
		gbcL1TextField.insets = new Insets(0, 0, 5, 0);
		gbcL1TextField.fill = GridBagConstraints.HORIZONTAL;
		gbcL1TextField.gridx = 1;
		gbcL1TextField.gridy = 0;
		cacheSizePanel.add(l1TextField, gbcL1TextField);
		l1TextField.setColumns(10);
		
		JLabel l2Label = new JLabel("L2 Cache");
		GridBagConstraints gbcL2Label = new GridBagConstraints();
		gbcL2Label.anchor = GridBagConstraints.EAST;
		gbcL2Label.insets = new Insets(0, 0, 5, 5);
		gbcL2Label.gridx = 0;
		gbcL2Label.gridy = 1;
		cacheSizePanel.add(l2Label, gbcL2Label);
		
		l2TextField = new JTextField();
		l2TextField.setEditable(false);
		GridBagConstraints gbcL2TextField = new GridBagConstraints();
		gbcL2TextField.insets = new Insets(0, 0, 5, 0);
		gbcL2TextField.fill = GridBagConstraints.HORIZONTAL;
		gbcL2TextField.gridx = 1;
		gbcL2TextField.gridy = 1;
		cacheSizePanel.add(l2TextField, gbcL2TextField);
		l2TextField.setColumns(10);
		
		JLabel l3Label = new JLabel("L3 Cache");
		GridBagConstraints gbcL3Label = new GridBagConstraints();
		gbcL3Label.insets = new Insets(0, 0, 5, 5);
		gbcL3Label.anchor = GridBagConstraints.EAST;
		gbcL3Label.gridx = 0;
		gbcL3Label.gridy = 2;
		cacheSizePanel.add(l3Label, gbcL3Label);
		
		l3TextField = new JTextField();
		l3TextField.setEditable(false);
		GridBagConstraints gbcL3TextField = new GridBagConstraints();
		gbcL3TextField.insets = new Insets(0, 0, 5, 0);
		gbcL3TextField.fill = GridBagConstraints.HORIZONTAL;
		gbcL3TextField.gridx = 1;
		gbcL3TextField.gridy = 2;
		cacheSizePanel.add(l3TextField, gbcL3TextField);
		l3TextField.setColumns(10);
		
		JLabel l4Label = new JLabel("L4 Cache");
		GridBagConstraints gbcL4Label = new GridBagConstraints();
		gbcL4Label.anchor = GridBagConstraints.EAST;
		gbcL4Label.insets = new Insets(0, 0, 0, 5);
		gbcL4Label.gridx = 0;
		gbcL4Label.gridy = 3;
		cacheSizePanel.add(l4Label, gbcL4Label);
		
		l4TextField = new JTextField();
		l4TextField.setEditable(false);
		GridBagConstraints gbcL4TextField = new GridBagConstraints();
		gbcL4TextField.fill = GridBagConstraints.HORIZONTAL;
		gbcL4TextField.gridx = 1;
		gbcL4TextField.gridy = 3;
		cacheSizePanel.add(l4TextField, gbcL4TextField);
		l4TextField.setColumns(10);
		
		JPanel cpuManufacturerLogoPanel = new JPanel();
		cpuManufacturerLogoPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "CPU Manufacturer Logo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cachePanel.add(cpuManufacturerLogoPanel);
		
		JPanel extraCacheInfoPanel = new JPanel();
		extraCacheInfoPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Extra Cache Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cachePanel.add(extraCacheInfoPanel);
		extraCacheInfoPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane extraCacheScrollPane = new JScrollPane();
		extraCacheInfoPanel.add(extraCacheScrollPane);
		
		JTextArea extraCacheTextArea = new JTextArea();
		extraCacheTextArea.setEditable(false);
		extraCacheScrollPane.setViewportView(extraCacheTextArea);
	}
}
