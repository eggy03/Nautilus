package io.github.eggy03.ui.primary.panels;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;

public class CpuPanel extends JPanel {

	private static final long serialVersionUID = 2423707166878662262L;

	/**
	 * Create the panel.
	 */
	public CpuPanel() {
		setBorder(new TitledBorder(null, "CPU and Cache Memory", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);

	}
	
	public JPanel getPanel() {
		return this;
	}
}
