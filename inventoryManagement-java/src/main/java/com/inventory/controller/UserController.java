package com.inventory.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.inventory.entity.User;
import com.inventory.service.UserService;

// This class is a REST controller for user authentication.
// It is annotated with @RestController to indicate that it will handle HTTP requests and return responses in the form of JSON.
// @CrossOrigin("http://localhost:3000/") allows cross-origin requests from the specified URL.



@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api/auth")
public class UserController {
	
	 // Autowire the UserService to access its methods.
	
    @Autowired
    private UserService userService;

    // POST request to handle user login.
    // The request body should contain a User object with username and password.
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
    	
    	   // Validate the user credentials using the UserService.
        boolean isValidUser = userService.validateUser(user.getUsername(), user.getPassword());
        
        // If the user is valid, return a success message.
        if (isValidUser) {
            return ResponseEntity.ok("Login successful! Redirecting to inventory management dashboard...");
        } 
        // If the user is not valid, return an unauthorized response with an error message.
        else {
            return ResponseEntity.status(401).body("Invalid UserID or Password");
        }
    }
}