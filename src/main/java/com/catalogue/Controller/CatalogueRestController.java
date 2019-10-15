package com.catalogue.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogue.service.InventoryService;
import com.sapient.ecomm_commons.domain.Product;

@RestController
@RequestMapping("/catalogue")
public class CatalogueRestController {

	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> list = inventoryService.getAllProducts();
		return (list == null || list.size() == 0) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(list);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable String id) {
		Product product = inventoryService.getProductById(id);
		return product == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(product);
	}

	@GetMapping("/productByName/{name}")
	public ResponseEntity<Product> getProductByName(@PathVariable String name) {
		Product product = inventoryService.getProductByName(name);
		return product == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(product);
	}
}
