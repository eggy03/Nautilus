package io.github.eggy03.ui.primary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import com.formdev.flatlaf.FlatLaf;

import io.github.eggy03.ui.primary.panels.CpuPanel;
import io.github.eggy03.ui.themes.LightTheme;
import io.github.eggy03.ui.utilities.UIManagerConfigurations;



public class ApplicationUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlatLaf.registerCustomDefaultsSource("themes"); // for maven build, this points towards src/main/resources/themes
					LightTheme.setup(); // TODO remove hardcoding
					UIManagerConfigurations.enableRoundComponents();
					UIManagerConfigurations.enableTabSeparators(true);
					
					ApplicationUI frame = new ApplicationUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ApplicationUI() {
		setTitle("FerrumX-Windows");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 461);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane(contentPane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		setContentPane(scrollPane);
		
		setupMenu(contentPane);
		setTabbedPane(contentPane);
	}
	
	private void setupMenu(JPanel contentPane) {
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		menuBar.setFont(new Font("Ubuntu", Font.PLAIN, 21));
		
		JMenu mnNewMenu = new JMenu("PlaceHolderMenu1");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("PlaceholderMenu2");
		menuBar.add(mnNewMenu_1);
	}
	
	private void setTabbedPane(JPanel contentPane) {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("CPU", null, new CpuPanel().getPanel(), null);
	}

}
