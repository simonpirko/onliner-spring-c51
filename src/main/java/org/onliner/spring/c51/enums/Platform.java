package org.onliner.spring.c51.enums;

public enum Platform {

    APPLEA("AppleA"),
    MEDIATEK("Mediatek"),
    QUALCOMMSNAPDRAGON("QualcommSnapdragon"),
    SAMSUNGEXYNOS("SamsungExynos"),
    SPREADTRUM("Spreadtrum"),
    UNISOC("UniSoC"),
    HUAWEIHISILICON("HuaweiHiSilicon"),
    INTELATOM("IntelAtom"),
    GOOGLE("Google");



    private final String displayValue;

    private Platform(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
