package io.github.eggy03.ui.common.themes;

import com.formdev.flatlaf.FlatLightLaf;

public class PinkTheme extends FlatLightLaf {

    public static boolean setup() {
        return setup(new PinkTheme());
    }

    @Override
    public String getName() {
        return "PinkTheme";
    }

}
