package org.onliner.spring.c51.dao.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.onliner.spring.c51.dao.RoleDAO;
import org.onliner.spring.c51.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HibernateRoleDAO implements RoleDAO {
    private final SessionFactory sessionFactory;

    public HibernateRoleDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean exists(Role role) {
        Session session = sessionFactory.openSession();
        Query<Role> namedQuery = session.createNamedQuery("Role.exists", Role.class);
        namedQuery.setParameter("name", role.getName());
        Optional<Role> foundRole = namedQuery.uniqueResultOptional();
        session.close();
        return foundRole.isPresent();
    }

    @Override
    public boolean save(Role role) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(role);
        return true;
    }

    @Override
    public List<Role> findAll() {
        Session session = sessionFactory.openSession();
        Query<Role> namedQuery = session.createNamedQuery("Role.findAll", Role.class);
        List<Role> roles = namedQuery.list();
        session.close();
        return roles;
    }

    @Override
    public Optional<Role> findByName(String name) {
        Session session = sessionFactory.openSession();
        Query<Role> namedQuery = session.createNamedQuery("Role.findByName", Role.class);
        namedQuery.setParameter("name", name);
        Optional<Role> role = namedQuery.uniqueResultOptional();
        session.close();
        return role;
    }
}
