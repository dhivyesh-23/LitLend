package com.bookStore.service;

import java.util.HashSet;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private static final HashSet<String> validCredentials = new HashSet<>();

    // Initialize the HashSet with usernames and passwords
    static {
        validCredentials.add("admin1:admin1"); // Example username:password pair
        validCredentials.add("admin2:admin2");
        validCredentials.add("admin3:admin3");
    }

    /**
     * Validates login credentials against the predefined HashSet.
     *
     * @param username the username entered by the user
     * @param password the password entered by the user
     * @return true if the credentials match, false otherwise
     */
    public boolean validateLogin(String username, String password) {
        String credential = username + ":" + password; // Combine username and password
        return validCredentials.contains(credential); // Check in the HashSet
    }
}
