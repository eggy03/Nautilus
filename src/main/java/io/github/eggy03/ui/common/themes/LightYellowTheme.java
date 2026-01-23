package io.github.eggy03.ui.common.themes;

import com.formdev.flatlaf.FlatLightLaf;

public class LightYellowTheme extends FlatLightLaf {

	public static boolean setup() {
		return setup(new LightYellowTheme());
	}
	
	@Override
    public String getName() {
        return "LightYellowTheme";
    }

}
