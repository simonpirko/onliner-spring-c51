package org.onliner.spring.c51.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.onliner.spring.c51.configuration.WebConfiguration;
import org.onliner.spring.c51.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebConfiguration.class)
@WebAppConfiguration
class UserControllerUnitTest {
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @Mock
    private UserService userService;

    @Autowired
    public UserControllerUnitTest(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void webApplicationContextIsAutowired() {
        assertNotNull(webApplicationContext);
    }

    @Test
    void webApplicationContextConfiguredToWorkWithMockServletContext() {
        ServletContext servletContext = webApplicationContext.getServletContext();
        assertNotNull(servletContext);
        assertTrue(servletContext instanceof MockServletContext);
    }

    @Test
    void webApplicationContextContainsUserController() {
        assertNotNull(webApplicationContext.getBean("userController"));
    }

    @Test
    void controllerSendsSignupTemplateToRequestBySignupURL() throws Exception {
        mockMvc.perform(get("/user/signup"))
                .andDo(print())
                .andExpectAll(
                        view().name("user/signup")
                );
    }

    /**
     * should check the user attribute class
     * compare @ModelAttribute("__") with th:object="${__}"
     * @throws Exception
     */
    @Test
    void signupControllerSendsModelContainingAttributeUser() throws Exception {
        mockMvc.perform(get("/user/signup"))
                .andDo(print())
                .andExpectAll(
                        model().attributeExists("user")
                );
    }

    @Test
    void signupControllerGetModelContainingAttributeUser() throws Exception {
        mockMvc.perform(post("/user/signup"))
                .andDo(print())
                .andExpectAll(
                        model().attributeExists("user")
                );
    }

}