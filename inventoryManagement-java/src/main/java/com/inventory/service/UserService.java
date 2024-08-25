package com.inventory.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventory.entity.User;
import com.inventory.repository.UserRepository;

//This UserService class is responsible for handling user-related operations.
//It uses the UserRepository to interact with the database.

@Service // Indicates that this class is a service component in the application.
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //validate a user based on their username and password.
    public boolean validateUser(String username, String password) {
    	// Fetch the user from the database using the username.
    	User user = userRepository.findByUsername(username);
        
        // Check if the user exists and if the password matches.
        return user != null && user.getPassword().equals(password);
    }
}