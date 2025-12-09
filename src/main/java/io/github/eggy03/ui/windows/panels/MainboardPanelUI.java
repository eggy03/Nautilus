package io.github.eggy03.ui.windows.panels;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;

public class MainboardPanelUI extends JPanel {

	public JPanel getPanel() {
		return this;
	}

	/**
	 * Create the panel.
	 */
	public MainboardPanelUI() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel baseboardPanel = new JPanel();
		baseboardPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Baseboard", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(baseboardPanel);
		GridBagLayout gbl_baseboardPanel = new GridBagLayout();
		gbl_baseboardPanel.columnWidths = new int[]{0};
		gbl_baseboardPanel.rowHeights = new int[]{0};
		gbl_baseboardPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_baseboardPanel.rowWeights = new double[]{Double.MIN_VALUE};
		baseboardPanel.setLayout(gbl_baseboardPanel);
		
		JPanel baseboardPortPanel = new JPanel();
		baseboardPortPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Baseboard Port", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(baseboardPortPanel);
		baseboardPortPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel biosPanel = new JPanel();
		biosPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "BIOS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(biosPanel);
		GridBagLayout gbl_biosPanel = new GridBagLayout();
		gbl_biosPanel.columnWidths = new int[]{0};
		gbl_biosPanel.rowHeights = new int[]{0};
		gbl_biosPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_biosPanel.rowWeights = new double[]{Double.MIN_VALUE};
		biosPanel.setLayout(gbl_biosPanel);

	}

}
