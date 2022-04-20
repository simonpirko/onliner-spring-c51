package org.onliner.spring.c51.dtoconverter;

import org.onliner.spring.c51.dao.UserDAO;
import org.onliner.spring.c51.dto.seller.SellerFeedbackDTO;
import org.onliner.spring.c51.entity.SellerFeedback;
import org.onliner.spring.c51.service.SellerFeedbackService;
import org.onliner.spring.c51.service.SellerService;
import org.onliner.spring.c51.service.UserService;


public class SellerFeedbackDTOConverter {

    private static  UserService userService;
    private static SellerService sellerService;


    public  SellerFeedbackDTOConverter(UserService userService, SellerService sellerService) {
        this.userService = userService;
        this.sellerService = sellerService;
    }

    public static SellerFeedback convertToSellerFeedbackFromSellerFeedbackDTOConverter(SellerFeedbackDTO sellerFeedbackDTO) {


        return SellerFeedback.builder()
                .title(sellerFeedbackDTO.getTitle())
                .description(sellerFeedbackDTO.getDescription())
                .grade(sellerFeedbackDTO.getGrade())
                .user(userService.findByEmailForSellerFeedback(sellerFeedbackDTO.getEmail()))
                .seller(sellerService.findByPayerAccountNumber(sellerFeedbackDTO.getPayerAccountNumber()))
                .build();
    }
}
