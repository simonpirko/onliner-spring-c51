package org.onliner.spring.c51.enums;

public enum PhoneKit {

    TUBE_WITHOUT_BASE("трубка без базы"),
    BASE_HANDSET("база + трубка"),
    BASE_2_TUBES("база + 2 трубки"),
    BASE_3_TUBES("база + 3 трубки"),
    BASE_STATION("базовая станция");

    private final String displayValue;

    private PhoneKit(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
