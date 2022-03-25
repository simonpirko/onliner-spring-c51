package org.onliner.spring.c51.controller;

import org.onliner.spring.c51.dto.seller.SellerSignupDTO;
import org.onliner.spring.c51.service.SellerService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/seller")
public class SellerController {
    public static final String ATTRIBUTE_SELLER = "seller";
    public static final String PATH_SELLER_SIGNUP_TEMPLATE = "seller/signup";
    public static final String REDIRECT_TO_HOME_PAGE_URL = "redirect:/";
    private SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/signup")
    public String getSellerSignupTemplate(@ModelAttribute(ATTRIBUTE_SELLER) SellerSignupDTO sellerSignupDTO) {
        return PATH_SELLER_SIGNUP_TEMPLATE;
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute(ATTRIBUTE_SELLER) @Valid SellerSignupDTO sellerSignupDTO,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return PATH_SELLER_SIGNUP_TEMPLATE;
        } else {
            if (sellerService.signup(sellerSignupDTO)) {
                return REDIRECT_TO_HOME_PAGE_URL;
            } else {
                return PATH_SELLER_SIGNUP_TEMPLATE;
            }
        }
    }
}
