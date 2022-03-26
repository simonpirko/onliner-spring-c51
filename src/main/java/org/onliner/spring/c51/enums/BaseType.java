package org.onliner.spring.c51.enums;

public enum BaseType {

    STAND("подставка"),
    WITH_ANSWERING_MACHINE_CONTROL("с управлением автоответчиком"),
    WITH_DIALING_AND_SPEAKERPHONE("с набором номера и громкой связью"),
    LANDLINE_PHONE("проводной телефон"),
    BASE_DIALING("Набор номера на базе"),
    CLI("АОН"),
    CALLERID("CallerID"),
    ANSWERING_MACHINE("Автоответчик");

    private final String displayValue;

    private BaseType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
