package org.onliner.spring.c51.enums;

public enum Material {

    PLASTIC("пластик"),
    METAL("металл"),
    MAGNESIUM_ALLOY("магниевыйсплав"),
    RUBBER("резина"),
    GLASS("стекло"),
    FIBERGLASS("стекловолокно"),
    LEATHER("кожа"),
    CERAMICS("керамика");


    private final String displayValue;

    private Material(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
