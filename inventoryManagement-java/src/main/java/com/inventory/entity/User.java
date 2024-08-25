package com.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//It is annotated with @Entity to indicate that it is a JPA entity.
//The table name for this entity is "inventory" and is specified using @Table annotation.

@Entity
@Table(name = "users")
public class User {

	
	  // The 'id' field is annotated with @Id to indicate that it is the primary key.
    // @GeneratedValue(strategy = GenerationType.IDENTITY) specifies that the database will generate the unique id for each new entity.
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
 // 'username' field is annotated with @Column(unique = true, nullable = false) to enforce uniqueness and non-nullability
    @Column(unique = true, nullable = false)
    private String username;


 // 'password' field is annotated with @Column(nullable = false) to enforce non-nullability.
    @Column(nullable = false)
    private String password;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
