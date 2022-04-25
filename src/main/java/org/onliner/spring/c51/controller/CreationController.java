package org.onliner.spring.c51.controller;

import org.onliner.spring.c51.service.ProductService;
import org.onliner.spring.c51.service.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/create")
public class CreationController {
    public static final String PATH_CREATE_PRODUCT_TEMPLATE = "product/create-product";
    public static final String ATTRIBUTE_PRODUCTS = "product";
    private final ProductService productService;
    private final ProductTypeService productTypeService;

    public CreationController(ProductService productService, ProductTypeService productTypeService) {
        this.productService = productService;
        this.productTypeService = productTypeService;
    }

    @GetMapping("/{type}")
    public String getCreateSmartphoneTemplate(@PathVariable String type, Model model) {
        model.addAttribute(ATTRIBUTE_PRODUCTS, productTypeService.getProductTypeDetailsDTO(productTypeService.findByProductTypeName(type)));
        return PATH_CREATE_PRODUCT_TEMPLATE;
    }

}
