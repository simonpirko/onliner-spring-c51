package org.onliner.spring.c51.entity.phone.mobile.enums;

public enum Platform {

    PLATFORM1("AppleA"),
    PLATFORM2("Mediatek"),
    PLATFORM3("QualcommSnapdragon"),
    PLATFORM4("SamsungExynos"),
    PLATFORM5("Spreadtrum"),
    PLATFORM6("UniSoC"),
    PLATFORM7("HuaweiHiSilicon"),
    PLATFORM8("IntelAtom"),
    PLATFORM9("Google");


    private final String displayValue;

    private Platform(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
