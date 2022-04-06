package org.onliner.spring.c51.controller;

import org.onliner.spring.c51.entity.Seller;
import org.onliner.spring.c51.entity.SellerFeedback;
import org.onliner.spring.c51.service.SellerFeedbackService;
import org.onliner.spring.c51.service.SellerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/seller-feedback")
public class SellerFeedbackController {
    public static final String ATTRIBUTE_SELLER = "seller";
    public static final String ATTRIBUTE_SELLER_FEEDBACK = "sellerFeedback";
    public static final String ATTRIBUTE_SELLER_FEEDBACK_LIST = "sellerFeedbackList";
    public static final String PATH_SELLER_FEEDBACK_SAVE_TEMPLATE = "/seller-feedback/save";
    public static final String PATH_SELLER_FEEDBACK_HISTORY_TEMPLATE = "/seller-feedback/history";
    private SellerFeedbackService sellerFeedbackService;

    public SellerFeedbackController(SellerService sellerService, SellerFeedbackService sellerFeedbackService) {
        this.sellerFeedbackService = sellerFeedbackService;
    }

    @GetMapping("/save")
    public String getSellerFeedbackWriteTemplate(@ModelAttribute(ATTRIBUTE_SELLER_FEEDBACK) SellerFeedback sellerFeedback) {
        return PATH_SELLER_FEEDBACK_SAVE_TEMPLATE;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute(ATTRIBUTE_SELLER_FEEDBACK) @Valid SellerFeedback sellerFeedback,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return PATH_SELLER_FEEDBACK_SAVE_TEMPLATE;
        } else {
            if (sellerFeedbackService.save(sellerFeedback)) {
                return PATH_SELLER_FEEDBACK_HISTORY_TEMPLATE;
            } else {
                return PATH_SELLER_FEEDBACK_SAVE_TEMPLATE;
            }
        }
    }

    @GetMapping("/history")
    public String history(Model model) {
        model.addAttribute(ATTRIBUTE_SELLER_FEEDBACK_LIST, sellerFeedbackService.findBySeller((Seller) model.getAttribute(ATTRIBUTE_SELLER)));
        return PATH_SELLER_FEEDBACK_HISTORY_TEMPLATE;
    }
}
