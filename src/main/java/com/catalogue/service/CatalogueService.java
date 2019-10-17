package com.catalogue.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sapient.ecomm_commons.domain.Product;

@Component
public class CatalogueService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public CatalogueService() {

	}

	@Value("${inventory.uri}")
	private String inventoryURI;

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getDefaultProducts")
	public List<Product> getAllProducts() {
		System.out.println("Inventory URI::::" + inventoryURI);
		List<Product> products = (List<Product>) restTemplate.getForObject(inventoryURI, List.class);
		return products;
	}

	public List<Product> getDefaultProducts() {

		logger.error("inventory-service is not reachable, returning default products.");

		List<Product> products = new ArrayList<>();

		products.add(new Product("Book", 35D, "Default product"));
		products.add(new Product("Bag", 440D, "Default product"));
		products.add(new Product("Phone", 17000D, "Default product"));
		return products;
	}

	public Product getProductById(String id) {
		List<Product> productLists = new ArrayList<Product>();
		// Request Inventory to fetch by Id below
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
		// Request Inventory to fetch by Name below
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
