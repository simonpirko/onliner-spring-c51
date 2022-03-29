package org.onliner.spring.c51.controller;

import org.onliner.spring.c51.entity.User;
import org.onliner.spring.c51.service.RoleService;
import org.onliner.spring.c51.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.onliner.spring.c51.controller.UserController.ATTRIBUTE_USER;

@Controller
@RequestMapping("/admin")
public class AdminController {
    public static final String PATH_ADMIN_PANEL_TEMPLATE = "admin/admin-panel";
    public static final String PATH_ROLE_MANAGEMENT_TEMPLATE = "admin/role-management";
    public static final String PATH_ROLE_ASSIGNMENT_TEMPLATE = "admin/role-assignment";
    public static final String REDIRECT_TO_ROLE_ASSIGNMENT_PAGE_URL = "redirect:/admin/role-management/role-assignment";

    public static final String ATTRIBUTE_ROLES = "roles";
    public static final String ERROR_USER_WITH_EMAIL_NOT_EXIST = "User with this email does not exist!";
    public static final String OBJECT_ERROR_GLOBAL = "global";
    public final UserService userService;
    public final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getAdminPanelTemplate() {
        return PATH_ADMIN_PANEL_TEMPLATE;
    }

    @GetMapping("/role-management")
    public String getRoleManagementTemplate() {
        return PATH_ROLE_MANAGEMENT_TEMPLATE;
    }

    @GetMapping("/role-management/role-assignment")
    public String getRoleAssignmentTemplate(@ModelAttribute(ATTRIBUTE_USER) User user, Model model) {
        model.addAttribute(ATTRIBUTE_ROLES, roleService.findAll());
        return PATH_ROLE_ASSIGNMENT_TEMPLATE;
    }

    @PostMapping("/role-management/role-assignment")
    public String assignRoleToUser(@ModelAttribute(ATTRIBUTE_USER) User user, BindingResult bindingResult, Model model) {
        model.addAttribute(ATTRIBUTE_ROLES, roleService.findAll());
        Optional<User> foundUser = userService.findByEmailWithRole(user.getEmail());
        if (!bindingResult.hasErrors()) {
            if (foundUser.isPresent()) {
                userService.assignRolesToUser(foundUser.get(), user.getRoles());
            } else {
                bindingResult.addError(new ObjectError(OBJECT_ERROR_GLOBAL, ERROR_USER_WITH_EMAIL_NOT_EXIST));
            }
        }
        return PATH_ROLE_ASSIGNMENT_TEMPLATE;
    }
}
