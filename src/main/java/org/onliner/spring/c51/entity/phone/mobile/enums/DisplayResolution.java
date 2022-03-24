package org.onliner.spring.c51.entity.phone.mobile.enums;

public enum DisplayResolution {

    RESOLUTION1("68x68"),
    RESOLUTION2("96x64"),
    RESOLUTION3("96x68"),
    RESOLUTION4("128x64"),
    RESOLUTION5("128x128"),
    RESOLUTION6("120x160"),
    RESOLUTION7("128x160"),
    RESOLUTION8("160x128"),
    RESOLUTION9("144x176"),
    RESOLUTION10("167x220"),
    RESOLUTION11("174x220"),
    RESOLUTION12("176x220"),
    RESOLUTION13("220x176"),
    RESOLUTION14("240x320"),
    RESOLUTION15("320x240"),
    RESOLUTION16("240x400"),
    RESOLUTION17("320x320"),
    RESOLUTION18("360x400"),
    RESOLUTION19("320x480"),
    RESOLUTION20("480x800"),
    RESOLUTION21("480x854"),
    RESOLUTION22("422x960"),
    RESOLUTION23("442x960"),
    RESOLUTION24("480x960"),
    RESOLUTION25("480x996"),
    RESOLUTION26("540x960"),
    RESOLUTION27("540x1080"),
    RESOLUTION28("540x1132"),
    RESOLUTION29("540x1200"),
    RESOLUTION30("640x960"),
    RESOLUTION31("600x1280"),
    RESOLUTION32("640x1136"),
    RESOLUTION33("640x1280"),
    RESOLUTION34("640x1352"),
    RESOLUTION35("720x720"),
    RESOLUTION36("720x1280"),
    RESOLUTION37("720x1440"),
    RESOLUTION38("720x1480"),
    RESOLUTION39("720x1500"),
    RESOLUTION40("720x1512"),
    RESOLUTION41("720x1520"),
    RESOLUTION42("720x1544"),
    RESOLUTION43("720x1560"),
    RESOLUTION44("720x1570"),
    RESOLUTION45("720x1600"),
    RESOLUTION46("720x1640"),
    RESOLUTION47("750x1334"),
    RESOLUTION48("768x1280"),
    RESOLUTION49("828x1792"),
    RESOLUTION50("876x2142"),
    RESOLUTION51("1080x1920"),
    RESOLUTION52("1080x2040"),
    RESOLUTION53("1080x2160"),
    RESOLUTION54("1080x2220"),
    RESOLUTION55("1080x2232"),
    RESOLUTION56("1080x2240"),
    RESOLUTION57("1080x2244"),
    RESOLUTION58("1080x2246"),
    RESOLUTION59("1080x2248"),
    RESOLUTION60("1080x2256"),
    RESOLUTION61("1080x2270"),
    RESOLUTION62("1080x2280"),
    RESOLUTION63("1080x2300"),
    RESOLUTION64("1080x2310"),
    RESOLUTION65("1080x2312"),
    RESOLUTION66("1080x2340"),
    RESOLUTION67("1080x2376"),
    RESOLUTION68("1080x2388"),
    RESOLUTION69("1080x2400"),
    RESOLUTION70("1080x2404"),
    RESOLUTION71("1080x2408"),
    RESOLUTION72("1080x2412"),
    RESOLUTION73("1080x2448"),
    RESOLUTION74("1080x2460"),
    RESOLUTION75("1080x2520"),
    RESOLUTION76("1080x2640"),
    RESOLUTION77("1080x2636"),
    RESOLUTION78("1125x2436"),
    RESOLUTION79("1170x2532"),
    RESOLUTION80("1176x2400"),
    RESOLUTION81("1188x2790"),
    RESOLUTION82("1200x2640"),
    RESOLUTION83("1228x2700"),
    RESOLUTION84("1236x2676"),
    RESOLUTION85("1242x2688"),
    RESOLUTION86("1284x2778"),
    RESOLUTION87("1344x2772"),
    RESOLUTION88("1440x2560"),
    RESOLUTION89("1440x2880"),
    RESOLUTION90("1440x2960"),
    RESOLUTION91("1440x3088"),
    RESOLUTION92("1440x3120"),
    RESOLUTION93("1440x3200"),
    RESOLUTION94("1440x3216"),
    RESOLUTION95("1536x2152"),
    RESOLUTION96("1768x2208"),
    RESOLUTION97("2200x2480");

    private final String displayValue;

    private DisplayResolution(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}