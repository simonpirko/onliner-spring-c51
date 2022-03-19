package org.onliner.spring.c51.dtoconverter;

import org.onliner.spring.c51.dto.user.UserSignupDTO;
import org.onliner.spring.c51.entity.User;

public interface UserDTOConverter {

    UserSignupDTO convertToUserSignupDTOFromUser(User user);

    User convertToUserFromUserSignupDTO(UserSignupDTO userSignupDTO);

}
