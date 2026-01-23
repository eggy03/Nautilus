package io.github.eggy03.ui.common.themes;

import com.formdev.flatlaf.FlatLightLaf;

public class LightPinkTheme extends FlatLightLaf {

    public static boolean setup() {
        return setup(new LightPinkTheme());
    }

    @Override
    public String getName() {
        return "LightPinkTheme";
    }

}
