package com.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.InventoryItem;
import com.inventory.repository.InventoryRepository;

import java.util.List;
import java.util.Optional;
//It uses the InventoryRepository to interact with the database.

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    
    // Method to create a new inventory item.
    public InventoryItem createItem(InventoryItem item) {
        return inventoryRepository.save(item);
    }
    // Method to retrieve all inventory items.
    public List<InventoryItem> getAllItems() {
        return inventoryRepository.findAll();
    }

 // Method to retrieve an inventory item by its ID.
    public Optional<InventoryItem> getItemById(Long id) {
        return inventoryRepository.findById(id);
    }

    // Method to update an existing inventory item.
    public InventoryItem updateItem(Long id, InventoryItem item) {
        if (inventoryRepository.existsById(id)) {
            item.setId(id);
            return inventoryRepository.save(item);
        }
        return null;// Return null if the item does not exist.
    }
    // Method to delete an inventory item by its ID.
    public void deleteItem(Long id) {
        inventoryRepository.deleteById(id);
    }
}
