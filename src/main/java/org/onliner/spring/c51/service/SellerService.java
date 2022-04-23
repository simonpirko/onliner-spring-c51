package org.onliner.spring.c51.service;

import org.onliner.spring.c51.dao.SellerDAO;
import org.onliner.spring.c51.dao.impl.hibernate.HibernateSellerDAO;
import org.onliner.spring.c51.dto.seller.SellerSignupDTO;
import org.onliner.spring.c51.dtoconverter.SellerDTOConverter;
import org.onliner.spring.c51.entity.Seller;
import org.onliner.spring.c51.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService {
    private SellerDAO sellerDAO;
    private HibernateSellerDAO hibernateSellerDAO;

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

    public Seller findByPayerAccountNumber(int payerAccountNumber) {
        return hibernateSellerDAO.findByPayerAccountNumber(payerAccountNumber);
    }


    public Optional<Seller> findById(long id) {
        return sellerDAO.findById(id);
    }
}
