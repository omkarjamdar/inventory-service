package com.ecommerce.inventory_service;

import com.ecommerce.inventory_service.model.Inventory;
import com.ecommerce.inventory_service.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);


	}
	@Transactional
	public CommandLineRunner loadData(InventoryRepository inventoryRepository)
	{
      return args -> {
		  Inventory inventory = new Inventory();
		  inventory.setSkuCode("iphone_13");
		  inventory.setQuantity(100);

		  Inventory inventory1 = new Inventory();
		  inventory1.setSkuCode("iphone_13_red");
		  inventory1.setQuantity(0);

		  inventoryRepository.save(inventory);
		  inventoryRepository.save(inventory1);

	  };
	}

}
