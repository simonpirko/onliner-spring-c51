package org.onliner.spring.c51.controller;

import org.onliner.spring.c51.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    public static final String PATH_PRODUCT_CREATE_TEMPLATE = "product/create-product";
    public static final String PATH_PRODUCT_DETAILS_TEMPLATE = "product/product-details";
    public static final String ATTRIBUTE_PRODUCT_DETAILS = "productDetails";
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/create")
    public String getProductCreationTemplate() {
       return PATH_PRODUCT_CREATE_TEMPLATE;
    }

    @GetMapping("/{manufacturer}/{id}")
    public String getProductDetailsTemplate(@PathVariable String manufacturer, @PathVariable long id, Model model) {
        model.addAttribute(ATTRIBUTE_PRODUCT_DETAILS, productService.getProductDetailsByProductId(id));
        return PATH_PRODUCT_DETAILS_TEMPLATE;
    }
}
