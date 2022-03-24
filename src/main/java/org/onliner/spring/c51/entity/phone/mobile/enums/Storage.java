package org.onliner.spring.c51.entity.phone.mobile.enums;

public enum Storage {

    STORAGE1("145Кб"),
    STORAGE2("200Кб"),
    STORAGE3("400Кб"),
    STORAGE4("1Мб"),
    STORAGE5("4Мб"),
    STORAGE6("8Мб"),
    STORAGE7("16Мб"),
    STORAGE8("24Мб"),
    STORAGE9("32Мб"),
    STORAGE10("35Мб"),
    STORAGE11("48Мб"),
    STORAGE12("50Мб"),
    STORAGE13("60Мб"),
    STORAGE14("64Мб"),
    STORAGE15("128Мб"),
    STORAGE16("256Мб"),
    STORAGE17("512Мб"),
    STORAGE18("2ГБ"),
    STORAGE19("4ГБ"),
    STORAGE20("8ГБ"),
    STORAGE21("16ГБ"),
    STORAGE22("32ГБ"),
    STORAGE23("64ГБ"),
    STORAGE24("128ГБ"),
    STORAGE25("256ГБ"),
    STORAGE26("512ГБ"),
    STORAGE27("1ТБ");

    private final String displayValue;

    private Storage(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
