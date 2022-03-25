package org.onliner.spring.c51.entity.phone.mobile.enums;

public enum Storage {

    STORAGE1145Kb("145Кб"),
    STORAGE2200Kb("200Кб"),
    STORAGE3400Kb("400Кб"),
    STORAGE41Mb("1Мб"),
    STORAGE54Mb("4Мб"),
    STORAGE68Mb("8Мб"),
    STORAGE716Mb("16Мб"),
    STORAGE824Mb("24Мб"),
    STORAGE932Mb("32Мб"),
    STORAGE1035Mb("35Мб"),
    STORAGE1148Mb("48Мб"),
    STORAGE1250Mb("50Мб"),
    STORAGE1360Mb("60Мб"),
    STORAGE1464Mb("64Мб"),
    STORAGE15128Mb("128Мб"),
    STORAGE16256Mb("256Мб"),
    STORAGE17512Mb("512Мб"),
    STORAGE182Gb("2ГБ"),
    STORAGE194Gb("4ГБ"),
    STORAGE208Gb("8ГБ"),
    STORAGE2116Gb("16ГБ"),
    STORAGE2232Gb("32ГБ"),
    STORAGE2364Gb("64ГБ"),
    STORAGE24128Gb("128ГБ"),
    STORAGE25256Gb("256ГБ"),
    STORAGE26512Gb("512ГБ"),
    STORAGE271Tb("1ТБ");


    private final String displayValue;

    private Storage(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
