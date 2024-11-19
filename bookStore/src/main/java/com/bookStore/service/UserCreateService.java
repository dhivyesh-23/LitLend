package com.bookStore.service;

import com.bookStore.entity.UserCreate;
import com.bookStore.repository.UserCreateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCreateService {

    @Autowired
    private UserCreateRepository userCreateRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void registerUser(String username, String email, String password) {
        // Hash the password before saving
        String hashedPassword = passwordEncoder.encode(password);

        // Create a new UserCreate object and save to DB
        UserCreate user = new UserCreate();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(hashedPassword);

        userCreateRepository.save(user);
    }
}
