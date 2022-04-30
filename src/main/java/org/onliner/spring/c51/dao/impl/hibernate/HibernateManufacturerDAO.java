package org.onliner.spring.c51.dao.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.onliner.spring.c51.dao.ManufacturerDAO;
import org.onliner.spring.c51.entity.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class HibernateManufacturerDAO implements ManufacturerDAO {
    private final SessionFactory sessionFactory;

    public HibernateManufacturerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean exists(Manufacturer entity) {
        return false;
    }

    @Override
    public boolean save(Manufacturer entity) {
        return false;
    }

    @Override
    public List<Manufacturer> findAll() {
        Session session = sessionFactory.openSession();
        Query<Manufacturer> namedQuery = session.createNamedQuery("Manufacturer.findAll", Manufacturer.class);
        List<Manufacturer> manufacturers = namedQuery.list();
        session.close();
        return manufacturers;
    }

    @Override
    public Optional<Manufacturer> findById(long id) {
        Session session = sessionFactory.openSession();
        Query<Manufacturer> namedQuery = session.createNamedQuery("Manufacturer.findById", Manufacturer.class);
        namedQuery.setParameter("id", id);
        Optional<Manufacturer> manufacturer = namedQuery.uniqueResultOptional();
        session.close();
        return manufacturer;
    }
}
