package com.bookStore.controller;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.entity.UserCreate;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;
import com.bookStore.service.UserCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;
@Controller
public class UserCreateController {
    @Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookService;
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
    @PostMapping("/userlogin")
    public String loginUser(String username, String password, Model model) {
        // Call the service to authenticate the user
        boolean isAuthenticated = userCreateService.authenticateUser(username, password);

        if (isAuthenticated) {
            return "redirect:/userdashboard";  // Redirect to dashboard or home page if authentication is successful
        } else {
            model.addAttribute("error", "Invalid username or password");  // Show error message
            return "userlogin";  // Stay on login page if authentication fails
        }
    }
    
    
    @GetMapping("/userdashboard")
    public String userdashboard() {
        return "userdashboard"; // stafflogin.html
    }
	@GetMapping("/staffdashboard")
    public String staffdashboard() {
        return "staffdashboard"; // stafflogin.html
    }
}

