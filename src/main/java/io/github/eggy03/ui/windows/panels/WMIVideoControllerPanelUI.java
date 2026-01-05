package io.github.eggy03.ui.windows.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import io.github.eggy03.ui.windows.worker.WMIVideoControllerPanelWorker;

public class WMIVideoControllerPanelUI extends JPanel {
	
	private JComboBox<String> gpuDeviceIdComboBox;
	private JTextField gpuNameTextField;
	private JTextField gpuPnPDeviceIdTextField;
	private JTextField gpuHorizontalResTextField;
	private JTextField gpuVerticalResTextField;
	private JTextField gpuBitsPerPixelTextField;
	private JTextField gpuMinRefreshRateTextField;
	private JTextField gpuMaxRefreshRateTextField;
	private JTextField gpuCurrentRefreshRateTextField;
	private JTextField gpuAdapterDACTypeTextField;
	private JTextField gpuVRAMTextField;
	private JTextField gpuDriverVersionTextField;
	private JTextField gpuDriverDateTextField;
	private JTextField gpuVideoProcessorTextField;
	
	public JPanel getPanel() {
		return this;
	}
	
	public WMIVideoControllerPanelUI() {
		setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Video Controller", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(3, 0, 0, 0));
		
		setIdPanel();
		setDisplayPanel();
		setDriverPanel();

		setWorker();
	}
	
	private void setIdPanel() {
		JScrollPane identifierScrollPane = new JScrollPane();
		add(identifierScrollPane);
		
		JPanel identifierPanel = new JPanel();
		identifierPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Identifier", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		identifierScrollPane.setViewportView(identifierPanel);
		
		GridBagLayout gblIdentifierPanel = new GridBagLayout();
		gblIdentifierPanel.columnWidths = new int[]{0, 0};
		gblIdentifierPanel.rowHeights = new int[]{0, 0, 0, 0};
		gblIdentifierPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gblIdentifierPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		identifierPanel.setLayout(gblIdentifierPanel);
		
		JLabel gpuDeviceIdLabel = new JLabel("Device ID");
		GridBagConstraints gbcGpuDeviceIdLabel = new GridBagConstraints();
		gbcGpuDeviceIdLabel.anchor = GridBagConstraints.WEST;
		gbcGpuDeviceIdLabel.insets = new Insets(0, 0, 5, 5);
		gbcGpuDeviceIdLabel.gridx = 0;
		gbcGpuDeviceIdLabel.gridy = 0;
		identifierPanel.add(gpuDeviceIdLabel, gbcGpuDeviceIdLabel);
		
		gpuDeviceIdComboBox = new JComboBox<>();
		GridBagConstraints gbcGpuDeviceIdComboBox = new GridBagConstraints();
		gbcGpuDeviceIdComboBox.insets = new Insets(0, 0, 5, 5);
		gbcGpuDeviceIdComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbcGpuDeviceIdComboBox.gridx = 1;
		gbcGpuDeviceIdComboBox.gridy = 0;
		identifierPanel.add(gpuDeviceIdComboBox, gbcGpuDeviceIdComboBox);
		
		JLabel gpuNameLabel = new JLabel("Name");
		GridBagConstraints gbcGpuNameLabel = new GridBagConstraints();
		gbcGpuNameLabel.anchor = GridBagConstraints.WEST;
		gbcGpuNameLabel.insets = new Insets(0, 0, 5, 5);
		gbcGpuNameLabel.gridx = 0;
		gbcGpuNameLabel.gridy = 1;
		identifierPanel.add(gpuNameLabel, gbcGpuNameLabel);
		
		gpuNameTextField = new JTextField();
		gpuNameTextField.setEditable(false);
		GridBagConstraints gbcGpuNameTextField = new GridBagConstraints();
		gbcGpuNameTextField.insets = new Insets(0, 0, 5, 5);
		gbcGpuNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcGpuNameTextField.gridx = 1;
		gbcGpuNameTextField.gridy = 1;
		identifierPanel.add(gpuNameTextField, gbcGpuNameTextField);
		gpuNameTextField.setColumns(10);
		
		JLabel gpuPnPDeviceIdLabel = new JLabel("PnP Dev. ID");
		GridBagConstraints gbcGpuPnPDeviceIdLabel = new GridBagConstraints();
		gbcGpuPnPDeviceIdLabel.anchor = GridBagConstraints.WEST;
		gbcGpuPnPDeviceIdLabel.insets = new Insets(0, 0, 0, 5);
		gbcGpuPnPDeviceIdLabel.gridx = 0;
		gbcGpuPnPDeviceIdLabel.gridy = 2;
		identifierPanel.add(gpuPnPDeviceIdLabel, gbcGpuPnPDeviceIdLabel);
		
		gpuPnPDeviceIdTextField = new JTextField();
		gpuPnPDeviceIdTextField.setEditable(false);
		GridBagConstraints gbcGpuPnPDeviceIdTextField = new GridBagConstraints();
		gbcGpuPnPDeviceIdTextField.insets = new Insets(0, 0, 0, 5);
		gbcGpuPnPDeviceIdTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcGpuPnPDeviceIdTextField.gridx = 1;
		gbcGpuPnPDeviceIdTextField.gridy = 2;
		identifierPanel.add(gpuPnPDeviceIdTextField, gbcGpuPnPDeviceIdTextField);
		gpuPnPDeviceIdTextField.setColumns(10);
	}
	
	private void setDisplayPanel() {
		JScrollPane displayScrollPane = new JScrollPane();
		add(displayScrollPane);
		
		JPanel displayPanel = new JPanel();
		displayPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Display", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		displayScrollPane.setViewportView(displayPanel);
		
		GridBagLayout gblDisplayPanel = new GridBagLayout();
		gblDisplayPanel.columnWidths = new int[]{0, 0, 0};
		gblDisplayPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gblDisplayPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gblDisplayPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		displayPanel.setLayout(gblDisplayPanel);
		
		JLabel gpuHorizontalResLabel = new JLabel("Horizontal Res.");
		GridBagConstraints gbcGpuHorizontalResLabel = new GridBagConstraints();
		gbcGpuHorizontalResLabel.insets = new Insets(0, 0, 5, 5);
		gbcGpuHorizontalResLabel.anchor = GridBagConstraints.WEST;
		gbcGpuHorizontalResLabel.gridx = 0;
		gbcGpuHorizontalResLabel.gridy = 0;
		displayPanel.add(gpuHorizontalResLabel, gbcGpuHorizontalResLabel);
		
		gpuHorizontalResTextField = new JTextField();
		gpuHorizontalResTextField.setEditable(false);
		GridBagConstraints gbcGpuHorizontalResTextField = new GridBagConstraints();
		gbcGpuHorizontalResTextField.insets = new Insets(0, 0, 5, 0);
		gbcGpuHorizontalResTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcGpuHorizontalResTextField.gridx = 1;
		gbcGpuHorizontalResTextField.gridy = 0;
		displayPanel.add(gpuHorizontalResTextField, gbcGpuHorizontalResTextField);
		gpuHorizontalResTextField.setColumns(10);
		
		JLabel gpuVerticalResLabel = new JLabel("Vertical Res.");
		GridBagConstraints gbcGpuVerticalResLabel = new GridBagConstraints();
		gbcGpuVerticalResLabel.anchor = GridBagConstraints.WEST;
		gbcGpuVerticalResLabel.insets = new Insets(0, 0, 5, 5);
		gbcGpuVerticalResLabel.gridx = 0;
		gbcGpuVerticalResLabel.gridy = 1;
		displayPanel.add(gpuVerticalResLabel, gbcGpuVerticalResLabel);
		
		gpuVerticalResTextField = new JTextField();
		gpuVerticalResTextField.setEditable(false);
		GridBagConstraints gbcGpuVerticalResTextField = new GridBagConstraints();
		gbcGpuVerticalResTextField.insets = new Insets(0, 0, 5, 0);
		gbcGpuVerticalResTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcGpuVerticalResTextField.gridx = 1;
		gbcGpuVerticalResTextField.gridy = 1;
		displayPanel.add(gpuVerticalResTextField, gbcGpuVerticalResTextField);
		gpuVerticalResTextField.setColumns(10);
		
		JLabel gpuBitsPerPixelLabel = new JLabel("Bits Per Pixel");
		GridBagConstraints gbcGpuBitsPerPixelLabel = new GridBagConstraints();
		gbcGpuBitsPerPixelLabel.anchor = GridBagConstraints.WEST;
		gbcGpuBitsPerPixelLabel.insets = new Insets(0, 0, 5, 5);
		gbcGpuBitsPerPixelLabel.gridx = 0;
		gbcGpuBitsPerPixelLabel.gridy = 2;
		displayPanel.add(gpuBitsPerPixelLabel, gbcGpuBitsPerPixelLabel);
		
		gpuBitsPerPixelTextField = new JTextField();
		gpuBitsPerPixelTextField.setEditable(false);
		GridBagConstraints gbcGpuBitsPerPixelTextField = new GridBagConstraints();
		gbcGpuBitsPerPixelTextField.insets = new Insets(0, 0, 5, 0);
		gbcGpuBitsPerPixelTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcGpuBitsPerPixelTextField.gridx = 1;
		gbcGpuBitsPerPixelTextField.gridy = 2;
		displayPanel.add(gpuBitsPerPixelTextField, gbcGpuBitsPerPixelTextField);
		gpuBitsPerPixelTextField.setColumns(10);
		
		JLabel gpuMinRefreshRateLabel = new JLabel("Min Refresh Rate");
		GridBagConstraints gbcGpuMinRefreshRateLabel = new GridBagConstraints();
		gbcGpuMinRefreshRateLabel.anchor = GridBagConstraints.WEST;
		gbcGpuMinRefreshRateLabel.insets = new Insets(0, 0, 5, 5);
		gbcGpuMinRefreshRateLabel.gridx = 0;
		gbcGpuMinRefreshRateLabel.gridy = 3;
		displayPanel.add(gpuMinRefreshRateLabel, gbcGpuMinRefreshRateLabel);
		
		gpuMinRefreshRateTextField = new JTextField();
		gpuMinRefreshRateTextField.setEditable(false);
		GridBagConstraints gbcGpuMinRefreshRateTextField = new GridBagConstraints();
		gbcGpuMinRefreshRateTextField.insets = new Insets(0, 0, 5, 0);
		gbcGpuMinRefreshRateTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcGpuMinRefreshRateTextField.gridx = 1;
		gbcGpuMinRefreshRateTextField.gridy = 3;
		displayPanel.add(gpuMinRefreshRateTextField, gbcGpuMinRefreshRateTextField);
		gpuMinRefreshRateTextField.setColumns(10);
		
		JLabel gpuMaxRefreshRateLabel = new JLabel("Max Refresh Rate");
		GridBagConstraints gbcGpuMaxRefreshRateLabel = new GridBagConstraints();
		gbcGpuMaxRefreshRateLabel.anchor = GridBagConstraints.WEST;
		gbcGpuMaxRefreshRateLabel.insets = new Insets(0, 0, 5, 5);
		gbcGpuMaxRefreshRateLabel.gridx = 0;
		gbcGpuMaxRefreshRateLabel.gridy = 4;
		displayPanel.add(gpuMaxRefreshRateLabel, gbcGpuMaxRefreshRateLabel);
		
		gpuMaxRefreshRateTextField = new JTextField();
		gpuMaxRefreshRateTextField.setEditable(false);
		GridBagConstraints gbcGpuMaxRefreshRateTextField = new GridBagConstraints();
		gbcGpuMaxRefreshRateTextField.insets = new Insets(0, 0, 5, 0);
		gbcGpuMaxRefreshRateTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcGpuMaxRefreshRateTextField.gridx = 1;
		gbcGpuMaxRefreshRateTextField.gridy = 4;
		displayPanel.add(gpuMaxRefreshRateTextField, gbcGpuMaxRefreshRateTextField);
		gpuMaxRefreshRateTextField.setColumns(10);
		
		JLabel gpuCurrentRefreshRateLabel = new JLabel("Current Refresh Rate");
		GridBagConstraints gbcGpuCurrentRefreshRateLabel = new GridBagConstraints();
		gbcGpuCurrentRefreshRateLabel.anchor = GridBagConstraints.WEST;
		gbcGpuCurrentRefreshRateLabel.insets = new Insets(0, 0, 0, 5);
		gbcGpuCurrentRefreshRateLabel.gridx = 0;
		gbcGpuCurrentRefreshRateLabel.gridy = 5;
		displayPanel.add(gpuCurrentRefreshRateLabel, gbcGpuCurrentRefreshRateLabel);
		
		gpuCurrentRefreshRateTextField = new JTextField();
		gpuCurrentRefreshRateTextField.setEditable(false);
		GridBagConstraints gbcGpuCurrentRefreshRateTextField = new GridBagConstraints();
		gbcGpuCurrentRefreshRateTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcGpuCurrentRefreshRateTextField.gridx = 1;
		gbcGpuCurrentRefreshRateTextField.gridy = 5;
		displayPanel.add(gpuCurrentRefreshRateTextField, gbcGpuCurrentRefreshRateTextField);
		gpuCurrentRefreshRateTextField.setColumns(10);
		
	}
	
	private void setDriverPanel() {
		JScrollPane driverScrollPane = new JScrollPane();
		add(driverScrollPane);
		
		JPanel driverPanel = new JPanel();
		driverPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Driver", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		driverScrollPane.setViewportView(driverPanel);
		
		GridBagLayout gblDriverPanel = new GridBagLayout();
		gblDriverPanel.columnWidths = new int[]{0, 0, 0};
		gblDriverPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gblDriverPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gblDriverPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		driverPanel.setLayout(gblDriverPanel);
		
		JLabel gpuAdapterDACTypeLabel = new JLabel("Adapter DAC Type");
		GridBagConstraints gbcGpuAdapterDACTypeLabel = new GridBagConstraints();
		gbcGpuAdapterDACTypeLabel.anchor = GridBagConstraints.WEST;
		gbcGpuAdapterDACTypeLabel.insets = new Insets(0, 0, 5, 5);
		gbcGpuAdapterDACTypeLabel.gridx = 0;
		gbcGpuAdapterDACTypeLabel.gridy = 0;
		driverPanel.add(gpuAdapterDACTypeLabel, gbcGpuAdapterDACTypeLabel);
		
		gpuAdapterDACTypeTextField = new JTextField();
		gpuAdapterDACTypeTextField.setEditable(false);
		GridBagConstraints gbcGpuAdapterDACTypeTextField = new GridBagConstraints();
		gbcGpuAdapterDACTypeTextField.insets = new Insets(0, 0, 5, 0);
		gbcGpuAdapterDACTypeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcGpuAdapterDACTypeTextField.gridx = 1;
		gbcGpuAdapterDACTypeTextField.gridy = 0;
		driverPanel.add(gpuAdapterDACTypeTextField, gbcGpuAdapterDACTypeTextField);
		gpuAdapterDACTypeTextField.setColumns(10);
		
		JLabel gpuVRAMLabel = new JLabel("VRAM");
		GridBagConstraints gbcGpuVRAMLabel = new GridBagConstraints();
		gbcGpuVRAMLabel.anchor = GridBagConstraints.WEST;
		gbcGpuVRAMLabel.insets = new Insets(0, 0, 5, 5);
		gbcGpuVRAMLabel.gridx = 0;
		gbcGpuVRAMLabel.gridy = 1;
		driverPanel.add(gpuVRAMLabel, gbcGpuVRAMLabel);
		
		gpuVRAMTextField = new JTextField();
		gpuVRAMTextField.setEditable(false);
		GridBagConstraints gbcGpuVRAMTextField = new GridBagConstraints();
		gbcGpuVRAMTextField.insets = new Insets(0, 0, 5, 0);
		gbcGpuVRAMTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcGpuVRAMTextField.gridx = 1;
		gbcGpuVRAMTextField.gridy = 1;
		driverPanel.add(gpuVRAMTextField, gbcGpuVRAMTextField);
		gpuVRAMTextField.setColumns(10);
		
		JLabel gpuDriverVersionLabel = new JLabel("Driver Version");
		GridBagConstraints gbcGpuDriverVersionLabel = new GridBagConstraints();
		gbcGpuDriverVersionLabel.anchor = GridBagConstraints.WEST;
		gbcGpuDriverVersionLabel.insets = new Insets(0, 0, 5, 5);
		gbcGpuDriverVersionLabel.gridx = 0;
		gbcGpuDriverVersionLabel.gridy = 2;
		driverPanel.add(gpuDriverVersionLabel, gbcGpuDriverVersionLabel);
		
		gpuDriverVersionTextField = new JTextField();
		gpuDriverVersionTextField.setEditable(false);
		GridBagConstraints gbcGpuDriverVersionTextField = new GridBagConstraints();
		gbcGpuDriverVersionTextField.insets = new Insets(0, 0, 5, 0);
		gbcGpuDriverVersionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcGpuDriverVersionTextField.gridx = 1;
		gbcGpuDriverVersionTextField.gridy = 2;
		driverPanel.add(gpuDriverVersionTextField, gbcGpuDriverVersionTextField);
		gpuDriverVersionTextField.setColumns(10);
		
		JLabel gpuDriverDateLabel = new JLabel("Driver Date");
		GridBagConstraints gbcGpuDriverDateLabel = new GridBagConstraints();
		gbcGpuDriverDateLabel.anchor = GridBagConstraints.WEST;
		gbcGpuDriverDateLabel.insets = new Insets(0, 0, 5, 5);
		gbcGpuDriverDateLabel.gridx = 0;
		gbcGpuDriverDateLabel.gridy = 3;
		driverPanel.add(gpuDriverDateLabel, gbcGpuDriverDateLabel);
		
		gpuDriverDateTextField = new JTextField();
		gpuDriverDateTextField.setEditable(false);
		GridBagConstraints gbcGpuDriverDateTextField = new GridBagConstraints();
		gbcGpuDriverDateTextField.insets = new Insets(0, 0, 5, 0);
		gbcGpuDriverDateTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcGpuDriverDateTextField.gridx = 1;
		gbcGpuDriverDateTextField.gridy = 3;
		driverPanel.add(gpuDriverDateTextField, gbcGpuDriverDateTextField);
		gpuDriverDateTextField.setColumns(10);
		
		JLabel gpuVideoProcessorLabel = new JLabel("Video Processor");
		GridBagConstraints gbcGpuVideoProcessorLabel = new GridBagConstraints();
		gbcGpuVideoProcessorLabel.anchor = GridBagConstraints.WEST;
		gbcGpuVideoProcessorLabel.insets = new Insets(0, 0, 0, 5);
		gbcGpuVideoProcessorLabel.gridx = 0;
		gbcGpuVideoProcessorLabel.gridy = 4;
		driverPanel.add(gpuVideoProcessorLabel, gbcGpuVideoProcessorLabel);
		
		gpuVideoProcessorTextField = new JTextField();
		gpuVideoProcessorTextField.setEditable(false);
		GridBagConstraints gbcGpuVideoProcessorTextField = new GridBagConstraints();
		gbcGpuVideoProcessorTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcGpuVideoProcessorTextField.gridx = 1;
		gbcGpuVideoProcessorTextField.gridy = 4;
		driverPanel.add(gpuVideoProcessorTextField, gbcGpuVideoProcessorTextField);
		gpuVideoProcessorTextField.setColumns(10);
	}

	private void setWorker() {

		List<JTextField> gpuFields = List.of(
		gpuNameTextField, gpuPnPDeviceIdTextField, gpuHorizontalResTextField, gpuVerticalResTextField,
		gpuBitsPerPixelTextField, gpuMinRefreshRateTextField, gpuMaxRefreshRateTextField, gpuCurrentRefreshRateTextField,
		gpuAdapterDACTypeTextField, gpuVRAMTextField, gpuDriverVersionTextField, gpuDriverDateTextField,
		gpuVideoProcessorTextField
		);
		
		new WMIVideoControllerPanelWorker(gpuDeviceIdComboBox, gpuFields).execute();
	}
}
