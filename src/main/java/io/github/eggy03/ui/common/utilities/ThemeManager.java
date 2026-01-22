package io.github.eggy03.ui.common.utilities;

import io.github.eggy03.ui.common.themes.DarkTheme;
import io.github.eggy03.ui.common.ui.ExceptionUI;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.prefs.Preferences;

@Slf4j
@UtilityClass
public class ThemeManager {

    private static final Preferences prefs = Preferences.userNodeForPackage(ThemeManager.class);
    private static final String KEY = "appliedTheme";

    public static void registerTheme(@NonNull String themeClassName) {
        prefs.put(KEY, themeClassName);
    }

    @Nullable
    private static String getRegisteredTheme() {
        return prefs.get(KEY, null);
    }

    public static void loadSavedThemeOrDefault() {
    	
    	if (!SwingUtilities.isEventDispatchThread()) { // if the function is not called upon an EDT thread, make it call on EDT
            SwingUtilities.invokeLater(ThemeManager::loadSavedThemeOrDefault);
            return;
        }

        String savedTheme = getRegisteredTheme(); // retrieve last saved theme

        if (savedTheme == null || savedTheme.isBlank()) { // if no saved theme is detected, load and save dark theme as default
            DarkTheme.setup();
            registerTheme(DarkTheme.class.getCanonicalName());
        } else { // else apply saved theme
            try {
                UIManager.setLookAndFeel(savedTheme);
            } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                log.error("Previously saved theme could not be applied", e); // if the saved theme cannot be applied, fall back to default theme and update the registry to same
                DarkTheme.setup();
                registerTheme(DarkTheme.class.getCanonicalName());
                new ExceptionUI("Theme Error", "Could not load saved theme. Default theme has been applied");
            }
        }
    }
}
