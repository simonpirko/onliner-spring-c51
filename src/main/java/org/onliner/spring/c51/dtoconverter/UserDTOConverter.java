package org.onliner.spring.c51.dtoconverter;

import org.onliner.spring.c51.dto.user.AuthenticatedUserDTO;
import org.onliner.spring.c51.dto.user.UserSignupDTO;
import org.onliner.spring.c51.entity.User;

import java.util.HashSet;

public class UserDTOConverter {

    // ONL-12 : lombok
    public static UserSignupDTO convertToUserSignupDTOFromUser(User user) {
        return UserSignupDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static User convertToUserFromUserSignupDTO(UserSignupDTO userSignupDTO) {
        return User.builder()
                .firstName(userSignupDTO.getFirstName())
                .lastName(userSignupDTO.getLastName())
                .username(userSignupDTO.getUsername())
                .email(userSignupDTO.getEmail())
                .password(userSignupDTO.getPassword())
                .roles(new HashSet<>())
                .build();
    }


    public static AuthenticatedUserDTO convertToAuthenticatedUserDTOFromUser(User user) {
        AuthenticatedUserDTO authenticatedUserDTO = new AuthenticatedUserDTO();
        authenticatedUserDTO.setId(user.getId());
        authenticatedUserDTO.setRoles(user.getRoles());
        return authenticatedUserDTO;
    }
}
