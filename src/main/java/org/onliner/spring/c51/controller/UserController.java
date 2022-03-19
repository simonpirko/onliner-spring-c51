package org.onliner.spring.c51.controller;

import org.onliner.spring.c51.dto.user.UserLoginDTO;
import org.onliner.spring.c51.dto.user.UserSignupDTO;
import org.onliner.spring.c51.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    public static final String PATH_SIGNUP_TEMPLATE = "user/signup";
    public static final String PATH_LOGIN_TEMPLATE = "user/login";
    public static final String ATTRIBUTE_USER = "user";
    public static final String REDIRECT_TO_LOGIN_PAGE_URL = "redirect:/user/login";

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
}
