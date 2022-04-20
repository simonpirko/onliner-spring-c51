package org.onliner.spring.c51.service;


import org.onliner.spring.c51.dao.SellerFeedbackDAO;
import org.onliner.spring.c51.dto.seller.SellerFeedbackDTO;
import org.onliner.spring.c51.dtoconverter.SellerFeedbackDTOConverter;
import org.onliner.spring.c51.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SellerFeedbackService {
    private final SellerFeedbackDAO sellerFeedbackDAO;

    public SellerFeedbackService(SellerFeedbackDAO sellerFeedbackDAO) {
        this.sellerFeedbackDAO = sellerFeedbackDAO;
    }

    public List<SellerFeedback> findAll(){
        return sellerFeedbackDAO.findAll();
    }

    public List<SellerFeedback> findBySeller(Seller seller) {
        return sellerFeedbackDAO.findBySeller(seller);
    }

    public boolean save(SellerFeedbackDTO sellerFeedbackDTO) {
        SellerFeedback sellerFeedback = SellerFeedbackDTOConverter.convertToSellerFeedbackFromSellerFeedbackDTOConverter(sellerFeedbackDTO);
        if (sellerFeedbackDAO.exists(sellerFeedback)) {
            return false;
        } else {
            return sellerFeedbackDAO.save(sellerFeedback);
        }
    }
}
