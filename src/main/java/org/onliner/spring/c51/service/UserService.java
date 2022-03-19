package org.onliner.spring.c51.service;

import org.onliner.spring.c51.dao.UserDAO;
import org.onliner.spring.c51.dto.user.UserSignupDTO;
import org.onliner.spring.c51.dtoconverter.UserDTOConverter;
import org.onliner.spring.c51.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDAO userDAO;
    private final UserDTOConverter userConverter;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserDAO userDAO, UserDTOConverter userConverter) {
        this.userDAO = userDAO;
        this.userConverter = userConverter;
    }

    public boolean signup(UserSignupDTO userSignupDTO) {
        if (userDAO.findByEmail(userSignupDTO.getEmail()).isPresent()) {
            logger.info(this.getClass().getName() + " SIGNUP METHOD " + "User with email " + userSignupDTO.getEmail() + " already exists!");
            return false;
        } else {
            User user = userConverter.convertToUserFromUserSignupDTO(userSignupDTO);
            return userDAO.save(user);
        }
    }
}
