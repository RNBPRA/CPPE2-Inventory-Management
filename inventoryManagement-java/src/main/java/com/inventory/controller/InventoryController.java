package com.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.inventory.entity.InventoryItem;
import com.inventory.service.InventoryService;

import java.util.List;

//This class is a REST controller for managing inventory items.
//It is annotated with @RestController to indicate that it will handle HTTP requests and return responses in the form of JSON.



@RestController
//@CrossOrigin("http://localhost:3000/") allows cross-origin requests from the specified URL.
@CrossOrigin("http://localhost:3000/")

//@RequestMapping("/api/inventory") maps the controller to the "/api/inventory" endpoint.
@RequestMapping("/api/inventory")

public class InventoryController {
	
	// Autowire the InventoryService to access its methods.
    @Autowired
    private InventoryService inventoryService;

    // POST request to create a new inventory item.
    @PostMapping("/add")
    public InventoryItem createItem(@RequestBody InventoryItem item) {
        return inventoryService.createItem(item);
    }
    
    // GET request to retrieve all inventory items.
    @GetMapping
    public List<InventoryItem> getAllItems() {
        return inventoryService.getAllItems();
    }
    
    // GET request to retrieve a specific inventory item by its ID.
    @GetMapping("/get/{id}")
    public ResponseEntity<InventoryItem> getItemById(@PathVariable Long id) {
        return inventoryService.getItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // PUT request to update an existing inventory item.
    @PutMapping("/update/{id}")
    public ResponseEntity<InventoryItem> updateItem(@PathVariable Long id, @RequestBody InventoryItem item) {
        InventoryItem updatedItem = inventoryService.updateItem(id, item);
        return updatedItem != null ? ResponseEntity.ok(updatedItem) : ResponseEntity.notFound().build();
    }
    
 // DELETE request to delete an inventory item by its ID.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        inventoryService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}