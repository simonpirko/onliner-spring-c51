package org.onliner.spring.c51.controller;

import org.onliner.spring.c51.dto.product.ProductDTO;
import org.onliner.spring.c51.entity.*;
import org.onliner.spring.c51.service.ProductService;
import org.onliner.spring.c51.service.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/create")
public class CreationController {
    public static final String PATH_CREATE_PRODUCT_TEMPLATE = "product/create-product";
    public static final String REDIRECT_CREATION_PRODUCT_TEMPLATE = "redirect:/admin/create-product";
    public static final String ATTRIBUTE_PRODUCTS = "properties";
    private final ProductService productService;
    private final ProductTypeService productTypeService;

    public CreationController(ProductService productService, ProductTypeService productTypeService) {
        this.productService = productService;
        this.productTypeService = productTypeService;
    }

    @GetMapping("/{type}")
    public String getCreateProductTemplate(@PathVariable String type, @ModelAttribute("productdto") ProductDTO productDTO,Model model) {
        System.out.println(type);
        model.addAttribute(ATTRIBUTE_PRODUCTS, productTypeService.getProductTypeDetailsDTO(productTypeService.findByProductTypeName(type)));
        return PATH_CREATE_PRODUCT_TEMPLATE;
    }

    @PostMapping("/{type}")
    public String createProduct(@PathVariable String type, @ModelAttribute("productdto") ProductDTO productDTO, Model model) {
        model.addAttribute(ATTRIBUTE_PRODUCTS, productTypeService.getProductTypeDetailsDTO(productTypeService.findByProductTypeName(type)));
        System.out.println(type);
        System.out.println(productDTO.showList());
        return REDIRECT_CREATION_PRODUCT_TEMPLATE;

    }
}
