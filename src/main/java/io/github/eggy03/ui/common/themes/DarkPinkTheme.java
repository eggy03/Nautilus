package io.github.eggy03.ui.common.themes;

import com.formdev.flatlaf.FlatDarkLaf;

public class DarkPinkTheme extends FlatDarkLaf {

    public static boolean setup() {
        return setup(new DarkPinkTheme());
    }

    @Override
    public String getName() {
        return "DarkPinkTheme";
    }

}
