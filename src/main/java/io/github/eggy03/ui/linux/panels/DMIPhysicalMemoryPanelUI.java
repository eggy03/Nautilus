package io.github.eggy03.ui.linux.panels;

import net.miginfocom.swing.MigLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;

public class DMIPhysicalMemoryPanelUI extends JPanel {

    private JComboBox<Integer> memoryModuleNumberComboBox;
    private JTextField setTextField;
    private JTextField assetTagTextField;
    private JTextField serialNumberTextField;
    private JTextField partNumberTextField;
    private JTextField firmwareVersionTextField;
    private JTextField locatorTextField;
    private JTextField bankLocatorTextField;
    private JTextField formFactorTextField;
    private JTextField typeTextField;
    private JTextField typeDetailTextField;
    private JTextField rankLabelTextField;
    private JTextField sizeTextField;
    private JTextField dataWidthTextField;
    private JTextField totalWidthTextField;
    private JTextField volatileSizeTextField;
    private JTextField nonVolatileSizeTextField;
    private JTextField cacheSizeTextField;
    private JTextField logicalSizeTextField;
    private JTextField factorySpeedTextField;
    private JTextField configuredSpeedTextField;
    private JTextField minimumVoltageTextField;
    private JTextField maximumVoltageTextField;
    private JTextField configuredVoltageTextField;
    private JTextField manufacturerTextField;
    private JTextField moduleManufacturerIdTextField;
    private JTextField moduleProductIdTextField;
    private JTextField mscManufacturerIdTextField;
    private JTextField mscProductIdTextField;
    private JTextField memoryTechnologyTextField;
    private JTextField memoryOperatingModeCapabilityTextField;

    /**
     * Create the panel.
     */
    public DMIPhysicalMemoryPanelUI() {
        setUI();
        setWorker();
    }

    public JPanel getPanel() {
        return this;
    }

    private void setUI() {

        setLayout(new GridLayout(1, 0, 0, 0));

        // add panel
        JPanel memoryPanel = new JPanel();
        memoryPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Memory", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        // add scroll-pane to the main panel
        JScrollPane memoryScrollPane = new JScrollPane();
        memoryScrollPane.setViewportView(memoryPanel);
        memoryPanel.setLayout(new GridLayout(5, 0, 0, 0));

        add(memoryScrollPane);

        // add sub-panels
        memoryPanel.add(createHandlePanel());
        memoryPanel.add(createCharacteristicsPanel());
        memoryPanel.add(createSizePanel());
        memoryPanel.add(createSpeedAndVoltagePanel());
        memoryPanel.add(createManufacturerPanel());

    }

    private JPanel createHandlePanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Handles", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));

        JLabel memoryModuleNumberLabel = new JLabel("Memory #");
        panel.add(memoryModuleNumberLabel, "cell 0 0,alignx leading");

        memoryModuleNumberComboBox = new JComboBox<>();
        panel.add(memoryModuleNumberComboBox, "cell 1 0,growx");

        JLabel setLabel = new JLabel("Set");
        panel.add(setLabel, "cell 0 1,alignx leading");

        setTextField = new JTextField();
        setTextField.setEditable(false);
        panel.add(setTextField, "cell 1 1,growx");
        setTextField.setColumns(10);

        JLabel assetTagLabel = new JLabel("Asset Tag");
        panel.add(assetTagLabel, "cell 0 2,alignx leading");

        assetTagTextField = new JTextField();
        assetTagTextField.setEditable(false);
        panel.add(assetTagTextField, "cell 1 2,growx");
        assetTagTextField.setColumns(10);

        JLabel serialNumberLabel = new JLabel("Serial Number");
        panel.add(serialNumberLabel, "cell 0 3,alignx leading");

        serialNumberTextField = new JTextField();
        serialNumberTextField.setEditable(false);
        panel.add(serialNumberTextField, "cell 1 3,growx");
        serialNumberTextField.setColumns(10);

        JLabel partNumberLabel = new JLabel("Part Number");
        panel.add(partNumberLabel, "cell 0 4,alignx leading");

        partNumberTextField = new JTextField();
        partNumberTextField.setEditable(false);
        panel.add(partNumberTextField, "cell 1 4,growx");
        partNumberTextField.setColumns(10);

        JLabel firmwareVersionLabel = new JLabel("Firmware Version");
        panel.add(firmwareVersionLabel, "cell 0 5,alignx leading");

        firmwareVersionTextField = new JTextField();
        firmwareVersionTextField.setEditable(false);
        panel.add(firmwareVersionTextField, "cell 1 5,growx");
        firmwareVersionTextField.setColumns(10);

        return panel;
    }

    private JPanel createCharacteristicsPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Characteristics", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));

        JLabel locatorLabel = new JLabel("Locator");
        panel.add(locatorLabel, "cell 0 0,alignx leading");

        locatorTextField = new JTextField();
        locatorTextField.setEditable(false);
        panel.add(locatorTextField, "cell 1 0,growx");
        locatorTextField.setColumns(10);

        JLabel bankLocatorLabel = new JLabel("Bank Locator");
        panel.add(bankLocatorLabel, "cell 0 1,alignx leading");

        bankLocatorTextField = new JTextField();
        bankLocatorTextField.setEditable(false);
        panel.add(bankLocatorTextField, "cell 1 1,growx");
        bankLocatorTextField.setColumns(10);

        JLabel formFactorLabel = new JLabel("Form Factor");
        panel.add(formFactorLabel, "cell 0 2,alignx leading");

        formFactorTextField = new JTextField();
        formFactorTextField.setEditable(false);
        panel.add(formFactorTextField, "cell 1 2,growx");
        formFactorTextField.setColumns(10);

        JLabel typeLabel = new JLabel("Type");
        panel.add(typeLabel, "cell 0 3,alignx leading");

        typeTextField = new JTextField();
        typeTextField.setEditable(false);
        panel.add(typeTextField, "cell 1 3,growx");
        typeTextField.setColumns(10);

        JLabel typeDetailLabel = new JLabel("Type Detail");
        panel.add(typeDetailLabel, "cell 0 4,alignx leading");

        typeDetailTextField = new JTextField();
        typeDetailTextField.setEditable(false);
        panel.add(typeDetailTextField, "cell 1 4,growx");
        typeDetailTextField.setColumns(10);

        JLabel rankLabel = new JLabel("Rank");
        panel.add(rankLabel, "cell 0 5,alignx leading");

        rankLabelTextField = new JTextField();
        rankLabelTextField.setEditable(false);
        panel.add(rankLabelTextField, "cell 1 5,growx");
        rankLabelTextField.setColumns(10);

        return panel;

    }

    private JPanel createSizePanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Size", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setLayout(new MigLayout("", "[][grow]", "[][][][][][][]"));

        JLabel sizeLabel = new JLabel("Size");
        panel.add(sizeLabel, "cell 0 0,alignx leading");

        sizeTextField = new JTextField();
        sizeTextField.setEditable(false);
        panel.add(sizeTextField, "cell 1 0,growx");
        sizeTextField.setColumns(10);

        JLabel dataWidthLabel = new JLabel("Data Width");
        panel.add(dataWidthLabel, "cell 0 1,alignx leading");

        dataWidthTextField = new JTextField();
        dataWidthTextField.setEditable(false);
        panel.add(dataWidthTextField, "cell 1 1,growx");
        dataWidthTextField.setColumns(10);

        JLabel totalWidthLabel = new JLabel("Total Width");
        panel.add(totalWidthLabel, "cell 0 2,alignx leading");

        totalWidthTextField = new JTextField();
        totalWidthTextField.setEditable(false);
        panel.add(totalWidthTextField, "cell 1 2,growx");
        totalWidthTextField.setColumns(10);

        JLabel volatileSizeLabel = new JLabel("Volatile Size");
        panel.add(volatileSizeLabel, "cell 0 3,alignx leading");

        volatileSizeTextField = new JTextField();
        volatileSizeTextField.setEditable(false);
        panel.add(volatileSizeTextField, "cell 1 3,growx");
        volatileSizeTextField.setColumns(10);

        JLabel nonVolatileSizeLabel = new JLabel("Non-Volatile Size");
        panel.add(nonVolatileSizeLabel, "cell 0 4,alignx leading");

        nonVolatileSizeTextField = new JTextField();
        nonVolatileSizeTextField.setEditable(false);
        panel.add(nonVolatileSizeTextField, "cell 1 4,growx");
        nonVolatileSizeTextField.setColumns(10);

        JLabel cacheSizeLabel = new JLabel("Cache Size");
        panel.add(cacheSizeLabel, "cell 0 5,alignx leading");

        cacheSizeTextField = new JTextField();
        cacheSizeTextField.setEditable(false);
        panel.add(cacheSizeTextField, "cell 1 5,growx");
        cacheSizeTextField.setColumns(10);

        JLabel logicalSizeLabel = new JLabel("Logical Size");
        panel.add(logicalSizeLabel, "cell 0 6,alignx leading");
        logicalSizeTextField = new JTextField();

        logicalSizeTextField.setEditable(false);
        panel.add(logicalSizeTextField, "cell 1 6,growx");
        logicalSizeTextField.setColumns(10);
        return panel;

    }

    private JPanel createSpeedAndVoltagePanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Speed And Voltage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));

        JLabel factorySpeedLabel = new JLabel("Factory Speed");
        panel.add(factorySpeedLabel, "cell 0 0,alignx leading");

        factorySpeedTextField = new JTextField();
        factorySpeedTextField.setEditable(false);
        panel.add(factorySpeedTextField, "cell 1 0,growx");
        factorySpeedTextField.setColumns(10);

        JLabel configuredSpeedLabel = new JLabel("Configured Speed");
        panel.add(configuredSpeedLabel, "cell 0 1,alignx leading");

        configuredSpeedTextField = new JTextField();
        configuredSpeedTextField.setEditable(false);
        panel.add(configuredSpeedTextField, "cell 1 1,growx");
        configuredSpeedTextField.setColumns(10);

        JLabel minimumVoltageLabel = new JLabel("Minimum Volage");
        panel.add(minimumVoltageLabel, "cell 0 2,alignx leading");

        minimumVoltageTextField = new JTextField();
        minimumVoltageTextField.setEditable(false);
        panel.add(minimumVoltageTextField, "cell 1 2,growx");
        minimumVoltageTextField.setColumns(10);

        JLabel maximumVoltageLabel = new JLabel("Maximum Voltage");
        panel.add(maximumVoltageLabel, "cell 0 3,alignx leading");

        maximumVoltageTextField = new JTextField();
        maximumVoltageTextField.setEditable(false);
        panel.add(maximumVoltageTextField, "cell 1 3,growx");
        maximumVoltageTextField.setColumns(10);

        JLabel configuredVoltageLabel = new JLabel("Configured Voltage");
        panel.add(configuredVoltageLabel, "cell 0 4,alignx leading");

        configuredVoltageTextField = new JTextField();
        configuredVoltageTextField.setEditable(false);
        panel.add(configuredVoltageTextField, "cell 1 4,growx");
        configuredVoltageTextField.setColumns(10);

        return panel;

    }

    private JPanel createManufacturerPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Manufacturer And Technology", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setLayout(new MigLayout("", "[][grow]", "[][][][][][][]"));

        JLabel manufacturerLabel = new JLabel("Manufacturer");
        panel.add(manufacturerLabel, "cell 0 0,alignx leading");

        manufacturerTextField = new JTextField();
        manufacturerTextField.setEditable(false);
        panel.add(manufacturerTextField, "cell 1 0,growx");
        manufacturerTextField.setColumns(10);

        JLabel moduleManufacturerIdLabel = new JLabel("Module Manufacturer ID");
        panel.add(moduleManufacturerIdLabel, "cell 0 1,alignx leading");

        moduleManufacturerIdTextField = new JTextField();
        moduleManufacturerIdTextField.setEditable(false);
        panel.add(moduleManufacturerIdTextField, "cell 1 1,growx");
        moduleManufacturerIdTextField.setColumns(10);

        JLabel moduleProductIdLabel = new JLabel("Module Product ID");
        panel.add(moduleProductIdLabel, "cell 0 2,alignx leading");

        moduleProductIdTextField = new JTextField();
        moduleProductIdTextField.setEditable(false);
        panel.add(moduleProductIdTextField, "cell 1 2,growx");
        moduleProductIdTextField.setColumns(10);

        JLabel mscManufacturerIdLabel = new JLabel("MSC Manufacturer ID");
        mscManufacturerIdLabel.setToolTipText("Memory Sub-System Controller Manufacturer ID");
        panel.add(mscManufacturerIdLabel, "cell 0 3,alignx leading");

        mscManufacturerIdTextField = new JTextField();
        mscManufacturerIdTextField.setEditable(false);
        panel.add(mscManufacturerIdTextField, "cell 1 3,growx");
        mscManufacturerIdTextField.setColumns(10);

        JLabel mscProductIdLabel = new JLabel("MSC Product ID");
        mscProductIdLabel.setToolTipText("Memory Sub-System Controller Product ID");
        panel.add(mscProductIdLabel, "cell 0 4,alignx leading");

        mscProductIdTextField = new JTextField();
        mscProductIdTextField.setEditable(false);
        panel.add(mscProductIdTextField, "cell 1 4,growx");
        mscProductIdTextField.setColumns(10);

        JLabel memoryTechnologyLabel = new JLabel("Memory Technology");
        panel.add(memoryTechnologyLabel, "cell 0 5,alignx leading");

        memoryTechnologyTextField = new JTextField();
        memoryTechnologyTextField.setEditable(false);
        panel.add(memoryTechnologyTextField, "cell 1 5,growx");
        memoryTechnologyTextField.setColumns(10);

        JLabel memoryOperatingModeCapabilityLabel = new JLabel("Memory Operating Mode Capability");
        panel.add(memoryOperatingModeCapabilityLabel, "cell 0 6,alignx leading");

        memoryOperatingModeCapabilityTextField = new JTextField();
        memoryOperatingModeCapabilityTextField.setEditable(false);
        panel.add(memoryOperatingModeCapabilityTextField, "cell 1 6,growx");
        memoryOperatingModeCapabilityTextField.setColumns(10);

        return panel;
    }


    private void setWorker() {
// TODO
    }

}
