package com.bookStore.controller;

import com.bookStore.entity.UserCreate;
import com.bookStore.service.UserCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserCreateController {

    @Autowired
    private UserCreateService userCreateService;

    // Display the registration form
    @GetMapping("/createuser")
    public String showloginForm(Model model) {
        model.addAttribute("user", new UserCreate());  // Create a new empty User object
        return "createuser";  // The name of your HTML form
    }

    // Handle form submission and register user
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserCreate user, Model model) {
        // Assuming validation passes, register the user in the database D:\LitLend\.git\index.lock

        userCreateService.registerUser(user.getUsername(), user.getEmail(), user.getPassword());
        return "redirect:/userlogin"; // Redirect to login page or a success page
    }
}

