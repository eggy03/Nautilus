package io.github.eggy03.ui.linux.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import io.github.eggy03.ui.linux.worker.DMIProcessorWorker;
import io.github.eggy03.ui.windows.panels.WMIProcessorPanelUI;

public class DMIProcessorPanelUI extends JPanel {

	// hwid
	private JTextField hardwareIdTextField;

	// cpu
    private JComboBox<String> cpuIdComboBox;
	private JTextField coreTextField;
	private JTextField threadTextField;
	private JTextField currentClockTextField;
	private JTextField cpuVersionTextField;
	private JTextField cpuSignatureTextField;
	private JTextField familyTextField;
	private JTextField cpuManufacturerTextField;
	private JTextField cpuSerialTextField;
	private JTextField assetTagTextField;
	private JTextField partNumberTextField;
	private JTextField enabledCoresTextField;
	private JTextField upgradeTextField;
	private JTextField cpuStatusTextField;
	private JTextField cpuVoltageTextField;
	private JTextField socketTextField;
	private JTextField baseClockTextField;
	
	private JTextArea cpuCharsAndFlagsTextArea;
    private JTextArea cacheTextArea;
    
	
	public JPanel getPanel() {
		return this;
	}

	/**
	 * Create the panel.
	 */
	public DMIProcessorPanelUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0};
		setLayout(gridBagLayout);

		//set UI
		setHardwareIdPanel();
		setCpuPanel();
        // execute workers
		setWorkers();

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
		hardwareIdTextField.setEditable(false);
		GridBagConstraints gbcHardwareIdTf = new GridBagConstraints();
		gbcHardwareIdTf.insets = new Insets(0, 0, 0, 5);
		gbcHardwareIdTf.fill = GridBagConstraints.BOTH;
		gbcHardwareIdTf.gridx = 0;
		gbcHardwareIdTf.gridy = 0;
		hardwareIdPanel.add(hardwareIdTextField, gbcHardwareIdTf);
		hardwareIdTextField.setColumns(10);
		
		JButton copyHwid = new JButton();
		copyHwid.setIcon(new FlatSVGIcon(WMIProcessorPanelUI.class.getResource("/icons/general_icons/copy.svg")));
		copyHwid.addActionListener(copyAction -> {
			StringSelection textToCopy = new StringSelection(hardwareIdTextField.getText());
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(textToCopy, null);
		});
		GridBagConstraints gbcCopyHwid = new GridBagConstraints();
		gbcCopyHwid.gridx = 1;
		gbcCopyHwid.gridy = 0;
		hardwareIdPanel.add(copyHwid, gbcCopyHwid);

		
	}
	
	private void setCpuPanel() {
		// add main cpu panel
		JPanel cpuPanel = new JPanel();
		cpuPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "CPU", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cpuPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		GridBagConstraints gbcCpuPanel = new GridBagConstraints();
		gbcCpuPanel.fill = GridBagConstraints.BOTH;
		gbcCpuPanel.gridx = 0;
		gbcCpuPanel.gridy = 1;
		add(cpuPanel, gbcCpuPanel);
		
		// PRIMARY INFO PANEL
		
		JPanel primaryInfoPanel = new JPanel();
		primaryInfoPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Primary Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gblPrimaryInfoPanel = new GridBagLayout();
		gblPrimaryInfoPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gblPrimaryInfoPanel.rowHeights = new int[]{0, 0, 0, 0};
		gblPrimaryInfoPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gblPrimaryInfoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		primaryInfoPanel.setLayout(gblPrimaryInfoPanel);
		
		JLabel cpuIdLabel = new JLabel("ID");
		GridBagConstraints gbcCpuIdLabel = new GridBagConstraints();
		gbcCpuIdLabel.insets = new Insets(0, 0, 5, 5);
		gbcCpuIdLabel.anchor = GridBagConstraints.WEST;
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
		
		JLabel cpuVersionLabel = new JLabel("Version");
		GridBagConstraints gbcCpuVersionLabel = new GridBagConstraints();
		gbcCpuVersionLabel.anchor = GridBagConstraints.WEST;
		gbcCpuVersionLabel.insets = new Insets(0, 0, 5, 5);
		gbcCpuVersionLabel.gridx = 2;
		gbcCpuVersionLabel.gridy = 0;
		primaryInfoPanel.add(cpuVersionLabel, gbcCpuVersionLabel);
		
		cpuVersionTextField = new JTextField();
		cpuVersionTextField.setEditable(false);
		GridBagConstraints gbcCpuVersionTextField = new GridBagConstraints();
		gbcCpuVersionTextField.gridwidth = 3;
		gbcCpuVersionTextField.insets = new Insets(0, 0, 5, 0);
		gbcCpuVersionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcCpuVersionTextField.gridx = 3;
		gbcCpuVersionTextField.gridy = 0;
		primaryInfoPanel.add(cpuVersionTextField, gbcCpuVersionTextField);
		cpuVersionTextField.setColumns(10);
		
		JLabel coreLabel = new JLabel("Cores");
		GridBagConstraints gbcCoreLabel = new GridBagConstraints();
		gbcCoreLabel.anchor = GridBagConstraints.WEST;
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
		gbcThreadLabel.anchor = GridBagConstraints.WEST;
		gbcThreadLabel.insets = new Insets(0, 0, 5, 5);
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
		
		JLabel currentClockLabel = new JLabel("Current Clock");
		GridBagConstraints gbcCurrentClockLabel = new GridBagConstraints();
		gbcCurrentClockLabel.insets = new Insets(0, 0, 5, 5);
		gbcCurrentClockLabel.anchor = GridBagConstraints.WEST;
		gbcCurrentClockLabel.gridx = 4;
		gbcCurrentClockLabel.gridy = 1;
		primaryInfoPanel.add(currentClockLabel, gbcCurrentClockLabel);
		
		currentClockTextField = new JTextField();
		currentClockTextField.setEditable(false);
		GridBagConstraints gbcCurrentClockTextField = new GridBagConstraints();
		gbcCurrentClockTextField.insets = new Insets(0, 0, 5, 0);
		gbcCurrentClockTextField.fill = GridBagConstraints.BOTH;
		gbcCurrentClockTextField.gridx = 5;
		gbcCurrentClockTextField.gridy = 1;
		primaryInfoPanel.add(currentClockTextField, gbcCurrentClockTextField);
		currentClockTextField.setColumns(10);
		
		JLabel cpuVoltageLabel = new JLabel("Voltage");
		GridBagConstraints gbcCpuVoltageLabel = new GridBagConstraints();
		gbcCpuVoltageLabel.anchor = GridBagConstraints.WEST;
		gbcCpuVoltageLabel.insets = new Insets(0, 0, 0, 5);
		gbcCpuVoltageLabel.gridx = 0;
		gbcCpuVoltageLabel.gridy = 2;
		primaryInfoPanel.add(cpuVoltageLabel, gbcCpuVoltageLabel);
		
		cpuVoltageTextField = new JTextField();
		cpuVoltageTextField.setEditable(false);
		GridBagConstraints gbcCpuVoltageTextField = new GridBagConstraints();
		gbcCpuVoltageTextField.insets = new Insets(0, 0, 0, 5);
		gbcCpuVoltageTextField.fill = GridBagConstraints.BOTH;
		gbcCpuVoltageTextField.gridx = 1;
		gbcCpuVoltageTextField.gridy = 2;
		primaryInfoPanel.add(cpuVoltageTextField, gbcCpuVoltageTextField);
		cpuVoltageTextField.setColumns(10);
		
		JLabel socketLabel = new JLabel("Socket");
		GridBagConstraints gbcSocketLabel = new GridBagConstraints();
		gbcSocketLabel.anchor = GridBagConstraints.WEST;
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
		gbcBaseClockLabel.anchor = GridBagConstraints.WEST;
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
		GridBagLayout gblSecondaryInfoPanel = new GridBagLayout();
		gblSecondaryInfoPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gblSecondaryInfoPanel.rowHeights = new int[]{0, 0, 0, 0};
		gblSecondaryInfoPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gblSecondaryInfoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		secondaryInfoPanel.setLayout(gblSecondaryInfoPanel);
		
		JLabel cpuSignatureLabel = new JLabel("Signature");
		GridBagConstraints gbcCpuSignatureLabel = new GridBagConstraints();
		gbcCpuSignatureLabel.insets = new Insets(0, 0, 5, 5);
		gbcCpuSignatureLabel.anchor = GridBagConstraints.WEST;
		gbcCpuSignatureLabel.gridx = 0;
		gbcCpuSignatureLabel.gridy = 0;
		secondaryInfoPanel.add(cpuSignatureLabel, gbcCpuSignatureLabel);
		
		cpuSignatureTextField = new JTextField();
		cpuSignatureTextField.setEditable(false);
		GridBagConstraints gbcCpuSignatureTextField = new GridBagConstraints();
		gbcCpuSignatureTextField.insets = new Insets(0, 0, 5, 5);
		gbcCpuSignatureTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcCpuSignatureTextField.gridx = 1;
		gbcCpuSignatureTextField.gridy = 0;
		secondaryInfoPanel.add(cpuSignatureTextField, gbcCpuSignatureTextField);
		cpuSignatureTextField.setColumns(10);
		
		JLabel familyLabel = new JLabel("Family");
		GridBagConstraints gbcFamilyLabel = new GridBagConstraints();
		gbcFamilyLabel.anchor = GridBagConstraints.WEST;
		gbcFamilyLabel.insets = new Insets(0, 0, 5, 5);
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
		
		JLabel cpuManufacturerLabel = new JLabel("Manufacturer");
		GridBagConstraints gbcCpuManufacturerLabel = new GridBagConstraints();
		gbcCpuManufacturerLabel.insets = new Insets(0, 0, 5, 5);
		gbcCpuManufacturerLabel.anchor = GridBagConstraints.WEST;
		gbcCpuManufacturerLabel.gridx = 4;
		gbcCpuManufacturerLabel.gridy = 0;
		secondaryInfoPanel.add(cpuManufacturerLabel, gbcCpuManufacturerLabel);
		
		cpuManufacturerTextField = new JTextField();
		cpuManufacturerTextField.setEditable(false);
		GridBagConstraints gbcCpuManufacturerTextField = new GridBagConstraints();
		gbcCpuManufacturerTextField.insets = new Insets(0, 0, 5, 0);
		gbcCpuManufacturerTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcCpuManufacturerTextField.gridx = 5;
		gbcCpuManufacturerTextField.gridy = 0;
		secondaryInfoPanel.add(cpuManufacturerTextField, gbcCpuManufacturerTextField);
		cpuManufacturerTextField.setColumns(10);
		
		JLabel serialNumberLabel = new JLabel("Serial");
		GridBagConstraints gbcSerialNumberLabel = new GridBagConstraints();
		gbcSerialNumberLabel.anchor = GridBagConstraints.WEST;
		gbcSerialNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbcSerialNumberLabel.gridx = 0;
		gbcSerialNumberLabel.gridy = 1;
		secondaryInfoPanel.add(serialNumberLabel, gbcSerialNumberLabel);
		
		cpuSerialTextField = new JTextField();
		cpuSerialTextField.setEditable(false);
		GridBagConstraints gbcCpuSerialTextField = new GridBagConstraints();
		gbcCpuSerialTextField.insets = new Insets(0, 0, 5, 5);
		gbcCpuSerialTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcCpuSerialTextField.gridx = 1;
		gbcCpuSerialTextField.gridy = 1;
		secondaryInfoPanel.add(cpuSerialTextField, gbcCpuSerialTextField);
		cpuSerialTextField.setColumns(10);
		
		JLabel assetTagLabel = new JLabel("Asset Tag");
		GridBagConstraints gbcAssetTagLabel = new GridBagConstraints();
		gbcAssetTagLabel.anchor = GridBagConstraints.WEST;
		gbcAssetTagLabel.insets = new Insets(0, 0, 5, 5);
		gbcAssetTagLabel.gridx = 2;
		gbcAssetTagLabel.gridy = 1;
		secondaryInfoPanel.add(assetTagLabel, gbcAssetTagLabel);
		
		assetTagTextField = new JTextField();
		assetTagTextField.setEditable(false);
		GridBagConstraints gbcAssetTagTextField = new GridBagConstraints();
		gbcAssetTagTextField.insets = new Insets(0, 0, 5, 5);
		gbcAssetTagTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcAssetTagTextField.gridx = 3;
		gbcAssetTagTextField.gridy = 1;
		secondaryInfoPanel.add(assetTagTextField, gbcAssetTagTextField);
		assetTagTextField.setColumns(10);
		
		JLabel partNumberLabel = new JLabel("Part Number");
		GridBagConstraints gbcPartNumberLabel = new GridBagConstraints();
		gbcPartNumberLabel.anchor = GridBagConstraints.WEST;
		gbcPartNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbcPartNumberLabel.gridx = 4;
		gbcPartNumberLabel.gridy = 1;
		secondaryInfoPanel.add(partNumberLabel, gbcPartNumberLabel);
		
		partNumberTextField = new JTextField();
		partNumberTextField.setEditable(false);
		GridBagConstraints gbcPartNumberTextField = new GridBagConstraints();
		gbcPartNumberTextField.insets = new Insets(0, 0, 5, 0);
		gbcPartNumberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcPartNumberTextField.gridx = 5;
		gbcPartNumberTextField.gridy = 1;
		secondaryInfoPanel.add(partNumberTextField, gbcPartNumberTextField);
		partNumberTextField.setColumns(10);
		
		JLabel enabledCoresLabel = new JLabel("Enabled Cores");
		GridBagConstraints gbcEnabledCoresLabel = new GridBagConstraints();
		gbcEnabledCoresLabel.anchor = GridBagConstraints.WEST;
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
		
		JLabel upgradeLabel = new JLabel("Upgrade");
		GridBagConstraints gbcUpgradeLabel = new GridBagConstraints();
		gbcUpgradeLabel.anchor = GridBagConstraints.WEST;
		gbcUpgradeLabel.insets = new Insets(0, 0, 0, 5);
		gbcUpgradeLabel.gridx = 2;
		gbcUpgradeLabel.gridy = 2;
		secondaryInfoPanel.add(upgradeLabel, gbcUpgradeLabel);
		
		upgradeTextField = new JTextField();
		upgradeTextField.setEditable(false);
		GridBagConstraints gbcUpgradeTextField = new GridBagConstraints();
		gbcUpgradeTextField.insets = new Insets(0, 0, 0, 5);
		gbcUpgradeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcUpgradeTextField.gridx = 3;
		gbcUpgradeTextField.gridy = 2;
		secondaryInfoPanel.add(upgradeTextField, gbcUpgradeTextField);
		upgradeTextField.setColumns(10);
		
		JLabel cpuStatusLabel = new JLabel("Status");
		GridBagConstraints gbcCpuStatusLabel = new GridBagConstraints();
		gbcCpuStatusLabel.anchor = GridBagConstraints.WEST;
		gbcCpuStatusLabel.insets = new Insets(0, 0, 0, 5);
		gbcCpuStatusLabel.gridx = 4;
		gbcCpuStatusLabel.gridy = 2;
		secondaryInfoPanel.add(cpuStatusLabel, gbcCpuStatusLabel);
		
		cpuStatusTextField = new JTextField();
		cpuStatusTextField.setEditable(false);
		GridBagConstraints gbcCpuStatusTextField = new GridBagConstraints();
		gbcCpuStatusTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcCpuStatusTextField.gridx = 5;
		gbcCpuStatusTextField.gridy = 2;
		secondaryInfoPanel.add(cpuStatusTextField, gbcCpuStatusTextField);
		cpuStatusTextField.setColumns(10);
		
		// TERTIARY INFO PANEL
		JPanel tertiaryInfoPanel = new JPanel();
		tertiaryInfoPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Tertiary Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tertiaryInfoPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel cpuCharsAndFlagsPanel = new JPanel();
		cpuCharsAndFlagsPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Characteristics and Flags", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tertiaryInfoPanel.add(cpuCharsAndFlagsPanel);
		cpuCharsAndFlagsPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane cpuCharsAndFlagsScrollPane = new JScrollPane();
		cpuCharsAndFlagsPanel.add(cpuCharsAndFlagsScrollPane);
		
		cpuCharsAndFlagsTextArea = new JTextArea();
		cpuCharsAndFlagsScrollPane.setViewportView(cpuCharsAndFlagsTextArea);
		cpuCharsAndFlagsTextArea.setEditable(false);

		JPanel cacheInfoPanel = new JPanel();
		cacheInfoPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Cache Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tertiaryInfoPanel.add(cacheInfoPanel);
		cacheInfoPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane cacheScrollPane = new JScrollPane();
		cacheInfoPanel.add(cacheScrollPane);
		
		cacheTextArea = new JTextArea();
		cacheTextArea.setRows(4);
		cacheTextArea.setEditable(false);
		cacheScrollPane.setViewportView(cacheTextArea);
		
		// add scroll panes to primary and secondary sub panels
		JScrollPane primaryInfoScrollPane = new JScrollPane();
		primaryInfoScrollPane.setViewportView(primaryInfoPanel);
		
		JScrollPane secondaryInfoScrollPane = new JScrollPane();
		secondaryInfoScrollPane.setViewportView(secondaryInfoPanel);
		
		
		// add sub scroll panes and other sub panels to the main panel
		cpuPanel.add(primaryInfoScrollPane);
		cpuPanel.add(secondaryInfoScrollPane);
		cpuPanel.add(tertiaryInfoPanel);
	}

	private void setWorkers() {

		List<JTextField> textFields = List.of(coreTextField, threadTextField, currentClockTextField, cpuVersionTextField,
				cpuSignatureTextField, familyTextField, cpuManufacturerTextField, cpuSerialTextField,
				assetTagTextField, partNumberTextField, enabledCoresTextField, upgradeTextField,
				cpuStatusTextField, cpuVoltageTextField, socketTextField, baseClockTextField
		);
		
		List<JTextArea> textAreas = List.of(cpuCharsAndFlagsTextArea, cacheTextArea);

		new DMIProcessorWorker(cpuIdComboBox, textFields, textAreas).execute();

	}


}
