package org.onliner.spring.c51.enums;

import org.onliner.spring.c51.entity.phone.Radiotelephone;
import org.onliner.spring.c51.entity.phone.Smartphone;

public enum ProductType {
    SMARTPHONE(Smartphone.class.getSimpleName(), ProductSubcategory.PHONES, "/catalog/smartphone"),
    RADIOTELEPHONE(Radiotelephone.class.getSimpleName(), ProductSubcategory.PHONES, "/catalog/radiotelephone");

    private final String name;
    private final ProductSubcategory productSubcategory;
    private final String URL;

    ProductType(String name, ProductSubcategory productSubcategory, String URL) {
        this.name = name;
        this.productSubcategory = productSubcategory;
        this.URL = URL;
    }

    public String getName() {
        return name;
    }

    public ProductSubcategory getProductSubcategory() {
        return productSubcategory;
    }

    public String getURL() {
        return URL;
    }
}
