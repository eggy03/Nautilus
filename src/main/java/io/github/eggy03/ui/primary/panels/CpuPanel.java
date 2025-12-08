package io.github.eggy03.ui.primary.panels;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CpuPanel extends JPanel {

	private static final long serialVersionUID = 2423707166878662262L;
	private JTextField hardwareIdTf;
	
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
		
		JButton copyHwid = new JButton("Placeholder Text");
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
	}
	
	
}
