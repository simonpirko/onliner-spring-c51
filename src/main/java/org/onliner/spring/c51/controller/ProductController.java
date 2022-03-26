package org.onliner.spring.c51.controller;

import org.onliner.spring.c51.entity.Product;
import org.onliner.spring.c51.entity.phone.Radiotelephones;
import org.onliner.spring.c51.entity.phone.Smartphone;
import org.onliner.spring.c51.enums.OS;
import org.onliner.spring.c51.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public String home (){
        return "home";
    }
    @GetMapping("/create")
    public ModelAndView getProductCreationTemplate(String type, ModelAndView modelAndView){

        switch (type) {
            case "radiotelephones":
            Radiotelephones radiotelephones = new Radiotelephones();
            modelAndView.addObject("product", radiotelephones);
            modelAndView.addObject("os",OS.values());
                break;
            case "smartphone":
            Smartphone smartphone = new Smartphone();
            modelAndView.addObject("product", smartphone);
            modelAndView.addObject("os",OS.values());
                break;
        }
        modelAndView.setViewName("product/createtemplate");


        modelAndView.addObject("type", type);
        System.out.println(modelAndView.getModel().get("product").toString());
        return modelAndView;
    }

    @PostMapping("/create/smartphone")
    public String createProduct(@ModelAttribute("smartphone") Smartphone smartphone, ModelAndView modelAndView){

        productService.save(smartphone);

        return "home";
    }
}
