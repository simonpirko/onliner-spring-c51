package org.onliner.spring.c51.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.onliner.spring.c51.controller.UserController.ATTRIBUTE_AUTHENTICATED_USER;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    public static final String URL_LOGIN_PAGE = "/user/login";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute(ATTRIBUTE_AUTHENTICATED_USER) != null) {
            return true;
        } else {
            response.sendRedirect(URL_LOGIN_PAGE);
            return false;
        }
    }
}
