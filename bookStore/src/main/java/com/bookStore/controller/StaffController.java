package com.bookStore.controller;

import com.bookStore.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StaffController {

    @Autowired
    private LoginService loginService;

    /**
     * Handles login requests and validates user credentials.
     *
     * @param username the username entered by the user
     * @param password the password entered by the user
     * @param model    the model to add attributes for the view
     * @return the name of the view to be rendered
     */
    @PostMapping("/stafflogin")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if (loginService.validateLogin(username, password)) {
            return "staffdashboard"; // Redirect to user dashboard on successful login
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "stafflogin"; // Redirect back to login page with error
        }
    }
}
