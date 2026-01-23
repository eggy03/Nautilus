package io.github.eggy03.ui.common.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import io.github.eggy03.ui.common.constant.ThemeColorFilterConstant;
import io.github.eggy03.ui.common.themes.DarkTheme;
import io.github.eggy03.ui.common.themes.DarkYellowTheme;
import io.github.eggy03.ui.common.themes.LightTheme;
import io.github.eggy03.ui.common.themes.PinkTheme;
import io.github.eggy03.ui.common.utilities.ThemeManager;
import net.miginfocom.swing.MigLayout;

import java.awt.Toolkit;

public class ThemeManagerUI extends JFrame {

	private static final String INFO_HEADING = "Theme Applied";
	private static final String INFO_TEXT = "Changes will be applied upon restart";

	/**
	 * Create the frame.
	 */
	public ThemeManagerUI() {

		setTitle("Theme");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ThemeManagerUI.class.getResource("/icons/icon_main.png")));
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Theme Manager", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setLayout(new MigLayout("", "[grow][grow][grow]", "[]"));
		
		
		contentPane.add(createDarkThemeButton(), "cell 0 0,growx");
		contentPane.add(createLightThemeButton(), "cell 1 0,growx");
		contentPane.add(createPinkThemeButton(), "cell 2 0,growx");
		contentPane.add(createDarkYellowThemeButton(), "cell 3 0,growx");
		
		setContentPane(contentPane);
		pack();
	}

	private JButton createDarkThemeButton() {
		JButton darkThemeButton = new JButton("Dark");
		darkThemeButton.addActionListener(clickEvent -> {
			ThemeManager.registerTheme(DarkTheme.class.getCanonicalName());
			ThemeManager.registerColorFilter(ThemeColorFilterConstant.NONE.getHexValue());
			new InformationUI(INFO_HEADING, INFO_TEXT).setVisible(true);
		});
		
		return darkThemeButton;
	}
	
	private JButton createLightThemeButton() {
		JButton lightThemeButton = new JButton("Light");
		lightThemeButton.addActionListener(clickEvent -> {
			ThemeManager.registerTheme(LightTheme.class.getCanonicalName());
			ThemeManager.registerColorFilter(ThemeColorFilterConstant.OLIVE_GREEN.getHexValue());
			new InformationUI(INFO_HEADING, INFO_TEXT).setVisible(true);
		});
		
		return lightThemeButton;
	}

	private JButton createPinkThemeButton() {
		JButton pinkThemeButton = new JButton("Pink");
		pinkThemeButton.addActionListener(clickEvent -> {
			ThemeManager.registerTheme(PinkTheme.class.getCanonicalName());
			ThemeManager.registerColorFilter(ThemeColorFilterConstant.PINK.getHexValue());
			new InformationUI(INFO_HEADING, INFO_TEXT).setVisible(true);
		});

		return pinkThemeButton;
	}

	private JButton createDarkYellowThemeButton() {
		JButton darkYellowThemeButton = new JButton("Dark Yellow");
		darkYellowThemeButton.addActionListener(clickEvent -> {
			ThemeManager.registerTheme(DarkYellowTheme.class.getCanonicalName());
			ThemeManager.registerColorFilter(ThemeColorFilterConstant.YELLOW.getHexValue());
			new InformationUI(INFO_HEADING, INFO_TEXT).setVisible(true);
		});

		return darkYellowThemeButton;
	}

}
