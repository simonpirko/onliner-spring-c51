package org.onliner.spring.c51.service;

import org.onliner.spring.c51.dao.RoleDAO;
import org.onliner.spring.c51.entity.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {
    private RoleDAO roleDAO;

    public RoleService(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public List<Role> findAll() {
        return roleDAO.findAll();
    }
}
