package io.github.eggy03.ui.utilities;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import io.github.eggy03.ui.themes.DarkTheme;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import java.util.prefs.Preferences;

@Slf4j
public class ThemeManager {
	
	private static final Preferences prefs = Preferences.userNodeForPackage(ThemeManager.class);
    private static final String THEME_PREF_KEY = "selectedTheme";
    private static final String DEFAULT_THEME = DarkTheme.class.getCanonicalName();
    
    private ThemeManager() {
    	throw new IllegalStateException("Utility Class");
    }
    public static void registerTheme(String themeName) {
    	if(!themeName.isBlank()) {
    		prefs.put(THEME_PREF_KEY, themeName);
    	}
    }

    public static String getRegisteredTheme() {
    	return prefs.get(THEME_PREF_KEY, DEFAULT_THEME);
    }
    
    public static void notifyCurrentTheme(JRadioButtonMenuItem... j) {
    	/*
    	 * Order:
    	 * 1) Light Theme
    	 * 2) Dark Theme
    	 */
    	
    	switch(prefs.get(THEME_PREF_KEY, DEFAULT_THEME)) {
    	
    		case "com.ferrumx.ui.themes.LightTheme":
    			SwingUtilities.invokeLater(()-> j[0].setSelected(true));
    			FlatSVGIcon.ColorFilter.getInstance().setMapper(color -> java.awt.Color.decode("#fc8d00"));
    			break;

    		case "com.ferrumx.ui.themes.DarkTheme":
    			SwingUtilities.invokeLater(()-> j[1].setSelected(true));
    			break;
    		
    		default:
    			log.warn("Theme usage could not be notified");
    	}
    }
}
