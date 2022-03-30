package org.onliner.spring.c51.enums;

public enum ProductSubcategory {
    PHONES("Phones", ProductCategory.ELECTRONICS),
    BUILT_IN_APPLIANCES("Built-in appliances", ProductCategory.HOUSEHOLD_APPLIANCES);

    private final String name;
    private final ProductCategory productCategory;

    ProductSubcategory(String name, ProductCategory productCategory) {
        this.name = name;
        this.productCategory = productCategory;
    }

    public String getName() {
        return name;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }
}
