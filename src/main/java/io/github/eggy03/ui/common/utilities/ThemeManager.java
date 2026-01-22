package io.github.eggy03.ui.common.utilities;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import io.github.eggy03.ui.common.constant.ThemeColorFilterConstant;
import io.github.eggy03.ui.common.themes.DarkTheme;
import io.github.eggy03.ui.common.ui.ExceptionUI;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.prefs.Preferences;

@Slf4j
@UtilityClass
public class ThemeManager {

    private static final Preferences prefs = Preferences.userNodeForPackage(ThemeManager.class);
    private static final String THEME_KEY = "appliedTheme";
    private static final String COLOR_KEY = "appliedColor";

    public static void registerTheme(@NonNull String themeClassName) {
        prefs.put(THEME_KEY, themeClassName);
    }

    public static void registerColorFilter(@NotNull String hexColorCode) {
        prefs.put(COLOR_KEY, hexColorCode);
    }

    @Nullable
    private static String getRegisteredTheme() {
        return prefs.get(THEME_KEY, null);
    }

    @Nullable
    private static String getRegisteredColorFilter() {
        return prefs.get(COLOR_KEY, null);
    }

    /**
     * IMPORTANT: Invoke this only from the Event Dispatch Thread
     */
    public static void loadAndApplySavedThemeOrDefault() {

        // retrieve last saved theme
        String savedTheme = getRegisteredTheme();

        if (savedTheme == null || savedTheme.isBlank()) {
            // if no saved theme is detected, load and save dark theme as default
            DarkTheme.setup();
            registerTheme(DarkTheme.class.getCanonicalName());

        } else {
            // else apply saved theme
            try {
                UIManager.setLookAndFeel(savedTheme);
            } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                // if the saved theme cannot be applied, fall back to default theme and update the registry to same
                DarkTheme.setup();
                registerTheme(DarkTheme.class.getCanonicalName());

                log.error("Previously saved theme could not be applied", e);
                new ExceptionUI("Theme Error", "Could not load saved theme. Default theme has been applied");
            }
        }
    }

    /**
     * IMPORTANT: Invoke this only from the Event Dispatch Thread
     */
    public static void loadAndApplySavedColorFormat() {
        String colorFilter = getRegisteredColorFilter();

        if(colorFilter==null || colorFilter.isBlank() || colorFilter.equals(ThemeColorFilterConstant.NONE.getHexValue()))
            return;

        FlatSVGIcon.ColorFilter.getInstance().setMapper(color -> java.awt.Color.decode(colorFilter));
    }
}
