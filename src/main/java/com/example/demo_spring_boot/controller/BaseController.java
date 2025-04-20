package com.example.demo_spring_boot.controller;

import com.example.demo_spring_boot.exception.FailedToRegisterUserException;
import com.example.demo_spring_boot.model.User;
import com.example.demo_spring_boot.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class BaseController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public BaseController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public ResponseEntity<String> getResponse() {
        return ResponseEntity.ok("Your are logged in.");
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return ResponseEntity.ok("User registered successfully.");
        } catch (Exception e) {
            throw new FailedToRegisterUserException(e.getMessage());
        }
    }

    @GetMapping("/account")
    public ResponseEntity<User> getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Failed to find user by given email."));
        return ResponseEntity.ok(user);
    }
}
