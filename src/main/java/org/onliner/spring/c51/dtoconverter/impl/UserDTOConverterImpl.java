package org.onliner.spring.c51.dtoconverter.impl;

import org.onliner.spring.c51.dto.user.UserSignupDTO;
import org.onliner.spring.c51.dtoconverter.UserDTOConverter;
import org.onliner.spring.c51.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverterImpl implements UserDTOConverter {

    @Override
    public UserSignupDTO convertToUserSignupDTOFromUser(User user) {
        UserSignupDTO userSignupDTO = new UserSignupDTO();
        userSignupDTO.setFirstName(user.getFirstName());
        userSignupDTO.setLastName(user.getLastName());
        userSignupDTO.setUsername(user.getUsername());
        userSignupDTO.setEmail(user.getEmail());
        userSignupDTO.setPassword(user.getPassword());
        return userSignupDTO;
    }

    @Override
    public User convertToUserFromUserSignupDTO(UserSignupDTO userSignupDTO) {
        return User.builder()
                .firstName(userSignupDTO.getFirstName())
                .lastName(userSignupDTO.getLastName())
                .username(userSignupDTO.getUsername())
                .email(userSignupDTO.getEmail())
                .password(userSignupDTO.getPassword())
                .build();
    }
}
