package org.onliner.spring.c51.service;

import org.onliner.spring.c51.dao.RoleDAO;
import org.onliner.spring.c51.dao.UserDAO;
import org.onliner.spring.c51.dto.user.AuthenticatedUserDTO;
import org.onliner.spring.c51.dto.user.UserLoginDTO;
import org.onliner.spring.c51.dto.user.UserSignupDTO;
import org.onliner.spring.c51.dtoconverter.UserDTOConverter;
import org.onliner.spring.c51.entity.Role;
import org.onliner.spring.c51.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {
    private final UserDAO userDAO;
    private final RoleDAO roleDAO;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserDAO userDAO, RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    public boolean signup(UserSignupDTO userSignupDTO) {
        if (userDAO.findByEmail(userSignupDTO.getEmail()).isPresent()) {
            logger.info(this.getClass().getName() + " SIGNUP METHOD " + "User with email " + userSignupDTO.getEmail() + " already exists!");
            return false;
        } else {
            User user = UserDTOConverter.convertToUserFromUserSignupDTO(userSignupDTO);
            user.addRole(roleDAO.findByName(Role.ROLE_USER).get());
            return userDAO.save(user);
        }
    }

    public Optional<AuthenticatedUserDTO> authenticate(UserLoginDTO userLoginDTO) {
        Optional<User> userFoundByEmail = userDAO.findByEmailWithRoles(userLoginDTO.getEmail());
        if (userFoundByEmail.isPresent() && userFoundByEmail.get().getPassword().equals(userLoginDTO.getPassword())) {
            return Optional.of(UserDTOConverter.convertToAuthenticatedUserDTOFromUser(userFoundByEmail.get()));
        } else {
            return Optional.empty();
        }
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public Optional<User> findByEmailWithRole(String email) {
        return userDAO.findByEmailWithRoles(email);
    }

    public void assignRolesToUser(User user, Set<Role> roles) {
        roles.removeIf(role -> user.getRoles().contains(role));
        if (!roles.isEmpty()) {
            Set<Role> foundRoles = roles.stream()
                    .map(role -> roleDAO.findByName(role.getName()).orElse(null))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toSet());
            userDAO.assignRolesToUser(user, foundRoles);
        }
    }

    public Optional<User> findById(int id) {
        return userDAO.findById(id);
    }

    public User findByEmailForSellerFeedback(String email) {
        return userDAO.findByEmailForSellerFeedback(email).get();
    }
}
