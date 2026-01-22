package io.github.eggy03.ui.common.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import io.github.eggy03.ui.common.constant.ThemeColorFilterConstant;
import io.github.eggy03.ui.common.themes.DarkTheme;
import io.github.eggy03.ui.common.themes.LightTheme;
import io.github.eggy03.ui.common.utilities.ThemeManager;
import net.miginfocom.swing.MigLayout;

import java.awt.Toolkit;

public class ThemeManagerUI extends JFrame {

	/**
	 * Create the frame.
	 */
	public ThemeManagerUI() {

		setTitle("Theme");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 100);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ThemeManagerUI.class.getResource("/icons/icon_main.png")));
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Theme Manager", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setLayout(new MigLayout("", "[grow][grow]", "[]"));
		
		
		contentPane.add(createDarkThemeButton(), "cell 0 0,growx");
		contentPane.add(createLightThemeButton(), "cell 1 0,growx");
		
		setContentPane(contentPane);

	}
	
	private JButton createDarkThemeButton() {
		JButton darkThemeButton = new JButton("Dark Theme");
		darkThemeButton.addActionListener(clickEvent -> {
			ThemeManager.registerTheme(DarkTheme.class.getCanonicalName());
			ThemeManager.registerColorFilter(ThemeColorFilterConstant.NONE.getHexValue());
			new InformationUI("Theme Applied", "Changes will be applied upon restart").setVisible(true);
		});
		
		return darkThemeButton;
	}
	
	private JButton createLightThemeButton() {
		JButton lightThemeButton = new JButton("Light Theme");
		lightThemeButton.addActionListener(clickEvent -> {
			ThemeManager.registerTheme(LightTheme.class.getCanonicalName());
			ThemeManager.registerColorFilter(ThemeColorFilterConstant.OLIVE_GREEN.getHexValue());
			new InformationUI("Theme Applied", "Changes will be applied upon restart").setVisible(true);
		});
		
		return lightThemeButton;
	}

}
