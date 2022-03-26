package org.onliner.spring.c51.enums;

public enum RAM {

        RAM4Mb("4M6"),
        RAM8Mb("8M6"),
        RAM16Mb("16M6"),
        RAM20Mb("20M6"),
        RAM24Mb("24M6"),
        RAM32Mb("32M6"),
        RAM48Mb("48M6"),
        RAM64Mb("64M6"),
        RAM128Mb("128M6"),
        RAM256Mb("256M6"),
        RAM512Mb("512M6"),
        RAM768Mb("768M6"),
        RAM1Gb("1ГБ"),
        RAM1_5Gb("1.5ГБ"),
        RAM2Gb("2ГБ"),
        RAM3Gb("3ГБ"),
        RAM4Gb("4ГБ"),
        RAM6Gb("6ГБ"),
        RAM8Gb("8ГБ"),
        RAM10Gb("10ГБ"),
        RAM12Gb("12ГБ"),
        RAM16Gb("16ГБ"),
        RAM18Gb("18ГБ");


        private final String displayValue;

        private RAM(String displayValue) {
                this.displayValue = displayValue;
        }

        public String getDisplayValue() {
                return displayValue;
        }
}
