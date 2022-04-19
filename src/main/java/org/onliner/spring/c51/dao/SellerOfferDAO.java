package org.onliner.spring.c51.dao;

import org.onliner.spring.c51.entity.SellerOffer;

import java.util.List;

public interface SellerOfferDAO extends GenericEntityDAO<SellerOffer> {

    List<SellerOffer> findByProductId(long productId);

    boolean existsByProductIdAndSellerManagerId(long productId, long sellerManagerId);
}
