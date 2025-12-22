package io.github.eggy03.ui.windows.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class MainboardPanelUI extends JPanel {
	
	private JComboBox<Integer> baseboardNumberComboBox;
	private JTextField baseboardManufacturerTextField;
	private JTextField baseboardModelTextField;
	private JTextField baseboardProductTextField;
	private JTextField baseboardSerialNumberTextField;
	private JTextField baseboardVersionTextField;
	
	private JComboBox<String> baseboardPortTagComboBox;
	private JTextField baseboardPortTypeTextField;
	private JTextField baseboardPortIRDTextField;
	private JTextField baseboardPortERDTextField;
	
	private JComboBox<Integer> biosNumberComboBox;
	private JTextField biosCaptionTextField;
	private JTextField biosCurrentLanguageTextField;
	private JTextField biosManufacturerTextField;
	private JTextField biosNameTextField;
	private JTextField biosPrimaryTextField;
	private JTextField biosReleaseDateTextField;
	private JTextField biosSmbiosVersionTextField;
	private JTextField biosSmbiosPresenceTextField;
	private JTextField biosStatusTextField;
	private JTextField biosVersionTextField;
	

	public JPanel getPanel() {
		return this;
	}

	/**
	 * Create the panel.
	 */
	public MainboardPanelUI() {
		setLayout(new GridLayout(0, 1, 0, 0));

		setBaseboardPanel();
		setBaseboardPortPanel();
		setBIOSPanel();

		setWorkers();
	}

	private void setBaseboardPanel() {
		JPanel baseboardPanel = new JPanel();
		baseboardPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Baseboard", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(baseboardPanel);
		GridBagLayout gblBaseboardPanel = new GridBagLayout();
		gblBaseboardPanel.columnWidths = new int[]{0, 0, 0};
		gblBaseboardPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gblBaseboardPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gblBaseboardPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		baseboardPanel.setLayout(gblBaseboardPanel);

		JLabel baseboardNumberLabel = new JLabel("Baseboard#");
		GridBagConstraints gbcBaseboardNumberLabel = new GridBagConstraints();
		gbcBaseboardNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbcBaseboardNumberLabel.anchor = GridBagConstraints.WEST;
		gbcBaseboardNumberLabel.gridx = 0;
		gbcBaseboardNumberLabel.gridy = 0;
		baseboardPanel.add(baseboardNumberLabel, gbcBaseboardNumberLabel);

		baseboardNumberComboBox = new JComboBox<>();
		GridBagConstraints gbcBaseboardNumberComboBox = new GridBagConstraints();
		gbcBaseboardNumberComboBox.insets = new Insets(0, 0, 5, 0);
		gbcBaseboardNumberComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbcBaseboardNumberComboBox.gridx = 1;
		gbcBaseboardNumberComboBox.gridy = 0;
		baseboardPanel.add(baseboardNumberComboBox, gbcBaseboardNumberComboBox);

		JLabel baseboardManufacturerLabel = new JLabel("Manufacturer");
		GridBagConstraints gbcBaseboardManufacturerLabel = new GridBagConstraints();
		gbcBaseboardManufacturerLabel.anchor = GridBagConstraints.WEST;
		gbcBaseboardManufacturerLabel.insets = new Insets(0, 0, 5, 5);
		gbcBaseboardManufacturerLabel.gridx = 0;
		gbcBaseboardManufacturerLabel.gridy = 1;
		baseboardPanel.add(baseboardManufacturerLabel, gbcBaseboardManufacturerLabel);

		baseboardManufacturerTextField = new JTextField();
		baseboardManufacturerTextField.setEditable(false);
		GridBagConstraints gbcBaseboardManufacturerTextField = new GridBagConstraints();
		gbcBaseboardManufacturerTextField.insets = new Insets(0, 0, 5, 0);
		gbcBaseboardManufacturerTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBaseboardManufacturerTextField.gridx = 1;
		gbcBaseboardManufacturerTextField.gridy = 1;
		baseboardPanel.add(baseboardManufacturerTextField, gbcBaseboardManufacturerTextField);
		baseboardManufacturerTextField.setColumns(10);

		JLabel baseboardModelLabel = new JLabel("Model");
		GridBagConstraints gbcBaseboardModelLabel = new GridBagConstraints();
		gbcBaseboardModelLabel.anchor = GridBagConstraints.WEST;
		gbcBaseboardModelLabel.insets = new Insets(0, 0, 5, 5);
		gbcBaseboardModelLabel.gridx = 0;
		gbcBaseboardModelLabel.gridy = 2;
		baseboardPanel.add(baseboardModelLabel, gbcBaseboardModelLabel);

		baseboardModelTextField = new JTextField();
		baseboardModelTextField.setEditable(false);
		GridBagConstraints gbcBaseboardModelTextField = new GridBagConstraints();
		gbcBaseboardModelTextField.insets = new Insets(0, 0, 5, 0);
		gbcBaseboardModelTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBaseboardModelTextField.gridx = 1;
		gbcBaseboardModelTextField.gridy = 2;
		baseboardPanel.add(baseboardModelTextField, gbcBaseboardModelTextField);
		baseboardModelTextField.setColumns(10);

		JLabel baseboardProductLabel = new JLabel("Product");
		GridBagConstraints gbcBaseboardProductLabel = new GridBagConstraints();
		gbcBaseboardProductLabel.anchor = GridBagConstraints.WEST;
		gbcBaseboardProductLabel.insets = new Insets(0, 0, 5, 5);
		gbcBaseboardProductLabel.gridx = 0;
		gbcBaseboardProductLabel.gridy = 3;
		baseboardPanel.add(baseboardProductLabel, gbcBaseboardProductLabel);

		baseboardProductTextField = new JTextField();
		baseboardProductTextField.setEditable(false);
		GridBagConstraints gbcBaseboardProductTextField = new GridBagConstraints();
		gbcBaseboardProductTextField.insets = new Insets(0, 0, 5, 0);
		gbcBaseboardProductTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBaseboardProductTextField.gridx = 1;
		gbcBaseboardProductTextField.gridy = 3;
		baseboardPanel.add(baseboardProductTextField, gbcBaseboardProductTextField);
		baseboardProductTextField.setColumns(10);

		JLabel baseboardSerialNumberLabel = new JLabel("Serial Number");
		GridBagConstraints gbcBaseboardSerialNumberLabel = new GridBagConstraints();
		gbcBaseboardSerialNumberLabel.anchor = GridBagConstraints.WEST;
		gbcBaseboardSerialNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbcBaseboardSerialNumberLabel.gridx = 0;
		gbcBaseboardSerialNumberLabel.gridy = 4;
		baseboardPanel.add(baseboardSerialNumberLabel, gbcBaseboardSerialNumberLabel);

		baseboardSerialNumberTextField = new JTextField();
		baseboardSerialNumberTextField.setEditable(false);
		GridBagConstraints gbcBaseboardSerialNumberTextField = new GridBagConstraints();
		gbcBaseboardSerialNumberTextField.insets = new Insets(0, 0, 5, 0);
		gbcBaseboardSerialNumberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBaseboardSerialNumberTextField.gridx = 1;
		gbcBaseboardSerialNumberTextField.gridy = 4;
		baseboardPanel.add(baseboardSerialNumberTextField, gbcBaseboardSerialNumberTextField);
		baseboardSerialNumberTextField.setColumns(10);

		JLabel baseboardVersionLabel = new JLabel("Version");
		GridBagConstraints gbcBaseboardVersionLabel = new GridBagConstraints();
		gbcBaseboardVersionLabel.anchor = GridBagConstraints.WEST;
		gbcBaseboardVersionLabel.insets = new Insets(0, 0, 0, 5);
		gbcBaseboardVersionLabel.gridx = 0;
		gbcBaseboardVersionLabel.gridy = 5;
		baseboardPanel.add(baseboardVersionLabel, gbcBaseboardVersionLabel);

		baseboardVersionTextField = new JTextField();
		baseboardVersionTextField.setEditable(false);
		GridBagConstraints gbcBaseboardVersionTextField = new GridBagConstraints();
		gbcBaseboardVersionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBaseboardVersionTextField.gridx = 1;
		gbcBaseboardVersionTextField.gridy = 5;
		baseboardPanel.add(baseboardVersionTextField, gbcBaseboardVersionTextField);
		baseboardVersionTextField.setColumns(10);

	}

	private void setBaseboardPortPanel() {
		JPanel baseboardPortPanel = new JPanel();
		baseboardPortPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Baseboard Port", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(baseboardPortPanel);
		GridBagLayout gblBaseboardPortPanel = new GridBagLayout();
		gblBaseboardPortPanel.columnWidths = new int[]{0, 0, 0};
		gblBaseboardPortPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gblBaseboardPortPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gblBaseboardPortPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		baseboardPortPanel.setLayout(gblBaseboardPortPanel);
		
		JLabel baseboardPortTagLabel = new JLabel("Tag");
		GridBagConstraints gbcBaseboardPortTagLabel = new GridBagConstraints();
		gbcBaseboardPortTagLabel.insets = new Insets(0, 0, 5, 5);
		gbcBaseboardPortTagLabel.anchor = GridBagConstraints.WEST;
		gbcBaseboardPortTagLabel.gridx = 0;
		gbcBaseboardPortTagLabel.gridy = 0;
		baseboardPortPanel.add(baseboardPortTagLabel, gbcBaseboardPortTagLabel);
		
		baseboardPortTagComboBox = new JComboBox<>();
		GridBagConstraints gbcBaseboardPortTagComboBox = new GridBagConstraints();
		gbcBaseboardPortTagComboBox.insets = new Insets(0, 0, 5, 0);
		gbcBaseboardPortTagComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbcBaseboardPortTagComboBox.gridx = 1;
		gbcBaseboardPortTagComboBox.gridy = 0;
		baseboardPortPanel.add(baseboardPortTagComboBox, gbcBaseboardPortTagComboBox);
		
		JLabel baseboardPortTypeLabel = new JLabel("Type");
		GridBagConstraints gbcBaseboardPortTypeLabel = new GridBagConstraints();
		gbcBaseboardPortTypeLabel.anchor = GridBagConstraints.WEST;
		gbcBaseboardPortTypeLabel.insets = new Insets(0, 0, 5, 5);
		gbcBaseboardPortTypeLabel.gridx = 0;
		gbcBaseboardPortTypeLabel.gridy = 1;
		baseboardPortPanel.add(baseboardPortTypeLabel, gbcBaseboardPortTypeLabel);
		
		baseboardPortTypeTextField = new JTextField();
		baseboardPortTypeTextField.setEditable(false);
		GridBagConstraints gbcBaseboardPortTypeTextField = new GridBagConstraints();
		gbcBaseboardPortTypeTextField.insets = new Insets(0, 0, 5, 0);
		gbcBaseboardPortTypeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBaseboardPortTypeTextField.gridx = 1;
		gbcBaseboardPortTypeTextField.gridy = 1;
		baseboardPortPanel.add(baseboardPortTypeTextField, gbcBaseboardPortTypeTextField);
		baseboardPortTypeTextField.setColumns(10);
		
		JLabel baseboardPortIRDLabel = new JLabel("Internal RD");
		GridBagConstraints gbcBaseboardPortIRDLabel = new GridBagConstraints();
		gbcBaseboardPortIRDLabel.anchor = GridBagConstraints.WEST;
		gbcBaseboardPortIRDLabel.insets = new Insets(0, 0, 5, 5);
		gbcBaseboardPortIRDLabel.gridx = 0;
		gbcBaseboardPortIRDLabel.gridy = 2;
		baseboardPortPanel.add(baseboardPortIRDLabel, gbcBaseboardPortIRDLabel);
		
		baseboardPortIRDTextField = new JTextField();
		baseboardPortIRDTextField.setEditable(false);
		GridBagConstraints gbcBaseboardPortIRDTextField = new GridBagConstraints();
		gbcBaseboardPortIRDTextField.insets = new Insets(0, 0, 5, 0);
		gbcBaseboardPortIRDTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBaseboardPortIRDTextField.gridx = 1;
		gbcBaseboardPortIRDTextField.gridy = 2;
		baseboardPortPanel.add(baseboardPortIRDTextField, gbcBaseboardPortIRDTextField);
		baseboardPortIRDTextField.setColumns(10);
		
		JLabel baseboardPortERDLabel = new JLabel("External RD");
		GridBagConstraints gbcBaseboardPortERDLabel = new GridBagConstraints();
		gbcBaseboardPortERDLabel.anchor = GridBagConstraints.WEST;
		gbcBaseboardPortERDLabel.insets = new Insets(0, 0, 0, 5);
		gbcBaseboardPortERDLabel.gridx = 0;
		gbcBaseboardPortERDLabel.gridy = 3;
		baseboardPortPanel.add(baseboardPortERDLabel, gbcBaseboardPortERDLabel);
		
		baseboardPortERDTextField = new JTextField();
		baseboardPortERDTextField.setEditable(false);
		GridBagConstraints gbcBaseboardPortERDTextField = new GridBagConstraints();
		gbcBaseboardPortERDTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBaseboardPortERDTextField.gridx = 1;
		gbcBaseboardPortERDTextField.gridy = 3;
		baseboardPortPanel.add(baseboardPortERDTextField, gbcBaseboardPortERDTextField);
		baseboardPortERDTextField.setColumns(10);
	}

	private void setBIOSPanel() {
		JPanel biosPanel = new JPanel();
		biosPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "BIOS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(biosPanel);
		GridBagLayout gblBiosPanel = new GridBagLayout();
		gblBiosPanel.columnWidths = new int[]{0, 0, 0};
		gblBiosPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gblBiosPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gblBiosPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		biosPanel.setLayout(gblBiosPanel);
		
		JLabel biosNumberLabel = new JLabel("BIOS#");
		GridBagConstraints gbcBiosNumberLabel = new GridBagConstraints();
		gbcBiosNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbcBiosNumberLabel.anchor = GridBagConstraints.WEST;
		gbcBiosNumberLabel.gridx = 0;
		gbcBiosNumberLabel.gridy = 0;
		biosPanel.add(biosNumberLabel, gbcBiosNumberLabel);
		
		biosNumberComboBox = new JComboBox<>();
		GridBagConstraints gbcBiosNumberComboBox = new GridBagConstraints();
		gbcBiosNumberComboBox.insets = new Insets(0, 0, 5, 0);
		gbcBiosNumberComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbcBiosNumberComboBox.gridx = 1;
		gbcBiosNumberComboBox.gridy = 0;
		biosPanel.add(biosNumberComboBox, gbcBiosNumberComboBox);
		
		JLabel biosCaptionLabel = new JLabel("Caption");
		GridBagConstraints gbcBiosCaptionLabel = new GridBagConstraints();
		gbcBiosCaptionLabel.anchor = GridBagConstraints.WEST;
		gbcBiosCaptionLabel.insets = new Insets(0, 0, 5, 5);
		gbcBiosCaptionLabel.gridx = 0;
		gbcBiosCaptionLabel.gridy = 1;
		biosPanel.add(biosCaptionLabel, gbcBiosCaptionLabel);
		
		biosCaptionTextField = new JTextField();
		biosCaptionTextField.setEditable(false);
		GridBagConstraints gbcBiosCaptionTextField = new GridBagConstraints();
		gbcBiosCaptionTextField.insets = new Insets(0, 0, 5, 0);
		gbcBiosCaptionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBiosCaptionTextField.gridx = 1;
		gbcBiosCaptionTextField.gridy = 1;
		biosPanel.add(biosCaptionTextField, gbcBiosCaptionTextField);
		biosCaptionTextField.setColumns(10);
		
		JLabel biosCurrentLanguageLevel = new JLabel("Current Language");
		GridBagConstraints gbcBiosCurrentLanguageLevel = new GridBagConstraints();
		gbcBiosCurrentLanguageLevel.anchor = GridBagConstraints.WEST;
		gbcBiosCurrentLanguageLevel.insets = new Insets(0, 0, 5, 5);
		gbcBiosCurrentLanguageLevel.gridx = 0;
		gbcBiosCurrentLanguageLevel.gridy = 2;
		biosPanel.add(biosCurrentLanguageLevel, gbcBiosCurrentLanguageLevel);
		
		biosCurrentLanguageTextField = new JTextField();
		biosCurrentLanguageTextField.setEditable(false);
		GridBagConstraints gbcBiosCurrentLanguageTextField = new GridBagConstraints();
		gbcBiosCurrentLanguageTextField.insets = new Insets(0, 0, 5, 0);
		gbcBiosCurrentLanguageTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBiosCurrentLanguageTextField.gridx = 1;
		gbcBiosCurrentLanguageTextField.gridy = 2;
		biosPanel.add(biosCurrentLanguageTextField, gbcBiosCurrentLanguageTextField);
		biosCurrentLanguageTextField.setColumns(10);
		
		JLabel biosManufacturerLabel = new JLabel("Manufacturer");
		GridBagConstraints gbcBiosManufacturerLabel = new GridBagConstraints();
		gbcBiosManufacturerLabel.anchor = GridBagConstraints.WEST;
		gbcBiosManufacturerLabel.insets = new Insets(0, 0, 5, 5);
		gbcBiosManufacturerLabel.gridx = 0;
		gbcBiosManufacturerLabel.gridy = 3;
		biosPanel.add(biosManufacturerLabel, gbcBiosManufacturerLabel);
		
		biosManufacturerTextField = new JTextField();
		biosManufacturerTextField.setEditable(false);
		GridBagConstraints gbcBiosManufacturerTextField = new GridBagConstraints();
		gbcBiosManufacturerTextField.insets = new Insets(0, 0, 5, 0);
		gbcBiosManufacturerTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBiosManufacturerTextField.gridx = 1;
		gbcBiosManufacturerTextField.gridy = 3;
		biosPanel.add(biosManufacturerTextField, gbcBiosManufacturerTextField);
		biosManufacturerTextField.setColumns(10);
		
		JLabel biosNameLabel = new JLabel("Name");
		GridBagConstraints gbcBiosNameLabel = new GridBagConstraints();
		gbcBiosNameLabel.anchor = GridBagConstraints.WEST;
		gbcBiosNameLabel.insets = new Insets(0, 0, 5, 5);
		gbcBiosNameLabel.gridx = 0;
		gbcBiosNameLabel.gridy = 4;
		biosPanel.add(biosNameLabel, gbcBiosNameLabel);
		
		biosNameTextField = new JTextField();
		biosNameTextField.setEditable(false);
		GridBagConstraints gbcBiosNameTextField = new GridBagConstraints();
		gbcBiosNameTextField.insets = new Insets(0, 0, 5, 0);
		gbcBiosNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBiosNameTextField.gridx = 1;
		gbcBiosNameTextField.gridy = 4;
		biosPanel.add(biosNameTextField, gbcBiosNameTextField);
		biosNameTextField.setColumns(10);
		
		JLabel biosPrimaryLabel = new JLabel("Primary BIOS");
		GridBagConstraints gbcBiosPrimaryLabel = new GridBagConstraints();
		gbcBiosPrimaryLabel.anchor = GridBagConstraints.WEST;
		gbcBiosPrimaryLabel.insets = new Insets(0, 0, 5, 5);
		gbcBiosPrimaryLabel.gridx = 0;
		gbcBiosPrimaryLabel.gridy = 5;
		biosPanel.add(biosPrimaryLabel, gbcBiosPrimaryLabel);
		
		biosPrimaryTextField = new JTextField();
		biosPrimaryTextField.setEditable(false);
		GridBagConstraints gbcBiosPrimaryTextField = new GridBagConstraints();
		gbcBiosPrimaryTextField.insets = new Insets(0, 0, 5, 0);
		gbcBiosPrimaryTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBiosPrimaryTextField.gridx = 1;
		gbcBiosPrimaryTextField.gridy = 5;
		biosPanel.add(biosPrimaryTextField, gbcBiosPrimaryTextField);
		biosPrimaryTextField.setColumns(10);
		
		JLabel biosReleaseDateLabel = new JLabel("Release Date");
		GridBagConstraints gbcBiosReleaseDateLabel = new GridBagConstraints();
		gbcBiosReleaseDateLabel.anchor = GridBagConstraints.WEST;
		gbcBiosReleaseDateLabel.insets = new Insets(0, 0, 5, 5);
		gbcBiosReleaseDateLabel.gridx = 0;
		gbcBiosReleaseDateLabel.gridy = 6;
		biosPanel.add(biosReleaseDateLabel, gbcBiosReleaseDateLabel);
		
		biosReleaseDateTextField = new JTextField();
		biosReleaseDateTextField.setEditable(false);
		GridBagConstraints gbcBiosReleaseDateTextField = new GridBagConstraints();
		gbcBiosReleaseDateTextField.insets = new Insets(0, 0, 5, 0);
		gbcBiosReleaseDateTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBiosReleaseDateTextField.gridx = 1;
		gbcBiosReleaseDateTextField.gridy = 6;
		biosPanel.add(biosReleaseDateTextField, gbcBiosReleaseDateTextField);
		biosReleaseDateTextField.setColumns(10);
		
		JLabel biosSmbiosVersionLabel = new JLabel("SMBIOS BIOS Ver.");
		GridBagConstraints gbcBiosSmbiosVersionLabel = new GridBagConstraints();
		gbcBiosSmbiosVersionLabel.anchor = GridBagConstraints.WEST;
		gbcBiosSmbiosVersionLabel.insets = new Insets(0, 0, 5, 5);
		gbcBiosSmbiosVersionLabel.gridx = 0;
		gbcBiosSmbiosVersionLabel.gridy = 7;
		biosPanel.add(biosSmbiosVersionLabel, gbcBiosSmbiosVersionLabel);
		
		biosSmbiosVersionTextField = new JTextField();
		biosSmbiosVersionTextField.setEditable(false);
		GridBagConstraints gbcBiosSmbiosVersionTextField = new GridBagConstraints();
		gbcBiosSmbiosVersionTextField.insets = new Insets(0, 0, 5, 0);
		gbcBiosSmbiosVersionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBiosSmbiosVersionTextField.gridx = 1;
		gbcBiosSmbiosVersionTextField.gridy = 7;
		biosPanel.add(biosSmbiosVersionTextField, gbcBiosSmbiosVersionTextField);
		biosSmbiosVersionTextField.setColumns(10);
		
		JLabel biosSmbiosPresenceLabel = new JLabel("SMBIOS Present");
		GridBagConstraints gbcBiosSmbiosPresenceLabel = new GridBagConstraints();
		gbcBiosSmbiosPresenceLabel.anchor = GridBagConstraints.WEST;
		gbcBiosSmbiosPresenceLabel.insets = new Insets(0, 0, 5, 5);
		gbcBiosSmbiosPresenceLabel.gridx = 0;
		gbcBiosSmbiosPresenceLabel.gridy = 8;
		biosPanel.add(biosSmbiosPresenceLabel, gbcBiosSmbiosPresenceLabel);
		
		biosSmbiosPresenceTextField = new JTextField();
		biosSmbiosPresenceTextField.setEditable(false);
		GridBagConstraints gbcBiosSmbiosPresenceTextField = new GridBagConstraints();
		gbcBiosSmbiosPresenceTextField.insets = new Insets(0, 0, 5, 0);
		gbcBiosSmbiosPresenceTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBiosSmbiosPresenceTextField.gridx = 1;
		gbcBiosSmbiosPresenceTextField.gridy = 8;
		biosPanel.add(biosSmbiosPresenceTextField, gbcBiosSmbiosPresenceTextField);
		biosSmbiosPresenceTextField.setColumns(10);
		
		JLabel biosStatusLabel = new JLabel("Status");
		GridBagConstraints gbcBiosStatusLabel = new GridBagConstraints();
		gbcBiosStatusLabel.anchor = GridBagConstraints.WEST;
		gbcBiosStatusLabel.insets = new Insets(0, 0, 5, 5);
		gbcBiosStatusLabel.gridx = 0;
		gbcBiosStatusLabel.gridy = 9;
		biosPanel.add(biosStatusLabel, gbcBiosStatusLabel);
		
		biosStatusTextField = new JTextField();
		biosStatusTextField.setEditable(false);
		GridBagConstraints gbcBiosStatusTextField = new GridBagConstraints();
		gbcBiosStatusTextField.insets = new Insets(0, 0, 5, 0);
		gbcBiosStatusTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBiosStatusTextField.gridx = 1;
		gbcBiosStatusTextField.gridy = 9;
		biosPanel.add(biosStatusTextField, gbcBiosStatusTextField);
		biosStatusTextField.setColumns(10);
		
		JLabel biosVersionLabel = new JLabel("Version");
		GridBagConstraints gbcBiosVersionLabel = new GridBagConstraints();
		gbcBiosVersionLabel.anchor = GridBagConstraints.WEST;
		gbcBiosVersionLabel.insets = new Insets(0, 0, 5, 5);
		gbcBiosVersionLabel.gridx = 0;
		gbcBiosVersionLabel.gridy = 10;
		biosPanel.add(biosVersionLabel, gbcBiosVersionLabel);
		
		biosVersionTextField = new JTextField();
		biosVersionTextField.setEditable(false);
		GridBagConstraints gbcBiosVersionTextField = new GridBagConstraints();
		gbcBiosVersionTextField.insets = new Insets(0, 0, 5, 0);
		gbcBiosVersionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcBiosVersionTextField.gridx = 1;
		gbcBiosVersionTextField.gridy = 10;
		biosPanel.add(biosVersionTextField, gbcBiosVersionTextField);
		biosVersionTextField.setColumns(10);
	}

	private void setWorkers() {
			// TODO
	}

}
