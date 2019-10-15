package com.catalogue.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.catalogue.model.ConstantItems;
import com.catalogue.model.Product;
import com.catalogue.model.Products;

@Component
public class InventoryService {

	public InventoryService() {

	}

	@Value("${inventory.uri}")
	private String inventoryURI;

	@Autowired
	private RestTemplate restTemplate;

	public List<Product> getAllProducts() {
		System.out.println("Inventory URI::::"+inventoryURI);
		Products products = restTemplate.getForObject(inventoryURI, Products.class);
		if (products!=null && products.getList() != null && products.getList().size() > 0) {
			return products.getList();
		}
		return null;
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
