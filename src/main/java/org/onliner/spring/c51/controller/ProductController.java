package org.onliner.spring.c51.controller;

import org.onliner.spring.c51.entity.phone.Radiotelephone;
import org.onliner.spring.c51.entity.phone.Smartphone;
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
    public static final String PATH_PRODUCT_CREATE_TEMPLATE = "product/createtemplate";
    public static final String REDIRECT_TO_HOME_PAGE_URL = "redirect:/";
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/create")
    public ModelAndView getProductCreationTemplate(String type, ModelAndView modelAndView){

        switch (type) {
            case "radiotelephone":
            Radiotelephone radiotelephone = new Radiotelephone();
            modelAndView.addObject("product", radiotelephone);
            break;

            case "smartphone":
            Smartphone smartphone = new Smartphone();
            modelAndView.addObject("product", smartphone);
            break;
        }
        modelAndView.setViewName(PATH_PRODUCT_CREATE_TEMPLATE);
        modelAndView.addObject("type", type);
        System.out.println(modelAndView.getModel().get("product").toString());
        return modelAndView;
    }

    @PostMapping("/create/smartphone")
    public String createSmartphone(@ModelAttribute("smartphone") Smartphone smartphone, ModelAndView modelAndView){

        smartphone.setName(smartphone.getModelName()+" "
                +smartphone.getRam().getDisplayValue()+"/"
                +smartphone.getStorage().getDisplayValue()+" ("
                +smartphone.getPhoneCaseColor().getDisplayValue()+")");
        productService.save(smartphone);

        return REDIRECT_TO_HOME_PAGE_URL;
    }

    @PostMapping("/create/radiotelephone")
    public String createRadiotelephones(@ModelAttribute("radiotelephone") Radiotelephone radiotelephone, ModelAndView modelAndView){

        radiotelephone.setName(radiotelephone.getModelName()+" ("
                +radiotelephone.getPhoneCaseColor().getDisplayValue()+")");
        productService.save(radiotelephone);

        return REDIRECT_TO_HOME_PAGE_URL;
    }

}
