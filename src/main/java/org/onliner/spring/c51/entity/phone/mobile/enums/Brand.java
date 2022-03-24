package org.onliner.spring.c51.entity.phone.mobile.enums;

public enum Brand {

    BRAND1("Apple"),
    BRAND2("Xiaomi"),
    BRAND3("Samsung"),
    BRAND4("POCO"),
    BRAND5("Huawei"),
    BRAND6("HONOR"),
    BRAND7("Realme"),
    BRAND8("Nokia"),
    BRAND9("OnePlus"),
    BRAND10("Vivo");


    private final String displayValue;

    private Brand(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
