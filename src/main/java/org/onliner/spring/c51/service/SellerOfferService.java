package org.onliner.spring.c51.service;

import org.onliner.spring.c51.dao.ProductDAO;
import org.onliner.spring.c51.dao.SellerDAO;
import org.onliner.spring.c51.dao.SellerOfferDAO;
import org.onliner.spring.c51.dto.seller.SellerOfferDTO;
import org.onliner.spring.c51.entity.Product;
import org.onliner.spring.c51.entity.Seller;
import org.onliner.spring.c51.entity.SellerOffer;
import org.onliner.spring.c51.exception.BusinessEntityAlreadyExistsException;
import org.onliner.spring.c51.exception.BusinessEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SellerOfferService {
    private ProductDAO productDAO;
    private SellerDAO sellerDAO;
    private SellerOfferDAO sellerOfferDAO;

    public SellerOfferService(ProductDAO productDAO, SellerDAO sellerDAO, SellerOfferDAO sellerOfferDAO) {
        this.productDAO = productDAO;
        this.sellerDAO = sellerDAO;
        this.sellerOfferDAO = sellerOfferDAO;
    }

    public void addSellerOffer(SellerOfferDTO sellerOfferDTO) {
        System.out.println(sellerOfferDTO.getProductId() + "   " + sellerOfferDTO.getSellerManagerId());
        if (sellerOfferDAO.existsByProductIdAndSellerManagerId(sellerOfferDTO.getProductId(), sellerOfferDTO.getSellerManagerId())) {
            throw new BusinessEntityAlreadyExistsException("Offer already exists!");
        } else {
            Optional<Product> foundProduct = productDAO.findById(sellerOfferDTO.getProductId());
            Optional<Seller> foundSeller = sellerDAO.findBySellerManagerId(sellerOfferDTO.getSellerManagerId());
            if (foundProduct.isPresent() && foundSeller.isPresent()) {
                SellerOffer sellerOffer = SellerOffer.builder()
                        .product(foundProduct.get())
                        .seller(foundSeller.get())
                        .price(sellerOfferDTO.getPrice())
                        .build();
                foundProduct.get().addSellerOffer(sellerOffer);
                foundSeller.get().addSellerOffer(sellerOffer);
                sellerOfferDAO.save(sellerOffer);
            } else {
                throw new BusinessEntityNotFoundException("No product or seller with this manager!");
            }
        }
    }

    public List<SellerOffer> findByProductId(long productId) {
        return sellerOfferDAO.findByProductId(productId);
    }
}
