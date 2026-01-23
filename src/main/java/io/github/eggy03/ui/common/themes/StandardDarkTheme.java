package io.github.eggy03.ui.common.themes;

import com.formdev.flatlaf.FlatDarkLaf;

public class StandardDarkTheme extends FlatDarkLaf {

	public static final String NAME = "StandardDarkTheme";

	public static boolean setup() {
		return setup( new StandardDarkTheme() );
	}

	public static void installLafInfo() {
		installLafInfo( NAME, StandardDarkTheme.class );
	}

	@Override
	public String getName() {
		return NAME;
	}
	
}
