package org.onliner.spring.c51.entity.phone.mobile.enums;

public enum PhoneCaseMaterial {

    PLASTIC("пластик"),
    METAL("металл"),
    MAGNESIUM_ALLOY("магниевыйсплав"),
    RUBBER("резина"),
    GLASS("стекло"),
    FIBERGLASS("стекловолокно"),
    LEATHER("кожа"),
    CERAMICS("керамика");


    private final String displayValue;

    private PhoneCaseMaterial(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
