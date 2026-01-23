package io.github.eggy03.ui.common.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ThemeColorFilterConstant {

    NONE("NONE"),
    OLIVE_GREEN("#78A75A"),
    PINK("#F3687C");

    private final String hexValue;
}
