package org.onliner.spring.c51.controller;

import org.onliner.spring.c51.exception.BusinessEntityAlreadyExistsException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    private static final String PATH_ERROR_TEMPLATE = "error/error-page";
    private static final String ATTRIBUTE_ERROR = "error";

    @ExceptionHandler(BusinessEntityAlreadyExistsException.class)
    public String businessEntityAlreadyExistsException(BusinessEntityAlreadyExistsException exception, Model model) {
        model.addAttribute(ATTRIBUTE_ERROR, exception.getMessage());
        return PATH_ERROR_TEMPLATE;
    }
}
