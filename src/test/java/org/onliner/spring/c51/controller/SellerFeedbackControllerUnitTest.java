package org.onliner.spring.c51.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.onliner.spring.c51.configuration.WebConfiguration;
import org.onliner.spring.c51.dto.user.UserSignupDTO;
import org.onliner.spring.c51.dtoconverter.UserDTOConverter;
import org.onliner.spring.c51.entity.Seller;
import org.onliner.spring.c51.entity.User;
import org.onliner.spring.c51.service.SellerFeedbackService;
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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebConfiguration.class)
@WebAppConfiguration
class SellerFeedbackControllerUnitTest {
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @Mock
    private SellerFeedbackService sellerFeedbackService;


    @Autowired
    public SellerFeedbackControllerUnitTest(WebApplicationContext webApplicationContext) {
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
        assertNotNull(webApplicationContext.getBean("sellerFeedbackController"));
    }

    @Test
    void controllerSendsSignupTemplateToRequestBySignupURL() throws Exception {
        mockMvc.perform(get("/seller-feedback/save"))
                .andDo(print())
                .andExpectAll(
                        view().name("seller-feedback/save")
                );
    }

    /**
     * should check the user attribute class
     * compare @ModelAttribute("__") with th:object="${__}"
     * @throws Exception
     */
    @Test
    void saveControllerSendsModelContainingAttributeUserAndSeller() throws Exception {
        mockMvc.perform(get("seller-feedback/save"))
                .andDo(print())
                .andExpectAll(
                        model().attributeExists("user"),
                        model().attributeExists("seller"),
                        model().attributeExists("sellerFeedback")
                );
    }

    @Test
    void saveControllerGetModelContainingAttributeSellerFeedback() throws Exception {
        mockMvc.perform(post("/user/signup"))
                .andDo(print())
                .andExpectAll(
                        model().attributeExists("user"),
                        model().attributeExists("seller"),
                        model().attributeExists("sellerFeedback")
                );
    }

    @Test
    void historyControllerSendsModelContainingAttributeSellerFeedbackList() throws Exception {
        mockMvc.perform(get("seller-feedback/history"))
                .andDo(print())
                .andExpectAll(
                        model().attributeExists("seller"),
                        model().attributeExists("sellerFeedbackList")
                );
    }

}