package org.onliner.spring.c51.dao.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.onliner.spring.c51.dao.SellerOfferDAO;
import org.onliner.spring.c51.entity.SellerOffer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * exists implement
 */
@Repository
public class HibernateSellerOfferDAO implements SellerOfferDAO {
    private final SessionFactory sessionFactory;

    public HibernateSellerOfferDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean exists(SellerOffer sellerOffer) {
        return false;
    }

    @Override
    public boolean save(SellerOffer sellerOffer) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(sellerOffer);
        return true;
    }

    @Override
    public List<SellerOffer> findAll() {
        Session session = sessionFactory.openSession();
        Query<SellerOffer> namedQuery = session.createNamedQuery("SellerOffer.findAll", SellerOffer.class);
        List<SellerOffer> sellerOffers = namedQuery.list();
        session.close();
        return sellerOffers;
    }

    @Override
    public Optional<SellerOffer> findById(long id) {
        Session session = sessionFactory.openSession();
        SellerOffer sellerOffer = session.get(SellerOffer.class, id);
        session.close();
        return Optional.ofNullable(sellerOffer);
    }

    @Override
    public List<SellerOffer> findByProductId(long productId) {
        Session session = sessionFactory.openSession();
        Query<SellerOffer> namedQuery = session.createNamedQuery("SellerOffer.findByProductId", SellerOffer.class);
        namedQuery.setParameter("productId", productId);
        List<SellerOffer> sellerOffers = namedQuery.list();
        session.close();
        return sellerOffers;
    }

    @Override
    public boolean existsByProductIdAndSellerManagerId(long productId, long sellerManagerId) {
        Session session = sessionFactory.openSession();
        Query<SellerOffer> namedQuery = session.createNamedQuery("SellerOffer.existsByProductIdAndSellerManagerId", SellerOffer.class);
        namedQuery.setParameter("productId", productId);
        namedQuery.setParameter("sellerManagerId", sellerManagerId);
        Optional<SellerOffer> sellerOffer = namedQuery.uniqueResultOptional();
        session.close();
        return sellerOffer.isPresent();
    }
}
