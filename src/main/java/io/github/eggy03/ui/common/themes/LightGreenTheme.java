package io.github.eggy03.ui.common.themes;

import com.formdev.flatlaf.FlatLightLaf;

public class LightGreenTheme extends FlatLightLaf {

	public static boolean setup() {
		return setup(new LightGreenTheme());
	}
	
	@Override
    public String getName() {
        return "LightGreenTheme";
    }

}
