package org.onliner.spring.c51.entity.phone.mobile.enums;

public enum RAM {

        RAM1("4M6"),
        RAM2("8M6"),
        RAM3("16M6"),
        RAM4("20M6"),
        RAM5("24M6"),
        RAM6("32M6"),
        RAM7("48M6"),
        RAM8("64M6"),
        RAM9("128M6"),
        RAM10("256M6"),
        RAM11("512M6"),
        RAM12("768M6"),
        RAM13("1ГБ"),
        RAM14("1.5ГБ"),
        RAM15("2ГБ"),
        RAM16("3ГБ"),
        RAM17("4ГБ"),
        RAM18("6ГБ"),
        RAM19("8ГБ"),
        RAM20("10ГБ"),
        RAM21("12ГБ"),
        RAM22("16ГБ"),
        RAM23("18ГБ");

        private final String displayValue;

        private RAM(String displayValue) {
                this.displayValue = displayValue;
        }

        public String getDisplayValue() {
                return displayValue;
        }
}
