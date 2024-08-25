package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventory.entity.User;

//It is used to interact with the User entity in the database.
public interface UserRepository extends JpaRepository<User, Long>{
   

	// The findByUsername method is a custom query method that retrieves a User entity based on the provided username.
	User findByUsername(String username);
}
