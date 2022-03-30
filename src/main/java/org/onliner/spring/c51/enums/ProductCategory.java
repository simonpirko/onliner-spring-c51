package org.onliner.spring.c51.enums;

public enum ProductCategory {
    ELECTRONICS("Electronics"),
    HOUSEHOLD_APPLIANCES("Household appliances");

    private final String name;

    ProductCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
