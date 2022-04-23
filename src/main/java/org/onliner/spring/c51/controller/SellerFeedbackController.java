package org.onliner.spring.c51.controller;

import org.onliner.spring.c51.dao.SellerDAO;
import org.onliner.spring.c51.dto.seller.SellerFeedbackDTO;
import org.onliner.spring.c51.dto.seller.SellerSignupDTO;
import org.onliner.spring.c51.entity.Seller;
import org.onliner.spring.c51.entity.SellerFeedback;
import org.onliner.spring.c51.entity.StateRegistrationInformation;
import org.onliner.spring.c51.entity.User;
import org.onliner.spring.c51.service.SellerFeedbackService;
import org.onliner.spring.c51.service.SellerService;
import org.onliner.spring.c51.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.Instant;
import java.util.Date;

@Controller
@RequestMapping("/seller-feedback")
public class SellerFeedbackController {

    public static final String ATTRIBUTE_SELLER_FEEDBACK = "sellerFeedback";
    public static final String ATTRIBUTE_SELLER_FEEDBACK_LIST = "sellerFeedbackList";
    public static final String PATH_SELLER_FEEDBACK_SAVE_TEMPLATE = "/seller-feedback/{sellerId}/save";
    public static final String PATH_SELLER_FEEDBACK_HISTORY_TEMPLATE = "/seller-feedback/{sellerId}/history";
    @Autowired
    private SellerFeedbackService sellerFeedbackService;

    private UserService userService;


    private SellerService sellerService;


    public SellerFeedbackController(SellerFeedbackService sellerFeedbackService) {
        this.sellerFeedbackService = sellerFeedbackService;
    }

    @GetMapping("/{sellerId}/save")
    public String getSellerFeedbackWriteTemplate(@ModelAttribute(ATTRIBUTE_SELLER_FEEDBACK) SellerFeedbackDTO sellerFeedbackDTO) {

//        SellerSignupDTO sellerSignupDTO = new SellerSignupDTO()
//        SellerService sellerService = new SellerService(SellerDAO )
        return PATH_SELLER_FEEDBACK_SAVE_TEMPLATE;
    }

    @PostMapping("/{sellerId}/save")
    public String save(@ModelAttribute(ATTRIBUTE_SELLER_FEEDBACK) @Valid SellerFeedbackDTO sellerFeedbackDTO,
                       BindingResult bindingResult, HttpSession httpSession, ModelMap model, @PathVariable Long sellerId) {
        if (bindingResult.hasErrors() || sellerId == null) {
            return PATH_SELLER_FEEDBACK_SAVE_TEMPLATE;
        } else {
            sellerFeedbackDTO.setSellerId(String.valueOf(sellerId));
            sellerFeedbackDTO.setUserId(String.valueOf(userService.findById(Integer.parseInt((String) httpSession.getAttribute("userId"))).get()));

            if (sellerFeedbackService.save(sellerFeedbackDTO)) {
                return PATH_SELLER_FEEDBACK_HISTORY_TEMPLATE;
            } else {
                return PATH_SELLER_FEEDBACK_SAVE_TEMPLATE;
            }
        }
    }

    @GetMapping("/{sellerId}/history")
    public String findSellerFeedbackList(ModelMap model, @PathVariable("sellerId") Long sellerId) {
        if (sellerId == null){
            return "redirect:/";
        }

        model.put(ATTRIBUTE_SELLER_FEEDBACK_LIST, sellerFeedbackService.findBySeller(sellerService.findById(sellerId).get()));

        return PATH_SELLER_FEEDBACK_HISTORY_TEMPLATE;
    }

}
