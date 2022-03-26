package org.onliner.spring.c51.enums;

public enum Brand {

    APPLE("Apple"),
    XIAOMI("Xiaomi"),
    SAMSUNG("Samsung"),
    POCO("POCO"),
    HUAWEI("Huawei"),
    HONOR("HONOR"),
    REALME("Realme"),
    NOKIA("Nokia"),
    ONEPLUS("OnePlus"),
    VIVO("Vivo");



    private final String displayValue;

    private Brand(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
