package org.onliner.spring.c51.service;

import org.onliner.spring.c51.dao.SellerDAO;
import org.onliner.spring.c51.dto.seller.SellerSignupDTO;
import org.onliner.spring.c51.dtoconverter.SellerDTOConverter;
import org.onliner.spring.c51.entity.Seller;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    private SellerDAO sellerDAO;

    public SellerService(SellerDAO sellerDAO) {
        this.sellerDAO = sellerDAO;
    }

    public boolean signup(SellerSignupDTO sellerSignupDTO) {
        Seller seller = SellerDTOConverter.convertToSellerFromSellerDTOConverter(sellerSignupDTO);
        if (sellerDAO.exists(seller)) {
            return false;
        } else {
            return sellerDAO.save(seller);
        }
    }
}
