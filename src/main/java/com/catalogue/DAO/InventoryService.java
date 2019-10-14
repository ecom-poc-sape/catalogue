package com.catalogue.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.catalogue.model.ConstantItems;
import com.catalogue.model.Item;

@Component
public class InventoryService {

	public InventoryService() {
		
		}
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Item> getAllItems(){
		 return ConstantItems.items;
		}
		 
		public Item getItemById(int id){
			List<Item> itemLists=new ArrayList();
			itemLists=ConstantItems.items;
		    Iterator<Item> iterator=itemLists.iterator();
		    while(iterator.hasNext()) {
		    	Item item=iterator.next();
		    	if(item.getItemId()==id) {
		    		return item;
		    	}
		    }
		    return null;
		}
		public Item getItemByName(String name){
			List<Item> itemLists=new ArrayList();
			itemLists=ConstantItems.items;
		    Iterator<Item> iterator=itemLists.iterator();
		    while(iterator.hasNext()) {
		    	Item item=iterator.next();
		    	if(item.getItemName().equalsIgnoreCase(name)) {
		    		return item;
		    	}
		    }
		    return null;
		}
}
