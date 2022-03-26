package org.onliner.spring.c51.enums;

public enum PhoneConnection {

    TELEPHONE_LINE_MODEM("телефонная линия/модем"),
    ETHERNET_IP_PHONE("Ethernet (IP-телефон)");


    private final String displayValue;

    private PhoneConnection(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
