package com.catalogue.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogue.DAO.CartService;
import com.catalogue.DAO.InventoryService;
import com.catalogue.model.Item;

@RestController
@RequestMapping("/catalogue")
public class CatalogueRestController {

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private CartService cartService;

	@GetMapping("/items")
	public ResponseEntity<List<Item>> getAllItems() {
		List<Item> list = inventoryService.getAllItems();
		return (list == null || list.size() == 0) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(list);
	}

	@GetMapping("/items/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable int id) {
		Item item = inventoryService.getItemById(id);
		return item == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(item);
	}

	@GetMapping("/itemByName/{name}")
	public ResponseEntity<Item> getItemByName(@PathVariable String name) {
		Item item = inventoryService.getItemByName(name);
		return item == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(item);
	}

	@PostMapping("/cart/addItemToCart")
	public void addToCart(@RequestBody Item item) {
		boolean status = cartService.addToCart(item);

	}
}
