package org.onliner.spring.c51.dao;

import org.onliner.spring.c51.entity.Seller;

import java.util.Optional;

public interface SellerDAO extends GenericEntityDAO<Seller> {
    Optional<Seller> findById(long id);

    Optional<Seller> findBySellerManagerId(long sellerManagerId);
}
