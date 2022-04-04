package org.onliner.spring.c51.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.onliner.spring.c51.dao.UserDAO;
import org.onliner.spring.c51.dto.user.UserSignupDTO;
import org.onliner.spring.c51.dtoconverter.UserDTOConverter;
import org.onliner.spring.c51.entity.User;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceTest {
    private static final String EMAIL = "test@gmail.com";

    UserDAO userDAO = mock(UserDAO.class);
    UserDTOConverter userDTOConverter = mock(UserDTOConverter.class);
    UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void startup() {
        userService = new UserService(userDAO, userDTOConverter);
    }

    @Test
    void signupUserExists(){
        when(userDAO.findByEmail(EMAIL)).thenReturn(Optional.of(new User()));

        UserSignupDTO userSignupDTO = new UserSignupDTO();
        userSignupDTO.setEmail(EMAIL);
        boolean signupResult = userService.signup(userSignupDTO);

        assertFalse(signupResult);

    }
    @Test
    void signupSuccess(){
        UserSignupDTO userSignupDTO = new UserSignupDTO();
        userSignupDTO.setEmail(EMAIL);
        User user = new User();

        when(userDAO.findByEmail(EMAIL)).thenReturn(Optional.empty());
        when(userDTOConverter.convertToUserFromUserSignupDTO(userSignupDTO)).thenReturn(user);
        when(userDAO.save(user)).thenReturn(true);

        boolean signupResult = userService.signup(userSignupDTO);

        assertTrue(signupResult);
    }

}