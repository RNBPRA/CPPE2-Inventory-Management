package com.inventory.repository;

//This interface represents a repository for managing inventory items.
import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.entity.InventoryItem;

public interface InventoryRepository extends JpaRepository<InventoryItem, Long>{

}
