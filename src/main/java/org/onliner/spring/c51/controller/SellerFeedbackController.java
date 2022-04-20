package org.onliner.spring.c51.controller;

import org.onliner.spring.c51.dto.seller.SellerFeedbackDTO;
import org.onliner.spring.c51.dto.seller.SellerSignupDTO;
import org.onliner.spring.c51.entity.Seller;
import org.onliner.spring.c51.entity.StateRegistrationInformation;
import org.onliner.spring.c51.entity.User;
import org.onliner.spring.c51.service.SellerFeedbackService;
import org.onliner.spring.c51.service.SellerService;
import org.onliner.spring.c51.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
@RequestMapping("/seller-feedback")
public class SellerFeedbackController {

    public static final String ATTRIBUTE_SELLER = "seller";
    public static final String ATTRIBUTE_SELLER_FEEDBACK = "sellerFeedback";
    public static final String ATTRIBUTE_SELLER_FEEDBACK_LIST = "sellerFeedbackList";
    public static final String PATH_SELLER_FEEDBACK_SAVE_TEMPLATE = "/seller-feedback/save";
    public static final String PATH_SELLER_FEEDBACK_HISTORY_TEMPLATE = "/seller-feedback/history";
    private SellerFeedbackService sellerFeedbackService;
    private UserService userService;
    private SellerService sellerService;

    SellerSignupDTO sellerSignupDTO = new SellerSignupDTO("test", "test", 1111, Date.from(Instant.ofEpochSecond(2022-02-22)), "test", Date.from(Instant.ofEpochSecond(2022-02-22)));


    public SellerFeedbackController(SellerFeedbackService sellerFeedbackService) {
        this.sellerFeedbackService = sellerFeedbackService;
    }

    @GetMapping("/save")
    public String getSellerFeedbackWriteTemplate(@ModelAttribute(ATTRIBUTE_SELLER_FEEDBACK) SellerFeedbackDTO sellerFeedbackDTO) {
        return PATH_SELLER_FEEDBACK_SAVE_TEMPLATE;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute(ATTRIBUTE_SELLER_FEEDBACK) @Valid SellerFeedbackDTO sellerFeedbackDTO,
                       BindingResult bindingResult, HttpSession httpSession) {
        sellerFeedbackDTO.setUser(userService.findByEmail(httpSession.getId()));
        if (bindingResult.hasErrors()) {
            return PATH_SELLER_FEEDBACK_SAVE_TEMPLATE;
        } else {
            if (sellerFeedbackService.save(sellerFeedbackDTO)) {
                return PATH_SELLER_FEEDBACK_HISTORY_TEMPLATE;
            } else {
                return PATH_SELLER_FEEDBACK_SAVE_TEMPLATE;
            }
        }
    }

    @GetMapping("/history")
    public String history(@ModelAttribute(ATTRIBUTE_SELLER_FEEDBACK_LIST) SellerFeedbackDTO sellerFeedbackDTO) {
        return PATH_SELLER_FEEDBACK_SAVE_TEMPLATE;
    }

    @GetMapping("/history")
    public String history(Model model) {
        //Seller sellerSession = (Seller) bindingResult.getModel().get("seller");

        //model.addAttribute(ATTRIBUTE_SELLER_FEEDBACK_LIST, sellerFeedbackService.findBySeller((Seller) model.getAttribute(ATTRIBUTE_SELLER)));
        model.addAttribute(ATTRIBUTE_SELLER_FEEDBACK_LIST, sellerFeedbackService.findBySeller(sellerService.findByPayerAccountNumber(payerAccountNumber)));
        return PATH_SELLER_FEEDBACK_HISTORY_TEMPLATE;
    }
}
