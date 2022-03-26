package org.onliner.spring.c51.dtoconverter;

import org.onliner.spring.c51.dto.user.AuthenticatedUserDTO;
import org.onliner.spring.c51.dto.user.UserSignupDTO;
import org.onliner.spring.c51.entity.User;

public class UserDTOConverter {

    public static UserSignupDTO convertToUserSignupDTOFromUser(User user) {
        UserSignupDTO userSignupDTO = new UserSignupDTO();
        userSignupDTO.setFirstName(user.getFirstName());
        userSignupDTO.setLastName(user.getLastName());
        userSignupDTO.setUsername(user.getUsername());
        userSignupDTO.setEmail(user.getEmail());
        userSignupDTO.setPassword(user.getPassword());
        return userSignupDTO;
    }

    public static User convertToUserFromUserSignupDTO(UserSignupDTO userSignupDTO) {
        return User.builder()
                .firstName(userSignupDTO.getFirstName())
                .lastName(userSignupDTO.getLastName())
                .username(userSignupDTO.getUsername())
                .email(userSignupDTO.getEmail())
                .password(userSignupDTO.getPassword())
                .build();
    }

    public static AuthenticatedUserDTO convertToAuthenticatedUserDTOFromUser(User user) {
        AuthenticatedUserDTO authenticatedUserDTO = new AuthenticatedUserDTO();
        authenticatedUserDTO.setId(user.getId());
        return authenticatedUserDTO;
    }
}
