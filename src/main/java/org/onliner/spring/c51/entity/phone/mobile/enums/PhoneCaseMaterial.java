package org.onliner.spring.c51.entity.phone.mobile.enums;

public enum PhoneCaseMaterial {

    MATERIAL1("пластик"),
    MATERIAL2("металл"),
    MATERIAL3("магниевыйсплав"),
    MATERIAL4("резина"),
    MATERIAL5("стекло"),
    MATERIAL6("стекловолокно"),
    MATERIAL7("кожа"),
    MATERIAL8("керамика");

    private final String displayValue;

    private PhoneCaseMaterial(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
