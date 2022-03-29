package org.onliner.spring.c51.configuration;

import org.onliner.spring.c51.interceptor.AdminRoleAuthorizationInterceptor;
import org.onliner.spring.c51.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("org.onliner.spring.c51")
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {
    private AuthenticationInterceptor authenticationInterceptor;
    private AdminRoleAuthorizationInterceptor adminRoleAuthorizationInterceptor;

    public WebConfiguration(AuthenticationInterceptor authenticationInterceptor, AdminRoleAuthorizationInterceptor adminRoleAuthorizationInterceptor) {
        this.authenticationInterceptor = authenticationInterceptor;
        this.adminRoleAuthorizationInterceptor = adminRoleAuthorizationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/user/**")
                    .excludePathPatterns("/user/signup", "/user/login", "/user/*")
                .addPathPatterns("/admin/**");

        registry.addInterceptor(adminRoleAuthorizationInterceptor)
                .addPathPatterns("/admin/**");
    }
}
