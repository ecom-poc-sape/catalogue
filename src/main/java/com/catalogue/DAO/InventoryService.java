package com.catalogue.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.catalogue.model.ConstantItems;
import com.catalogue.model.Product;

@Component
public class InventoryService {

	public InventoryService() {
		
		}
	@Autowired
	private RestTemplate restTemplate;
		public List<Product> getAllProducts(){
			 return ConstantItems.products;
			}
			 
			public Product getProductById(String id){
				List<Product> productLists=new ArrayList();
				productLists=ConstantItems.products;
			    Iterator<Product> iterator=productLists.iterator();
			    while(iterator.hasNext()) {
			    	Product product=iterator.next();
			    	if(product.getId().equalsIgnoreCase(id)) {
			    		return product;
			    	}
			    }
			    return null;
			}
			public Product getProductByName(String name){
				List<Product> productLists=new ArrayList();
				productLists=ConstantItems.products;
			    Iterator<Product> iterator=productLists.iterator();
			    while(iterator.hasNext()) {
			    	Product product=iterator.next();
			    	if(product.getName().equalsIgnoreCase(name)) {
			    		return product;
			    	}
			    }
			    return null;
			}
}
