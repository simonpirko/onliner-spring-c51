package org.onliner.spring.c51.interceptor;

import org.onliner.spring.c51.dto.user.AuthenticatedUserDTO;
import org.onliner.spring.c51.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.onliner.spring.c51.controller.UserController.ATTRIBUTE_AUTHENTICATED_USER;
import static org.onliner.spring.c51.interceptor.AuthenticationInterceptor.URL_LOGIN_PAGE;

@Component
public class AdminRoleAuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AuthenticatedUserDTO authenticatedUser = (AuthenticatedUserDTO) request.getSession().getAttribute(ATTRIBUTE_AUTHENTICATED_USER);
        if (authenticatedUser != null && authenticatedUser.isAdmin()) {
            return true;
        } else {
            response.sendRedirect(URL_LOGIN_PAGE);
            return false;
        }
    }
}
