package io.github.eggy03.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.Serial;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.formdev.flatlaf.FlatLaf;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import io.github.eggy03.ui.windows.panels.CpuPanelUI;
import io.github.eggy03.ui.windows.panels.MemoryPanelUI;
import io.github.eggy03.ui.themes.DarkTheme;
import io.github.eggy03.ui.utilities.UIManagerConfigurations;



public class ApplicationUI extends JFrame {

	@Serial
    private static final long serialVersionUID = 1L;

    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
                FlatLaf.registerCustomDefaultsSource("themes"); // for maven build, this points towards src/main/resources/themes
                DarkTheme.setup(); // TODO remove hardcoding
                UIManagerConfigurations.enableRoundComponents();
                UIManagerConfigurations.enableTabSeparators(true);

                ApplicationUI frame = new ApplicationUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	}

	/**
	 * Create the frame.
	 */
	public ApplicationUI() {
		setTitle("FerrumX-Windows");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ApplicationUI.class.getResource("/icons/icon_main.png")));
        JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane(contentPane);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setContentPane(scrollPane);
		
		setupMenu(contentPane);
		setTabbedPane(contentPane);
	}
	
	private void setupMenu(JPanel contentPane) {
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		menuBar.setFont(new Font("Ubuntu", Font.PLAIN, 21));
		
		JMenu appearanceMenu = new JMenu("Appearance");
		menuBar.add(appearanceMenu);
		
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
	}
	
	private void setTabbedPane(JPanel contentPane) {
		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("CPU", new FlatSVGIcon(ApplicationUI.class.getResource("/icons/tab_icons_small/CPU.svg")), new CpuPanelUI().getPanel(), null);
		tabbedPane.addTab("Memory", new FlatSVGIcon(ApplicationUI.class.getResource("/icons/tab_icons_small/RAM.svg")), new MemoryPanelUI().getPanel(), null);
	}

}
