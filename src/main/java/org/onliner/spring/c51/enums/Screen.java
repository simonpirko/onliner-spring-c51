package org.onliner.spring.c51.enums;

public enum Screen {

    MONOCHROME("монохромный"),
    COLOR("цветной"),
    TFT("TFT"),
    COLORS_4096("4096 цветов"),
    COLORS_64K("64 тыс. цветов"),
    COLORS_65K("65 тыс. цветов"),
    COLORS_256K("256 тыс. цветов"),
    COLORS_16_MILLION("16 млн. цветов");

    private final String displayValue;

    private Screen(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
