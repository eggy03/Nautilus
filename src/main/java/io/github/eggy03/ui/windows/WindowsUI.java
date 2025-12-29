package io.github.eggy03.ui.windows;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import io.github.eggy03.ui.windows.panels.WinProcessorPanelUI;
import io.github.eggy03.ui.windows.panels.WinVideoControllerPanelUI;
import io.github.eggy03.ui.windows.panels.WinMainboardPanelUI;
import io.github.eggy03.ui.windows.panels.WinNetworkPanelUI;
import io.github.eggy03.ui.windows.panels.WinPhysicalMemoryPanelUI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;

public class WindowsUI extends JFrame {

	/**
	 * Create the frame.
	 */
	public WindowsUI() {

		setTitle("FerrumX-Windows");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(0, 0, 900, 650);
		setIconImage(Toolkit.getDefaultToolkit().getImage(WindowsUI.class.getResource("/icons/icon_main.png")));
        
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setupMenu(contentPane);
		setTabbedPane(contentPane);
	}
	
	private void setupMenu(JPanel contentPane) {
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		menuBar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JMenu appearanceMenu = new JMenu("Appearance");
		menuBar.add(appearanceMenu);
		
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
	}
	
	private void setTabbedPane(JPanel contentPane) {
		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("CPU", new FlatSVGIcon(WindowsUI.class.getResource("/icons/tab_icons_small/CPU.svg")), new WinProcessorPanelUI().getPanel(), null);
		tabbedPane.addTab("Memory", new FlatSVGIcon(WindowsUI.class.getResource("/icons/tab_icons_small/RAM.svg")), new WinPhysicalMemoryPanelUI().getPanel(), null);
		tabbedPane.addTab("Mainboard", new FlatSVGIcon(WindowsUI.class.getResource("/icons/tab_icons_small/MainBoard.svg")), new WinMainboardPanelUI().getPanel(), null);
		tabbedPane.addTab("GPU", new FlatSVGIcon(WindowsUI.class.getResource("/icons/tab_icons_small/GPU.svg")), new WinVideoControllerPanelUI().getPanel(), null);
		tabbedPane.addTab("Network", new FlatSVGIcon(WindowsUI.class.getResource("/icons/tab_icons_small/Network.svg")), new WinNetworkPanelUI().getPanel(), null);
	}

}
