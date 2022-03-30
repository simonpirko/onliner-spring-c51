package org.onliner.spring.c51.controller;

import org.onliner.spring.c51.enums.ProductType;
import org.onliner.spring.c51.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
    public static final String PATH_CATALOG_TEMPLATE = "catalog/catalog-page";
    public static final String PATH_RADIOTELEPHONES_TEMPLATE = "catalog/radiotelephones";
    public static final String PATH_SMARTPHONES_TEMPLATE = "catalog/smartphones";
    public static final String ATTRIBUTE_CATALOG = "catalog";
    public static final String ATTRIBUTE_PRODUCTS = "products";
    private final ProductService productService;

    public CatalogController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getCatalogTemplate(Model model) {
        model.addAttribute(ATTRIBUTE_CATALOG, productService.getCatalog());
        return PATH_CATALOG_TEMPLATE;
    }

    @GetMapping("/radiotelephone")
    public String getRadiotelephonesTemplate(Model model) {
        model.addAttribute(ATTRIBUTE_PRODUCTS, productService.findAllByProductType(ProductType.RADIOTELEPHONE));
        return PATH_RADIOTELEPHONES_TEMPLATE;
    }

    @GetMapping("/smartphone")
    public String getSmartphonesTemplate(Model model) {
        model.addAttribute(ATTRIBUTE_PRODUCTS, productService.findAllByProductType(ProductType.SMARTPHONE));
        return PATH_SMARTPHONES_TEMPLATE;
    }
}
