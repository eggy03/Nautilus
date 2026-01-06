package io.github.eggy03.ui.common.ui;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import io.github.eggy03.ui.common.constant.VersionAndOtherInfo;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Objects;

public class AboutUI extends JFrame {

	private final JPanel contentPane;
	
	private static final String VERSION_AND_AUTHOR =
			"Version: "+ VersionAndOtherInfo.APP_VERSION
			+System.lineSeparator()
			+"FerrumX Version: "+VersionAndOtherInfo.FERRUMX_WINDOWS_VERSION
			+System.lineSeparator()
			+"Developed By: Egg-03";

	private static final String ATTRIBUTION = """	
			<b>Open-Source Licenses</b><br>
			This application includes third-party open-source software.
			<ul>
			  <li>FerrumX Windows</li>
			  <li>Apache Commons Lang</li>
			  <li>Apache Commons IO</li>
			  <li>FlatLaf</li>
			  <li>JSVG</li>
			  <li>SLF4J</li>
			  <li>Logback</li>
			  <li>Project Lombok</li>
			</ul>
			Full license texts are included with this distribution and are also
			available online on the project's GitHub page.<br><br>
			
			<b>Source Code</b><br>
			The source code for this application is available on GitHub.<br><br>
			
			<b>Icons</b><br>
			This application uses icons from Google Material Design Icons,
			licensed under the Apache License, Version 2.0.<br><br>
			
			<b>Security Notice</b><br>
			This application binary is currently <b>unsigned</b>.
			For your safety, download this software only from official sources,
			such as the project's GitHub repository.
			
			""";

	public AboutUI() {
		setTitle("About Nautilus");
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AboutUI.class.getResource("/icons/icon_main.png")));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setVersionPanel();
		setAttributionPanel();
		setButtonsPanel();
	}
	
	private void setVersionPanel() {
		
		JPanel versionPanel = new JPanel();
		versionPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Version Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(versionPanel, BorderLayout.NORTH);
		
		GridBagLayout gblVersionPanel = new GridBagLayout();
		gblVersionPanel.columnWidths = new int[]{0, 0, 0};
		gblVersionPanel.rowHeights = new int[]{0, 0};
		gblVersionPanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gblVersionPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		versionPanel.setLayout(gblVersionPanel);
		
		JTextArea versionTextArea = new JTextArea();
		versionTextArea.setText(VERSION_AND_AUTHOR);
		versionTextArea.setEditable(false);
		
		GridBagConstraints gbcVersionTextArea = new GridBagConstraints();
		gbcVersionTextArea.insets = new Insets(0, 0, 0, 5);
		gbcVersionTextArea.fill = GridBagConstraints.BOTH;
		gbcVersionTextArea.gridx = 0;
		gbcVersionTextArea.gridy = 0;
		versionPanel.add(versionTextArea, gbcVersionTextArea);
		versionTextArea.setColumns(10);
		
		JLabel appLogoLabel = new JLabel("");
		appLogoLabel.setIcon(new FlatSVGIcon(AboutUI.class.getResource("/icons/icon_main.svg")));
		
		GridBagConstraints gbcAppLogoLabel = new GridBagConstraints();
		gbcAppLogoLabel.gridx = 1;
		gbcAppLogoLabel.gridy = 0;
		versionPanel.add(appLogoLabel, gbcAppLogoLabel);
	}
	
	private void setAttributionPanel() {
		
		JPanel attributionPanel = new JPanel();
		attributionPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Attribution", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(attributionPanel, BorderLayout.CENTER);
		attributionPanel.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane attributionEditorScrollPane = new JScrollPane();
        attributionPanel.add(attributionEditorScrollPane);

		JEditorPane attributionEditorPane = new JEditorPane();
        attributionEditorPane.setEditable(false);
        attributionEditorPane.setContentType("text/html");
		attributionEditorPane.setText(ATTRIBUTION);
        attributionEditorScrollPane.setViewportView(attributionEditorPane);
    }
	
	private void setButtonsPanel() {
		
		JPanel buttonsPanel = new JPanel();
		contentPane.add(buttonsPanel, BorderLayout.SOUTH);
		buttonsPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton githubPageButton = new JButton("Visit Nautilus GitHub Page");
		githubPageButton.addActionListener(action-> {
            try {
                Desktop.getDesktop().browse(URI.create(VersionAndOtherInfo.APP_GITHUB_PAGE));
            } catch (IOException | UnsupportedOperationException e) {
                new ExceptionUI("Could not open browser", e.getMessage());
            }
        });
		buttonsPanel.add(githubPageButton);

		JButton privacyPolicyButton = new JButton("Privacy Policy");
		privacyPolicyButton.addActionListener(action-> {
			InputStream stream = Objects.requireNonNull(AboutUI.class.getResourceAsStream("/PrivacyPolicy.txt"), "Privacy Policy Stream must not be null");
			new TextViewUI("Privacy Policy", stream).setVisible(true);
		});
		buttonsPanel.add(privacyPolicyButton);
		
		JButton openSourceLicenseButton = new JButton("See Open Source Licenses");
		openSourceLicenseButton.addActionListener(action-> {
			InputStream stream = Objects.requireNonNull(AboutUI.class.getResourceAsStream("/OpenSourceLicenses.txt"), "License Stream must not be null");
			new TextViewUI("Third Party Software Licenses", stream).setVisible(true);
        });
		buttonsPanel.add(openSourceLicenseButton);
	}

}
