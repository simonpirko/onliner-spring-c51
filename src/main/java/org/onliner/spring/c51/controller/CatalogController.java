package org.onliner.spring.c51.controller;

import org.onliner.spring.c51.enums.ProductTypes;
import org.onliner.spring.c51.service.ProductService;
import org.onliner.spring.c51.service.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
    public static final String PATH_CATALOG_TEMPLATE = "catalog/catalog-page";
    public static final String PATH_SMARTPHONES_TEMPLATE = "catalog/smartphones";
    public static final String ATTRIBUTE_CATALOG = "catalog";
    public static final String ATTRIBUTE_PRODUCTS = "products";
    private final ProductService productService;
    private final ProductTypeService productTypeService;

    public CatalogController(ProductService productService, ProductTypeService productTypeService) {
        this.productService = productService;
        this.productTypeService = productTypeService;
    }

    @GetMapping
    public String getCatalogTemplate(Model model) {
        model.addAttribute(ATTRIBUTE_CATALOG, productTypeService.getCatalog());
        return PATH_CATALOG_TEMPLATE;
    }

    @GetMapping("/smartphone")
    public String getSmartphonesTemplate(Model model) {
        model.addAttribute(ATTRIBUTE_PRODUCTS, productService.findAllByProductType(ProductTypes.SMARTPHONE));
        return PATH_SMARTPHONES_TEMPLATE;
    }
}
