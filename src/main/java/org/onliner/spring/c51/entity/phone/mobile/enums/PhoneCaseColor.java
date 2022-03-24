package org.onliner.spring.c51.entity.phone.mobile.enums;

public enum PhoneCaseColor {

    COLOR1("черный"),
    COLOR2("белый"),
    COLOR3("серебристый"),
    COLOR4("бежевый"),
    COLOR5("бирюзовый"),
    COLOR6("бордовый"),
    COLOR7("бронзовый"),
    COLOR8("голубой"),
    COLOR9("желтый"),
    COLOR10("зеленый"),
    COLOR11("золотистый"),
    COLOR12("коралловый"),
    COLOR13("коричневый"),
    COLOR14("красный"),
    COLOR15("медный"),
    COLOR16("мятный"),
    COLOR17("оранжевый"),
    COLOR18("песочный"),
    COLOR19("розовый"),
    COLOR20("светло-серый"),
    COLOR21("светло-синий"),
    COLOR22("серый"),
    COLOR23("синий"),
    COLOR24("сиреневый"),
    COLOR25("темно-зеленый"),
    COLOR26("темно-коричневый"),
    COLOR27("темно-красный"),
    COLOR28("темно-серый"),
    COLOR29("темно-синий"),
    COLOR30("фиолетовый");

    private final String displayValue;

    private PhoneCaseColor(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
