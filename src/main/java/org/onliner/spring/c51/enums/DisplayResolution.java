package org.onliner.spring.c51.enums;

public enum DisplayResolution {

    RESOLUTION68x68("68x68"),
    RESOLUTION96x64("96x64"),
    RESOLUTION96x68("96x68"),
    RESOLUTION128x64("128x64"),
    RESOLUTION128x128("128x128"),
    RESOLUTION120x160("120x160"),
    RESOLUTION128x160("128x160"),
    RESOLUTION160x128("160x128"),
    RESOLUTION144x176("144x176"),
    RESOLUTION167x220("167x220"),
    RESOLUTION174x220("174x220"),
    RESOLUTION176x220("176x220"),
    RESOLUTION220x176("220x176"),
    RESOLUTION240x320("240x320"),
    RESOLUTION320x240("320x240"),
    RESOLUTION240x400("240x400"),
    RESOLUTION320x320("320x320"),
    RESOLUTION360x400("360x400"),
    RESOLUTION320x480("320x480"),
    RESOLUTION480x800("480x800"),
    RESOLUTION480x854("480x854"),
    RESOLUTION422x960("422x960"),
    RESOLUTION442x960("442x960"),
    RESOLUTION480x960("480x960"),
    RESOLUTION480x996("480x996"),
    RESOLUTION540x960("540x960"),
    RESOLUTION540x1080("540x1080"),
    RESOLUTION540x1132("540x1132"),
    RESOLUTION540x1200("540x1200"),
    RESOLUTION640x960("640x960"),
    RESOLUTION600x1280("600x1280"),
    RESOLUTION640x1136("640x1136"),
    RESOLUTION640x1280("640x1280"),
    RESOLUTION640x1352("640x1352"),
    RESOLUTION720x720("720x720"),
    RESOLUTION720x1280("720x1280"),
    RESOLUTION720x1440("720x1440"),
    RESOLUTION720x1480("720x1480"),
    RESOLUTION720x1500("720x1500"),
    RESOLUTION720x1512("720x1512"),
    RESOLUTION720x1520("720x1520"),
    RESOLUTION720x1544("720x1544"),
    RESOLUTION720x1560("720x1560"),
    RESOLUTION720x1570("720x1570"),
    RESOLUTION720x1600("720x1600"),
    RESOLUTION720x1640("720x1640"),
    RESOLUTION750x1334("750x1334"),
    RESOLUTION768x1280("768x1280"),
    RESOLUTION828x1792("828x1792"),
    RESOLUTION876x2142("876x2142"),
    RESOLUTION1080x1920("1080x1920"),
    RESOLUTION1080x2040("1080x2040"),
    RESOLUTION1080x2160("1080x2160"),
    RESOLUTION1080x2220("1080x2220"),
    RESOLUTION1080x2232("1080x2232"),
    RESOLUTION1080x2240("1080x2240"),
    RESOLUTION1080x2244("1080x2244"),
    RESOLUTION1080x2246("1080x2246"),
    RESOLUTION1080x2248("1080x2248"),
    RESOLUTION1080x2256("1080x2256"),
    RESOLUTION1080x2270("1080x2270"),
    RESOLUTION1080x2280("1080x2280"),
    RESOLUTION1080x2300("1080x2300"),
    RESOLUTION1080x2310("1080x2310"),
    RESOLUTION1080x2312("1080x2312"),
    RESOLUTION1080x2340("1080x2340"),
    RESOLUTION1080x2376("1080x2376"),
    RESOLUTION1080x2388("1080x2388"),
    RESOLUTION1080x2400("1080x2400"),
    RESOLUTION1080x2404("1080x2404"),
    RESOLUTION1080x2408("1080x2408"),
    RESOLUTION1080x2412("1080x2412"),
    RESOLUTION1080x2448("1080x2448"),
    RESOLUTION1080x2460("1080x2460"),
    RESOLUTION1080x2520("1080x2520"),
    RESOLUTION1080x2640("1080x2640"),
    RESOLUTION1080x2636("1080x2636"),
    RESOLUTION1125x2436("1125x2436"),
    RESOLUTION1170x2532("1170x2532"),
    RESOLUTION1176x2400("1176x2400"),
    RESOLUTION1188x2790("1188x2790"),
    RESOLUTION1200x2640("1200x2640"),
    RESOLUTION1228x2700("1228x2700"),
    RESOLUTION1236x2676("1236x2676"),
    RESOLUTION1242x2688("1242x2688"),
    RESOLUTION1284x2778("1284x2778"),
    RESOLUTION1344x2772("1344x2772"),
    RESOLUTION1440x2560("1440x2560"),
    RESOLUTION1440x2880("1440x2880"),
    RESOLUTION1440x2960("1440x2960"),
    RESOLUTION1440x3088("1440x3088"),
    RESOLUTION1440x3120("1440x3120"),
    RESOLUTION1440x3200("1440x3200"),
    RESOLUTION1440x3216("1440x3216"),
    RESOLUTION1536x2152("1536x2152"),
    RESOLUTION1768x2208("1768x2208"),
    RESOLUTION2200x2480("2200x2480");


    private final String displayValue;

    private DisplayResolution(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
