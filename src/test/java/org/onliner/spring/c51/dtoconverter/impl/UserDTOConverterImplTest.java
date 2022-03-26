package org.onliner.spring.c51.dtoconverter.impl;

import org.junit.jupiter.api.Test;
import org.onliner.spring.c51.dto.user.UserSignupDTO;
import org.onliner.spring.c51.dtoconverter.UserDTOConverter;
import org.onliner.spring.c51.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserDTOConverterImplTest {

    @Test
    void convertToUserSignupDTOFromUser() {
        String list[] = {"Serj","Kuchuk","Papaslip1212","skp@.gmail.com","123qwe"};
        User user = new User();
        user.setFirstName(list[0]);
        user.setLastName(list[1]);
        user.setUsername(list[2]);
        user.setEmail(list[3]);
        user.setPassword(list[4]);
        UserSignupDTO userSignupDTO = new UserSignupDTO();
        userSignupDTO.setFirstName(list[0]);
        userSignupDTO.setLastName(list[1]);
        userSignupDTO.setUsername(list[2]);
        userSignupDTO.setEmail(list[3]);
        userSignupDTO.setPassword(list[4]);
        assertTrue(userSignupDTO.equals(UserDTOConverter.convertToUserSignupDTOFromUser(user)));
    }

    @Test
    void convertToUserFromUserSignupDTO() {
        String list[] = {"Serj","Kuchuk","Papaslip1212","skp@.gmail.com","123qwe"};
        User user = new User();
        user.setFirstName(list[0]);
        user.setLastName(list[1]);
        user.setUsername(list[2]);
        user.setEmail(list[3]);
        user.setPassword(list[4]);
        UserSignupDTO userSignupDTO = new UserSignupDTO();
        userSignupDTO.setFirstName(list[0]);
        userSignupDTO.setLastName(list[1]);
        userSignupDTO.setUsername(list[2]);
        userSignupDTO.setEmail(list[3]);
        userSignupDTO.setPassword(list[4]);
        assertTrue(user.equals(UserDTOConverter.convertToUserFromUserSignupDTO(userSignupDTO)));
    }
}