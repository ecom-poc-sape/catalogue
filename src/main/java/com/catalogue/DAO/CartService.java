package com.catalogue.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.catalogue.model.Item;

@Component
public class CartService {

	public CartService() {
		
	}
	@Autowired
	private RestTemplate restTemplate;
	private String cartURI="";
	
	public boolean addToCart(Item item) {
		System.out.println("Adding the item to the cart...");
		Boolean status = restTemplate.postForObject(cartURI, item, Boolean.class);
		System.out.println("Item added to the cart?"+status);
		return status;
	}
}
