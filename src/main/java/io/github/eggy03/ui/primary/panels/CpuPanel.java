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

public class CpuPanel extends JPanel {

	private static final long serialVersionUID = 2423707166878662262L;
	private JTextField hardwareIdTf;
	private JTextField coreTextField;
	private JTextField threadTextField;
	private JTextField versionTextField;
	private JTextField cpuNameTextField;
	
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
		
		hardwareIdTf = new JTextField();
		GridBagConstraints gbc_hardwareIdTf = new GridBagConstraints();
		gbc_hardwareIdTf.insets = new Insets(0, 0, 0, 5);
		gbc_hardwareIdTf.fill = GridBagConstraints.BOTH;
		gbc_hardwareIdTf.gridx = 0;
		gbc_hardwareIdTf.gridy = 0;
		hardwareIdPanel.add(hardwareIdTf, gbc_hardwareIdTf);
		hardwareIdTf.setColumns(10);
		
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
		gbl_primaryInfoPanel.rowHeights = new int[]{0, 0, 0};
		gbl_primaryInfoPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_primaryInfoPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
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
		gbc_coreLabel.insets = new Insets(0, 0, 0, 5);
		gbc_coreLabel.gridx = 0;
		gbc_coreLabel.gridy = 1;
		primaryInfoPanel.add(coreLabel, gbc_coreLabel);
		
		coreTextField = new JTextField();
		coreTextField.setEditable(false);
		coreTextField.setColumns(10);
		GridBagConstraints gbc_coreTextField = new GridBagConstraints();
		gbc_coreTextField.insets = new Insets(0, 0, 0, 5);
		gbc_coreTextField.fill = GridBagConstraints.BOTH;
		gbc_coreTextField.gridx = 1;
		gbc_coreTextField.gridy = 1;
		primaryInfoPanel.add(coreTextField, gbc_coreTextField);
		
		JLabel threaLabel = new JLabel("Threads");
		GridBagConstraints gbc_threaLabel = new GridBagConstraints();
		gbc_threaLabel.insets = new Insets(0, 0, 0, 5);
		gbc_threaLabel.anchor = GridBagConstraints.EAST;
		gbc_threaLabel.gridx = 2;
		gbc_threaLabel.gridy = 1;
		primaryInfoPanel.add(threaLabel, gbc_threaLabel);
		
		threadTextField = new JTextField();
		threadTextField.setEditable(false);
		threadTextField.setColumns(10);
		GridBagConstraints gbc_threadTextField = new GridBagConstraints();
		gbc_threadTextField.insets = new Insets(0, 0, 0, 5);
		gbc_threadTextField.fill = GridBagConstraints.BOTH;
		gbc_threadTextField.gridx = 3;
		gbc_threadTextField.gridy = 1;
		primaryInfoPanel.add(threadTextField, gbc_threadTextField);
		
		JLabel versionLabel = new JLabel("Version");
		GridBagConstraints gbc_versionLabel = new GridBagConstraints();
		gbc_versionLabel.insets = new Insets(0, 0, 0, 5);
		gbc_versionLabel.anchor = GridBagConstraints.EAST;
		gbc_versionLabel.gridx = 4;
		gbc_versionLabel.gridy = 1;
		primaryInfoPanel.add(versionLabel, gbc_versionLabel);
		
		versionTextField = new JTextField();
		versionTextField.setEditable(false);
		GridBagConstraints gbc_versionTextField = new GridBagConstraints();
		gbc_versionTextField.fill = GridBagConstraints.BOTH;
		gbc_versionTextField.gridx = 5;
		gbc_versionTextField.gridy = 1;
		primaryInfoPanel.add(versionTextField, gbc_versionTextField);
		versionTextField.setColumns(10);
	}
	
	
}
