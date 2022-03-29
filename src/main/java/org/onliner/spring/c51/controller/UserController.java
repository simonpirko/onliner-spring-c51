package org.onliner.spring.c51.controller;

import org.onliner.spring.c51.dto.user.AuthenticatedUserDTO;
import org.onliner.spring.c51.dto.user.UserLoginDTO;
import org.onliner.spring.c51.dto.user.UserSignupDTO;
import org.onliner.spring.c51.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

import static org.onliner.spring.c51.controller.SellerController.REDIRECT_TO_HOME_PAGE_URL;

@Controller
@RequestMapping("/user")
public class UserController {
    public static final String PATH_SIGNUP_TEMPLATE = "user/signup";
    public static final String PATH_LOGIN_TEMPLATE = "user/login";
    public static final String ATTRIBUTE_USER = "user";
    public static final String REDIRECT_TO_LOGIN_PAGE_URL = "redirect:/user/login";
    public static final String ATTRIBUTE_AUTHENTICATED_USER = "authenticatedUser";
    public static final String ERROR_USER_NOT_EXIST = "User with this username or password doesn't exist!";
    public static final String OBJECT_ERROR_NAME = "globalError";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String getSignupTemplate(@ModelAttribute(ATTRIBUTE_USER) UserSignupDTO userSignupDTO) {
        return PATH_SIGNUP_TEMPLATE;
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute(ATTRIBUTE_USER) @Valid UserSignupDTO userSignupDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return PATH_SIGNUP_TEMPLATE;
        } else {
            if (userService.signup(userSignupDTO)) {
                return REDIRECT_TO_LOGIN_PAGE_URL;
            } else {
                return PATH_SIGNUP_TEMPLATE;
            }
        }
    }

    @GetMapping("/login")
    public String getLoginTemplate(@ModelAttribute(ATTRIBUTE_USER) UserLoginDTO user) {
        return PATH_LOGIN_TEMPLATE;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute(ATTRIBUTE_USER) @Valid UserLoginDTO userLoginDTO, BindingResult bindingResult,
                        HttpSession session) {
        if (bindingResult.hasErrors()) {
            return PATH_LOGIN_TEMPLATE;
        } else {
            Optional<AuthenticatedUserDTO> authenticatedUser = userService.authenticate(userLoginDTO);
            if (userService.authenticate(userLoginDTO).isPresent()) {
                session.setAttribute(ATTRIBUTE_AUTHENTICATED_USER, authenticatedUser.get());
                return REDIRECT_TO_HOME_PAGE_URL;
            } else {
                bindingResult.addError(new ObjectError(OBJECT_ERROR_NAME, ERROR_USER_NOT_EXIST));
                return PATH_LOGIN_TEMPLATE;
            }
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return REDIRECT_TO_HOME_PAGE_URL;
    }
}
