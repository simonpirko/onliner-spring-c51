package org.onliner.spring.c51.dao.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.onliner.spring.c51.dao.UserDAO;
import org.onliner.spring.c51.entity.Role;
import org.onliner.spring.c51.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class HibernateUserDAO implements UserDAO {
    private final SessionFactory sessionFactory;
    private HibernateRoleDAO hibernateRoleDAO;

    public HibernateUserDAO(SessionFactory sessionFactory, HibernateRoleDAO hibernateRoleDAO) {
        this.sessionFactory = sessionFactory;
        this.hibernateRoleDAO = hibernateRoleDAO;
    }

    @Override
    public boolean exists(User user) {
        Session session = sessionFactory.openSession();
        Query<User> namedQuery = session.createNamedQuery("User.exists", User.class);
        namedQuery.setParameter("email", user.getEmail());
        Optional<User> foundUser = namedQuery.uniqueResultOptional();
        session.close();
        return foundUser.isPresent();
    }

    @Override
    public boolean save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
        return true;
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        Query<User> namedQuery = session.createNamedQuery("User.findAll", User.class);
        List<User> users = namedQuery.list();
        session.close();
        return users;
    }

    @Override
    public Optional<User> findByEmail(int id) {
        Session session = sessionFactory.openSession();
        Query<User> namedQuery = session.createNamedQuery("User.findByEmail", User.class);
        namedQuery.setParameter("email", email);
        Optional<User> user = namedQuery.uniqueResultOptional();
        session.close();
        return user;
    }

    @Override
    public Optional<User> findByEmailForSellerFeedback(String email) {
        Session session = sessionFactory.openSession();
        Query<User> namedQuery = session.createNamedQuery("User.findByEmail", User.class);
        namedQuery.setParameter("email", email);
        Optional<User> user = namedQuery.uniqueResultOptional();
        session.close();
        return user;
    }

    @Override
    public Optional<User> findByEmailWithRoles(String email) {
        Session session = sessionFactory.openSession();
        Query<User> namedQuery = session.createNamedQuery("User.findByEmailWithRoles", User.class);
        namedQuery.setParameter("email", email);
        Optional<User> user = namedQuery.uniqueResultOptional();
        session.close();
        return user;
    }

    @Override
    public List<User> findAllWithRoles() {
        Session session = sessionFactory.openSession();
        Query<User> namedQuery = session.createNamedQuery("User.findAllWithRoles", User.class);
        List<User> users = namedQuery.list();
        session.close();
        return users;
    }

    @Override
    public void assignRolesToUser(User user, Set<Role> roles) {
        Session session = sessionFactory.getCurrentSession();
        roles.forEach(user::addRole);
        session.merge(user);
    }

    @Override
    public Optional<User> findById(int id) {
        Session session = sessionFactory.openSession();
        Query<User> namedQuery = session.createNamedQuery("User.findById", User.class);
        namedQuery.setParameter("id", id);
        Optional<User> user = namedQuery.uniqueResultOptional();
        session.close();
        return user;
    }
}
