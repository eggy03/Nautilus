package io.github.eggy03.ui.windows.panels;

import io.github.eggy03.ui.windows.worker.WMINetworkPanelWorker;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class WMINetworkPanelUI extends JPanel {
	
	private JComboBox<Long> networkInterfaceIdComboBox;

	private JTextField networkDeviceIdTextField;
	private JTextField networkNameTextField;
	private JTextField networkDriverVersionTextField;
	private JTextField networkDriverDateTextField;
	private JTextField networkTypeTextField;
	private JTextField networkLinkLayerAddressTextField;
	private JTextField networkLinkSpeedTextField;
	private JTextField networkMediaConnectStateTextField;
	private JTextField networkMediaConnectTypeTextField;
	private JTextField networkReceiveLinkSpeedTextField;
	private JTextField networkTransmitLinkSpeedTextField;
	private JTextField networkDuplexityTextField;
	private JTextField networkVirtualityTextField;
	private JTextField networkStatusTextField;
	private JTextField networkPnPDeviceIdTextField;

	private JEditorPane adapterIpEditorPane;
	private JEditorPane adapterDnsEditorPane;
	private JEditorPane adapterConnectionProfileEditorPane;
	
	public JPanel getPanel() {
		return this;
	}

	public WMINetworkPanelUI() {
		setLayout(new GridLayout(2, 0, 0, 0));
		
		setAdapterPanel();
		setAdapterPropertyTabbedPane();
		setWorker();
	}
	
	private void setAdapterPanel() {
		
		JPanel adapterPanel = new JPanel();
		adapterPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Adapter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gblAdapterPanel = new GridBagLayout();
		gblAdapterPanel.columnWidths = new int[]{0, 0, 0};
		gblAdapterPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gblAdapterPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gblAdapterPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		adapterPanel.setLayout(gblAdapterPanel);

		// set scrollpane
		JScrollPane adapterScrollPane = new JScrollPane();
		adapterScrollPane.setViewportView(adapterPanel);
		add(adapterScrollPane);
		
		JLabel networkInterfaceIdLabel = new JLabel("Interface#");
		GridBagConstraints gbcNetworkInterfaceIdLabel = new GridBagConstraints();
		gbcNetworkInterfaceIdLabel.insets = new Insets(0, 0, 5, 5);
		gbcNetworkInterfaceIdLabel.anchor = GridBagConstraints.WEST;
		gbcNetworkInterfaceIdLabel.gridx = 0;
		gbcNetworkInterfaceIdLabel.gridy = 0;
		adapterPanel.add(networkInterfaceIdLabel, gbcNetworkInterfaceIdLabel);
		
		networkInterfaceIdComboBox = new JComboBox<>();
		GridBagConstraints gbcNetworkInterfaceIdComboBox = new GridBagConstraints();
		gbcNetworkInterfaceIdComboBox.insets = new Insets(0, 0, 5, 0);
		gbcNetworkInterfaceIdComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbcNetworkInterfaceIdComboBox.gridx = 1;
		gbcNetworkInterfaceIdComboBox.gridy = 0;
		adapterPanel.add(networkInterfaceIdComboBox, gbcNetworkInterfaceIdComboBox);
		
		JLabel networkDeviceIdLabel = new JLabel("DeviceID");
		GridBagConstraints gbcNetworkDeviceIdLabel = new GridBagConstraints();
		gbcNetworkDeviceIdLabel.insets = new Insets(0, 0, 5, 5);
		gbcNetworkDeviceIdLabel.anchor = GridBagConstraints.WEST;
		gbcNetworkDeviceIdLabel.gridx = 0;
		gbcNetworkDeviceIdLabel.gridy = 1;
		adapterPanel.add(networkDeviceIdLabel, gbcNetworkDeviceIdLabel);
		
		networkDeviceIdTextField = new JTextField();
		networkDeviceIdTextField.setEditable(false);
		GridBagConstraints gbcNetworkDeviceIdTextField = new GridBagConstraints();
		gbcNetworkDeviceIdTextField.insets = new Insets(0, 0, 5, 0);
		gbcNetworkDeviceIdTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcNetworkDeviceIdTextField.gridx = 1;
		gbcNetworkDeviceIdTextField.gridy = 1;
		adapterPanel.add(networkDeviceIdTextField, gbcNetworkDeviceIdTextField);
		
		JLabel networkNameLabel = new JLabel("Name");
		GridBagConstraints gbcNetworkNameLabel = new GridBagConstraints();
		gbcNetworkNameLabel.anchor = GridBagConstraints.WEST;
		gbcNetworkNameLabel.insets = new Insets(0, 0, 5, 5);
		gbcNetworkNameLabel.gridx = 0;
		gbcNetworkNameLabel.gridy = 2;
		adapterPanel.add(networkNameLabel, gbcNetworkNameLabel);
		
		networkNameTextField = new JTextField();
		networkNameTextField.setEditable(false);
		GridBagConstraints gbcNetworkNameTextField = new GridBagConstraints();
		gbcNetworkNameTextField.insets = new Insets(0, 0, 5, 0);
		gbcNetworkNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcNetworkNameTextField.gridx = 1;
		gbcNetworkNameTextField.gridy = 2;
		adapterPanel.add(networkNameTextField, gbcNetworkNameTextField);
		networkNameTextField.setColumns(10);
		
		JLabel networkDriverVersionLabel = new JLabel("Driver Version");
		GridBagConstraints gbcNetworkDriverVersionLabel = new GridBagConstraints();
		gbcNetworkDriverVersionLabel.anchor = GridBagConstraints.WEST;
		gbcNetworkDriverVersionLabel.insets = new Insets(0, 0, 5, 5);
		gbcNetworkDriverVersionLabel.gridx = 0;
		gbcNetworkDriverVersionLabel.gridy = 3;
		adapterPanel.add(networkDriverVersionLabel, gbcNetworkDriverVersionLabel);
		
		networkDriverVersionTextField = new JTextField();
		networkDriverVersionTextField.setEditable(false);
		GridBagConstraints gbcNetworkDriverVersionTextField = new GridBagConstraints();
		gbcNetworkDriverVersionTextField.insets = new Insets(0, 0, 5, 0);
		gbcNetworkDriverVersionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcNetworkDriverVersionTextField.gridx = 1;
		gbcNetworkDriverVersionTextField.gridy = 3;
		adapterPanel.add(networkDriverVersionTextField, gbcNetworkDriverVersionTextField);
		networkDriverVersionTextField.setColumns(10);
		
		JLabel networkDriverDateLabel = new JLabel("Driver Date");
		GridBagConstraints gbcNetworkDriverDateLabel = new GridBagConstraints();
		gbcNetworkDriverDateLabel.anchor = GridBagConstraints.WEST;
		gbcNetworkDriverDateLabel.insets = new Insets(0, 0, 5, 5);
		gbcNetworkDriverDateLabel.gridx = 0;
		gbcNetworkDriverDateLabel.gridy = 4;
		adapterPanel.add(networkDriverDateLabel, gbcNetworkDriverDateLabel);
		
		networkDriverDateTextField = new JTextField();
		networkDriverDateTextField.setEditable(false);
		GridBagConstraints gbcNetworkDriverDateTextField = new GridBagConstraints();
		gbcNetworkDriverDateTextField.insets = new Insets(0, 0, 5, 0);
		gbcNetworkDriverDateTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcNetworkDriverDateTextField.gridx = 1;
		gbcNetworkDriverDateTextField.gridy = 4;
		adapterPanel.add(networkDriverDateTextField, gbcNetworkDriverDateTextField);
		networkDriverDateTextField.setColumns(10);
		
		JLabel networkTypeLabel = new JLabel("Type");
		GridBagConstraints gbcNetworkTypeLabel = new GridBagConstraints();
		gbcNetworkTypeLabel.anchor = GridBagConstraints.WEST;
		gbcNetworkTypeLabel.insets = new Insets(0, 0, 5, 5);
		gbcNetworkTypeLabel.gridx = 0;
		gbcNetworkTypeLabel.gridy = 5;
		adapterPanel.add(networkTypeLabel, gbcNetworkTypeLabel);
		
		networkTypeTextField = new JTextField();
		networkTypeTextField.setEditable(false);
		GridBagConstraints gbcNetworkTypeTextField = new GridBagConstraints();
		gbcNetworkTypeTextField.insets = new Insets(0, 0, 5, 0);
		gbcNetworkTypeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcNetworkTypeTextField.gridx = 1;
		gbcNetworkTypeTextField.gridy = 5;
		adapterPanel.add(networkTypeTextField, gbcNetworkTypeTextField);
		networkTypeTextField.setColumns(10);
		
		JLabel networkLinkLayerAddressLabel = new JLabel("MAC");
		GridBagConstraints gbcNetworkLinkLayerAddressLabel = new GridBagConstraints();
		gbcNetworkLinkLayerAddressLabel.anchor = GridBagConstraints.WEST;
		gbcNetworkLinkLayerAddressLabel.insets = new Insets(0, 0, 5, 5);
		gbcNetworkLinkLayerAddressLabel.gridx = 0;
		gbcNetworkLinkLayerAddressLabel.gridy = 6;
		adapterPanel.add(networkLinkLayerAddressLabel, gbcNetworkLinkLayerAddressLabel);
		
		networkLinkLayerAddressTextField = new JTextField();
		networkLinkLayerAddressTextField.setEditable(false);
		GridBagConstraints gbcNetworkLinkLayerAddressTextField = new GridBagConstraints();
		gbcNetworkLinkLayerAddressTextField.insets = new Insets(0, 0, 5, 0);
		gbcNetworkLinkLayerAddressTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcNetworkLinkLayerAddressTextField.gridx = 1;
		gbcNetworkLinkLayerAddressTextField.gridy = 6;
		adapterPanel.add(networkLinkLayerAddressTextField, gbcNetworkLinkLayerAddressTextField);
		networkLinkLayerAddressTextField.setColumns(10);
		
		JLabel networkLinkSpeedLabel = new JLabel("Link Speed");
		GridBagConstraints gbcNetworkLinkSpeedLabel = new GridBagConstraints();
		gbcNetworkLinkSpeedLabel.anchor = GridBagConstraints.WEST;
		gbcNetworkLinkSpeedLabel.insets = new Insets(0, 0, 5, 5);
		gbcNetworkLinkSpeedLabel.gridx = 0;
		gbcNetworkLinkSpeedLabel.gridy = 7;
		adapterPanel.add(networkLinkSpeedLabel, gbcNetworkLinkSpeedLabel);
		
		networkLinkSpeedTextField = new JTextField();
		networkLinkSpeedTextField.setEditable(false);
		GridBagConstraints gbcNetworkLinkSpeedTextField = new GridBagConstraints();
		gbcNetworkLinkSpeedTextField.insets = new Insets(0, 0, 5, 0);
		gbcNetworkLinkSpeedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcNetworkLinkSpeedTextField.gridx = 1;
		gbcNetworkLinkSpeedTextField.gridy = 7;
		adapterPanel.add(networkLinkSpeedTextField, gbcNetworkLinkSpeedTextField);
		networkLinkSpeedTextField.setColumns(10);
		
		JLabel networkMediaConnectStateLabel = new JLabel("Connect State");
		GridBagConstraints gbcNetworkMediaConnectStateLabel = new GridBagConstraints();
		gbcNetworkMediaConnectStateLabel.anchor = GridBagConstraints.WEST;
		gbcNetworkMediaConnectStateLabel.insets = new Insets(0, 0, 5, 5);
		gbcNetworkMediaConnectStateLabel.gridx = 0;
		gbcNetworkMediaConnectStateLabel.gridy = 8;
		adapterPanel.add(networkMediaConnectStateLabel, gbcNetworkMediaConnectStateLabel);
		
		networkMediaConnectStateTextField = new JTextField();
		networkMediaConnectStateTextField.setEditable(false);
		GridBagConstraints gbcNetworkMediaConnectStateTextField = new GridBagConstraints();
		gbcNetworkMediaConnectStateTextField.insets = new Insets(0, 0, 5, 0);
		gbcNetworkMediaConnectStateTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcNetworkMediaConnectStateTextField.gridx = 1;
		gbcNetworkMediaConnectStateTextField.gridy = 8;
		adapterPanel.add(networkMediaConnectStateTextField, gbcNetworkMediaConnectStateTextField);
		networkMediaConnectStateTextField.setColumns(10);
		
		JLabel networkMediaConnectTypeLabel = new JLabel("Connect Type");
		GridBagConstraints gbcNetworkMediaConnectTypeLabel = new GridBagConstraints();
		gbcNetworkMediaConnectTypeLabel.anchor = GridBagConstraints.WEST;
		gbcNetworkMediaConnectTypeLabel.insets = new Insets(0, 0, 5, 5);
		gbcNetworkMediaConnectTypeLabel.gridx = 0;
		gbcNetworkMediaConnectTypeLabel.gridy = 9;
		adapterPanel.add(networkMediaConnectTypeLabel, gbcNetworkMediaConnectTypeLabel);
		
		networkMediaConnectTypeTextField = new JTextField();
		networkMediaConnectTypeTextField.setEditable(false);
		GridBagConstraints gbcNetworkMediaConnectTypeTextField = new GridBagConstraints();
		gbcNetworkMediaConnectTypeTextField.insets = new Insets(0, 0, 5, 0);
		gbcNetworkMediaConnectTypeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcNetworkMediaConnectTypeTextField.gridx = 1;
		gbcNetworkMediaConnectTypeTextField.gridy = 9;
		adapterPanel.add(networkMediaConnectTypeTextField, gbcNetworkMediaConnectTypeTextField);
		networkMediaConnectTypeTextField.setColumns(10);
		
		JLabel networkReceiveLinkSpeedLabel = new JLabel("Receive Speed");
		GridBagConstraints gbcNetworkReceiveLinkSpeedLabel = new GridBagConstraints();
		gbcNetworkReceiveLinkSpeedLabel.anchor = GridBagConstraints.WEST;
		gbcNetworkReceiveLinkSpeedLabel.insets = new Insets(0, 0, 5, 5);
		gbcNetworkReceiveLinkSpeedLabel.gridx = 0;
		gbcNetworkReceiveLinkSpeedLabel.gridy = 10;
		adapterPanel.add(networkReceiveLinkSpeedLabel, gbcNetworkReceiveLinkSpeedLabel);
		
		networkReceiveLinkSpeedTextField = new JTextField();
		networkReceiveLinkSpeedTextField.setEditable(false);
		GridBagConstraints gbcNetworkReceiveLinkSpeedTextField = new GridBagConstraints();
		gbcNetworkReceiveLinkSpeedTextField.insets = new Insets(0, 0, 5, 0);
		gbcNetworkReceiveLinkSpeedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcNetworkReceiveLinkSpeedTextField.gridx = 1;
		gbcNetworkReceiveLinkSpeedTextField.gridy = 10;
		adapterPanel.add(networkReceiveLinkSpeedTextField, gbcNetworkReceiveLinkSpeedTextField);
		networkReceiveLinkSpeedTextField.setColumns(10);
		
		JLabel networkTransmitLinkSpeedLabel = new JLabel("Transmit Speed");
		GridBagConstraints gbcNetworkTransmitLinkSpeedLabel = new GridBagConstraints();
		gbcNetworkTransmitLinkSpeedLabel.anchor = GridBagConstraints.WEST;
		gbcNetworkTransmitLinkSpeedLabel.insets = new Insets(0, 0, 5, 5);
		gbcNetworkTransmitLinkSpeedLabel.gridx = 0;
		gbcNetworkTransmitLinkSpeedLabel.gridy = 11;
		adapterPanel.add(networkTransmitLinkSpeedLabel, gbcNetworkTransmitLinkSpeedLabel);
		
		networkTransmitLinkSpeedTextField = new JTextField();
		networkTransmitLinkSpeedTextField.setEditable(false);
		GridBagConstraints gbcNetworkTransmitLinkSpeedTextField = new GridBagConstraints();
		gbcNetworkTransmitLinkSpeedTextField.insets = new Insets(0, 0, 5, 0);
		gbcNetworkTransmitLinkSpeedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcNetworkTransmitLinkSpeedTextField.gridx = 1;
		gbcNetworkTransmitLinkSpeedTextField.gridy = 11;
		adapterPanel.add(networkTransmitLinkSpeedTextField, gbcNetworkTransmitLinkSpeedTextField);
		networkTransmitLinkSpeedTextField.setColumns(10);
		
		JLabel networkDuplexityLabel = new JLabel("Full Duplex");
		GridBagConstraints gbcNetworkDuplexityLabel = new GridBagConstraints();
		gbcNetworkDuplexityLabel.anchor = GridBagConstraints.WEST;
		gbcNetworkDuplexityLabel.insets = new Insets(0, 0, 5, 5);
		gbcNetworkDuplexityLabel.gridx = 0;
		gbcNetworkDuplexityLabel.gridy = 12;
		adapterPanel.add(networkDuplexityLabel, gbcNetworkDuplexityLabel);
		
		networkDuplexityTextField = new JTextField();
		networkDuplexityTextField.setEditable(false);
		GridBagConstraints gbcNetworkDuplexityTextField = new GridBagConstraints();
		gbcNetworkDuplexityTextField.insets = new Insets(0, 0, 5, 0);
		gbcNetworkDuplexityTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcNetworkDuplexityTextField.gridx = 1;
		gbcNetworkDuplexityTextField.gridy = 12;
		adapterPanel.add(networkDuplexityTextField, gbcNetworkDuplexityTextField);
		networkDuplexityTextField.setColumns(10);
		
		JLabel networkVirtualityLabel = new JLabel("Virtual");
		GridBagConstraints gbcNetworkVirtualityLabel = new GridBagConstraints();
		gbcNetworkVirtualityLabel.anchor = GridBagConstraints.WEST;
		gbcNetworkVirtualityLabel.insets = new Insets(0, 0, 5, 5);
		gbcNetworkVirtualityLabel.gridx = 0;
		gbcNetworkVirtualityLabel.gridy = 13;
		adapterPanel.add(networkVirtualityLabel, gbcNetworkVirtualityLabel);
		
		networkVirtualityTextField = new JTextField();
		networkVirtualityTextField.setEditable(false);
		GridBagConstraints gbcNetworkVirtualityTextField = new GridBagConstraints();
		gbcNetworkVirtualityTextField.insets = new Insets(0, 0, 5, 0);
		gbcNetworkVirtualityTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcNetworkVirtualityTextField.gridx = 1;
		gbcNetworkVirtualityTextField.gridy = 13;
		adapterPanel.add(networkVirtualityTextField, gbcNetworkVirtualityTextField);
		networkVirtualityTextField.setColumns(10);
		
		JLabel networkStatusLabel = new JLabel("Status");
		GridBagConstraints gbcNetworkStatusLabel = new GridBagConstraints();
		gbcNetworkStatusLabel.anchor = GridBagConstraints.WEST;
		gbcNetworkStatusLabel.insets = new Insets(0, 0, 5, 5);
		gbcNetworkStatusLabel.gridx = 0;
		gbcNetworkStatusLabel.gridy = 14;
		adapterPanel.add(networkStatusLabel, gbcNetworkStatusLabel);
		
		networkStatusTextField = new JTextField();
		networkStatusTextField.setEditable(false);
		GridBagConstraints gbcNetworkStatusTextField = new GridBagConstraints();
		gbcNetworkStatusTextField.insets = new Insets(0, 0, 5, 0);
		gbcNetworkStatusTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcNetworkStatusTextField.gridx = 1;
		gbcNetworkStatusTextField.gridy = 14;
		adapterPanel.add(networkStatusTextField, gbcNetworkStatusTextField);
		networkStatusTextField.setColumns(10);
		
		JLabel networkPnPDeviceIdLabel = new JLabel("PnP DeviceID");
		GridBagConstraints gbcNetworkPnPDeviceIdLabel = new GridBagConstraints();
		gbcNetworkPnPDeviceIdLabel.anchor = GridBagConstraints.WEST;
		gbcNetworkPnPDeviceIdLabel.insets = new Insets(0, 0, 0, 5);
		gbcNetworkPnPDeviceIdLabel.gridx = 0;
		gbcNetworkPnPDeviceIdLabel.gridy = 15;
		adapterPanel.add(networkPnPDeviceIdLabel, gbcNetworkPnPDeviceIdLabel);
		
		networkPnPDeviceIdTextField = new JTextField();
		networkPnPDeviceIdTextField.setEditable(false);
		GridBagConstraints gbcNetworkPnPDeviceIdTextField = new GridBagConstraints();
		gbcNetworkPnPDeviceIdTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcNetworkPnPDeviceIdTextField.gridx = 1;
		gbcNetworkPnPDeviceIdTextField.gridy = 15;
		adapterPanel.add(networkPnPDeviceIdTextField, gbcNetworkPnPDeviceIdTextField);
		networkPnPDeviceIdTextField.setColumns(10);
	}
	
	private void setAdapterPropertyTabbedPane() {
		
		JTabbedPane adapterPropertyTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(adapterPropertyTabbedPane);
		
		JPanel adapterIpPanel = new JPanel();
		adapterIpPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "IP Address", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		adapterPropertyTabbedPane.addTab("Adapter IP", null, adapterIpPanel, null);
		adapterIpPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane adapterIpEditorScrollPane = new JScrollPane();
		adapterIpPanel.add(adapterIpEditorScrollPane);
		
		adapterIpEditorPane = new JEditorPane();
		adapterIpEditorScrollPane.setViewportView(adapterIpEditorPane);
		adapterIpEditorPane.setEditable(false);
		adapterIpEditorPane.setContentType("text/html");
		
		JPanel adapterDnsPanel = new JPanel();
		adapterDnsPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "DNS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		adapterPropertyTabbedPane.addTab("Adapter DNS", null, adapterDnsPanel, null);
		adapterDnsPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane adapterDnsEditorScrollPane = new JScrollPane();
		adapterDnsPanel.add(adapterDnsEditorScrollPane);
		
		adapterDnsEditorPane = new JEditorPane();
		adapterDnsEditorScrollPane.setViewportView(adapterDnsEditorPane);
		adapterDnsEditorPane.setEditable(false);
		adapterDnsEditorPane.setContentType("text/html");
		
		JPanel netConnectionProfilePanel = new JPanel();
		netConnectionProfilePanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Connection Profile", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		adapterPropertyTabbedPane.addTab("Connection Profile", null, netConnectionProfilePanel, null);
		netConnectionProfilePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane adapterConnectionProfileEditorScrollPane = new JScrollPane();
		netConnectionProfilePanel.add(adapterConnectionProfileEditorScrollPane);
		
		adapterConnectionProfileEditorPane = new JEditorPane();
		adapterConnectionProfileEditorScrollPane.setViewportView(adapterConnectionProfileEditorPane);
		adapterConnectionProfileEditorPane.setEditable(false);
		adapterConnectionProfileEditorPane.setContentType("text/html");
	}

	private void setWorker() {

		List<JTextField> adapterFields = List.of(networkDeviceIdTextField, networkNameTextField,
		networkDriverVersionTextField, networkDriverDateTextField, networkTypeTextField,
		networkLinkLayerAddressTextField, networkLinkSpeedTextField, networkMediaConnectStateTextField,
		networkMediaConnectTypeTextField, networkReceiveLinkSpeedTextField, networkTransmitLinkSpeedTextField,
		networkDuplexityTextField, networkVirtualityTextField, networkStatusTextField, networkPnPDeviceIdTextField);

		List<JEditorPane> editorPanes = List.of(adapterIpEditorPane, adapterDnsEditorPane, adapterConnectionProfileEditorPane);

		new WMINetworkPanelWorker(networkInterfaceIdComboBox, adapterFields, editorPanes).execute();
	}

}
