package io.github.eggy03.ui.common.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import io.github.eggy03.ui.common.constant.ThemeColorFilterConstant;
import io.github.eggy03.ui.common.themes.DarkGreenTheme;
import io.github.eggy03.ui.common.themes.DarkPinkTheme;
import io.github.eggy03.ui.common.themes.LightYellowTheme;
import io.github.eggy03.ui.common.themes.StandardDarkTheme;
import io.github.eggy03.ui.common.themes.DarkYellowTheme;
import io.github.eggy03.ui.common.themes.LightGreenTheme;
import io.github.eggy03.ui.common.themes.LightPinkTheme;
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
		contentPane.setLayout(new MigLayout("", "[grow][grow]", "[][][][]"));

		contentPane.add(createLightGreenThemeButton(), "cell 0 0,growx");
		contentPane.add(createDarkGreenThemeButton(), "cell 1 0,growx");
		contentPane.add(createLightPinkThemeButton(), "cell 0 1,growx");
		contentPane.add(createDarkPinkThemeButton(), "cell 1 1,growx");
		contentPane.add(createLightYellowThemeButton(), "cell 0 2,growx");
		contentPane.add(createDarkYellowThemeButton(), "cell 1 2,growx");
		contentPane.add(createStandardDarkThemeButton(), "cell 0 3 4 1,growx");
		
		setContentPane(contentPane);
		pack();
	}

	private JButton createStandardDarkThemeButton() {
		JButton darkThemeButton = new JButton("Default Dark");
		darkThemeButton.addActionListener(clickEvent -> {
			ThemeManager.registerTheme(StandardDarkTheme.class.getCanonicalName());
			ThemeManager.registerColorFilter(ThemeColorFilterConstant.NONE.getHexValue());
			new InformationUI(INFO_HEADING, INFO_TEXT).setVisible(true);
		});
		
		return darkThemeButton;
	}
	
	private JButton createLightGreenThemeButton() {
		JButton lightGreenThemeButton = new JButton("Light Green");
		lightGreenThemeButton.addActionListener(clickEvent -> {
			ThemeManager.registerTheme(LightGreenTheme.class.getCanonicalName());
			ThemeManager.registerColorFilter(ThemeColorFilterConstant.OLIVE_GREEN.getHexValue());
			new InformationUI(INFO_HEADING, INFO_TEXT).setVisible(true);
		});
		
		return lightGreenThemeButton;
	}

	private JButton createDarkGreenThemeButton() {
		JButton darkGreenThemeButton = new JButton("Dark Green");
		darkGreenThemeButton.addActionListener(clickEvent -> {
			ThemeManager.registerTheme(DarkGreenTheme.class.getCanonicalName());
			ThemeManager.registerColorFilter(ThemeColorFilterConstant.NONE.getHexValue());
			new InformationUI(INFO_HEADING, INFO_TEXT).setVisible(true);
		});

		return darkGreenThemeButton;
	}

	private JButton createLightPinkThemeButton() {
		JButton lightPinkThemeButton = new JButton("Light Pink");
		lightPinkThemeButton.addActionListener(clickEvent -> {
			ThemeManager.registerTheme(LightPinkTheme.class.getCanonicalName());
			ThemeManager.registerColorFilter(ThemeColorFilterConstant.PINK.getHexValue());
			new InformationUI(INFO_HEADING, INFO_TEXT).setVisible(true);
		});

		return lightPinkThemeButton;
	}

	private JButton createDarkPinkThemeButton() {
		JButton darkPinkThemeButton = new JButton("Dark Pink");
		darkPinkThemeButton.addActionListener(clickEvent -> {
			ThemeManager.registerTheme(DarkPinkTheme.class.getCanonicalName());
			ThemeManager.registerColorFilter(ThemeColorFilterConstant.PINK.getHexValue());
			new InformationUI(INFO_HEADING, INFO_TEXT).setVisible(true);
		});

		return darkPinkThemeButton;
	}

	private JButton createLightYellowThemeButton() {
		JButton lightYellowThemeButton = new JButton("Light Yellow");
		lightYellowThemeButton.addActionListener(clickEvent -> {
			ThemeManager.registerTheme(LightYellowTheme.class.getCanonicalName());
			ThemeManager.registerColorFilter(ThemeColorFilterConstant.DARK_YELLOW.getHexValue());
			new InformationUI(INFO_HEADING, INFO_TEXT).setVisible(true);
		});

		return lightYellowThemeButton;
	}

	private JButton createDarkYellowThemeButton() {
		JButton darkYellowThemeButton = new JButton("Dark Yellow");
		darkYellowThemeButton.addActionListener(clickEvent -> {
			ThemeManager.registerTheme(DarkYellowTheme.class.getCanonicalName());
			ThemeManager.registerColorFilter(ThemeColorFilterConstant.LIGHT_YELLOW.getHexValue());
			new InformationUI(INFO_HEADING, INFO_TEXT).setVisible(true);
		});

		return darkYellowThemeButton;
	}

}
