package io.github.eggy03.ui.common.themes;

import com.formdev.flatlaf.FlatDarkLaf;

public class DarkYellowTheme extends FlatDarkLaf {

    public static boolean setup() {
        return setup(new DarkYellowTheme());
    }

    @Override
    public String getName() {
        return "DarkYellowTheme";
    }

}