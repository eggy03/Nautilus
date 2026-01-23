package io.github.eggy03.ui.common.themes;

import com.formdev.flatlaf.FlatDarkLaf;

public class DarkGreenTheme extends FlatDarkLaf {

    public static boolean setup() {
        return setup(new DarkGreenTheme());
    }

    @Override
    public String getName() {
        return "DarkGreenTheme";
    }
}
