package io.github.eggy03.ui;

import com.formdev.flatlaf.FlatLaf;
import io.github.eggy03.ui.common.constant.OSConstants;
import io.github.eggy03.ui.common.ui.ExceptionUI;
import io.github.eggy03.ui.common.utilities.ThemeManager;
import io.github.eggy03.ui.common.utilities.UIManagerConfigurations;
import io.github.eggy03.ui.linux.LinuxUI;
import io.github.eggy03.ui.windows.WindowsUI;
import lombok.extern.slf4j.Slf4j;

import java.awt.EventQueue;

@Slf4j
public class Start {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        log.info("Detected OS: {}", OSConstants.getCurrentOS());
        FlatLaf.registerCustomDefaultsSource("themes"); // for maven build, this points towards src/main/resources/themes

        EventQueue.invokeLater(()-> {
            ThemeManager.loadSavedThemeOrDefault();
            UIManagerConfigurations.enableRoundComponents();
            UIManagerConfigurations.enableTabSeparators(true);
            
            launchUIBasedOnOS();
        });
    }

    private static void launchUIBasedOnOS() {
        switch (OSConstants.detectOs()) {
            case WINDOWS -> new WindowsUI().setVisible(true);
            case LINUX -> new LinuxUI().setVisible(true);
            default -> new ExceptionUI("Unsupported OS", OSConstants.getCurrentOS() + " is not supported");
        }
    }
}
