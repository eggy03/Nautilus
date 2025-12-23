package io.github.eggy03.ui;

import com.formdev.flatlaf.FlatLaf;
import io.github.eggy03.ui.common.themes.DarkTheme;
import io.github.eggy03.ui.common.utilities.UIManagerConfigurations;

import java.awt.EventQueue;

public class Start {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            FlatLaf.registerCustomDefaultsSource("themes"); // for maven build, this points towards src/main/resources/themes
            DarkTheme.setup(); // register dark theme
            UIManagerConfigurations.enableRoundComponents();
            UIManagerConfigurations.enableTabSeparators(true);

            ApplicationUI frame = new ApplicationUI();
            frame.setName("FerrumX-Windows");
            frame.setVisible(true);
        });
    }
}
