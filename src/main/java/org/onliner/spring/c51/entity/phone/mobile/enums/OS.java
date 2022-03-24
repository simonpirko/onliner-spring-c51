package org.onliner.spring.c51.entity.phone.mobile.enums;

public enum OS {

    OS1("Android"),
    OS2("AppleiOS"),
    OS3("WindowsPhone"),
    OS4("Symbian"),
    OS5("Bada"),
    OS6("NokiaSeries30+"),
    OS7("KaiOS");

    private final String displayValue;

    private OS(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
