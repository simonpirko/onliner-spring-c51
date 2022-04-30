package org.onliner.spring.c51.controller;

import org.onliner.spring.c51.dto.product.ProductDTO;
import org.onliner.spring.c51.dto.productType.ProductTypeDetailsDTO;
import org.onliner.spring.c51.dtoconverter.ProductDTOConverter;
import org.onliner.spring.c51.entity.*;
import org.onliner.spring.c51.service.ManufacturerService;
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
    public static final String ATTRIBUTE_PROPERTIES = "properties";
    public static final String ATTRIBUTE_MANUFACTURERS = "manufacturers";

    private final ProductService productService;
    private final ProductTypeService productTypeService;
    private final ManufacturerService manufacturerService;

    public CreationController(ProductService productService, ProductTypeService productTypeService, ManufacturerService manufacturerService) {
        this.productService = productService;
        this.productTypeService = productTypeService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/{type}")
    public String getCreateProductTemplate(@PathVariable String type, @ModelAttribute("productdto") ProductDTO productDTO,Model model) {
        ProductTypeDetailsDTO productTypeDetailsDTO =  productTypeService.getProductTypeDetailsDTO(productTypeService.findByProductTypeName(type));
        model.addAttribute(ATTRIBUTE_PROPERTIES, productTypeDetailsDTO);
        model.addAttribute(ATTRIBUTE_MANUFACTURERS, manufacturerService.getListManufacturers());
        return PATH_CREATE_PRODUCT_TEMPLATE;
    }

    @PostMapping("/{type}")
    public String createProduct(@PathVariable String type, @ModelAttribute("productdto") ProductDTO productDTO, Model model) {
        ProductTypeDetailsDTO productTypeDetailsDTO =  productTypeService.getProductTypeDetailsDTO(productTypeService.findByProductTypeName(type));
        model.addAttribute(ATTRIBUTE_PROPERTIES, productTypeDetailsDTO);
        model.addAttribute(ATTRIBUTE_MANUFACTURERS, manufacturerService.getListManufacturers());
        productService.save(ProductDTOConverter.convertToProductFromProductDTO(productDTO));
        return REDIRECT_CREATION_PRODUCT_TEMPLATE;

    }
}
