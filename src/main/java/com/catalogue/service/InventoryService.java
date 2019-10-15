package com.catalogue.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.catalogue.model.ConstantItems;
import com.catalogue.model.Products;
import com.sapient.ecomm_commons.domain.Product;

@Component
public class InventoryService {

	public InventoryService() {

	}

	@Value("${inventory.uri}")
	private String inventoryURI;

	@Autowired
	private RestTemplate restTemplate;

	public List<Product> getAllProducts() {
		System.out.println("Inventory URI::::" + inventoryURI);
		List<Product> products = (List<Product>) restTemplate.getForObject(inventoryURI, List.class);

		return products;
	}

	public Product getProductById(String id) {
		List<Product> productLists = new ArrayList<Product>();
		productLists = ConstantItems.products;
		Iterator<Product> iterator = productLists.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if (product.getId().equalsIgnoreCase(id)) {
				return product;
			}
		}
		return null;
	}

	public Product getProductByName(String name) {
		List<Product> productLists = new ArrayList<Product>();
		productLists = ConstantItems.products;
		Iterator<Product> iterator = productLists.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if (product.getName().equalsIgnoreCase(name)) {
				return product;
			}
		}
		return null;
	}
}
