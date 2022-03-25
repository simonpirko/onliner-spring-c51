package org.onliner.spring.c51.entity.phone.mobile.enums;

public enum OS {

    ANDROID("Android"),
    APPLEIOS("AppleiOS"),
    WINDOWSPHONE("WindowsPhone"),
    SYMBIAN("Symbian"),
    BADA("Bada"),
    NOKIASERIES30("NokiaSeries30+"),
    KAIOS("KaiOS");


    private final String displayValue;

    private OS(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
