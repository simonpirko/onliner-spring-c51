package org.onliner.spring.c51.dao;

import org.onliner.spring.c51.entity.Seller;
import org.onliner.spring.c51.entity.SellerFeedback;

import java.util.List;
import java.util.Optional;

public interface SellerFeedbackDAO extends GenericEntityDAO<SellerFeedback>{
    List<SellerFeedback> findBySeller(Seller seller);
}
