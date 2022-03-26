package org.onliner.spring.c51.service;

import org.onliner.spring.c51.dao.UserDAO;
import org.onliner.spring.c51.dto.user.AuthenticatedUserDTO;
import org.onliner.spring.c51.dto.user.UserLoginDTO;
import org.onliner.spring.c51.dto.user.UserSignupDTO;
import org.onliner.spring.c51.dtoconverter.UserDTOConverter;
import org.onliner.spring.c51.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserDAO userDAO;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean signup(UserSignupDTO userSignupDTO) {
        if (userDAO.findByEmail(userSignupDTO.getEmail()).isPresent()) {
            logger.info(this.getClass().getName() + " SIGNUP METHOD " + "User with email " + userSignupDTO.getEmail() + " already exists!");
            return false;
        } else {
            User user = UserDTOConverter.convertToUserFromUserSignupDTO(userSignupDTO);
            return userDAO.save(user);
        }
    }

    public Optional<AuthenticatedUserDTO> authenticate(UserLoginDTO userLoginDTO) {
        Optional<User> userFoundByEmail = userDAO.findByEmail(userLoginDTO.getEmail());
        if (userFoundByEmail.isPresent() && userFoundByEmail.get().getPassword().equals(userLoginDTO.getPassword())) {
            return Optional.of(UserDTOConverter.convertToAuthenticatedUserDTOFromUser(userFoundByEmail.get()));
        } else {
            return Optional.empty();
        }
    }
}
