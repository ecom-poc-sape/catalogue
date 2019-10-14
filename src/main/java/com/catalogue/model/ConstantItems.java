package com.catalogue.model;

import java.util.ArrayList;
import java.util.List;

public class ConstantItems {

	/*
    public static List<Item> items=new ArrayList(); 
	static {
		items.add(new Item(1,"Book","Data Structure"));
		items.add(new Item(2,"Laptop","Lenevo TouchPad"));
		items.add(new Item(3,"Mobile","Redmi Note 5 Pro"));
	}
	*/
    public static List<Product> products=new ArrayList(); 
	static {
		Product p1=new Product("Book",300.00,"Data Structure");
		Product p2=new Product("Laptop",45000.00,"Lenevo TouchPad");
		Product p3=new Product("Mobile",12000.00,"Redmi Note 5 Pro");
		p1.setId("1");
		p2.setId("2");
		p3.setId("3");
		products.add(p1);
		products.add(p2);
		products.add(p3);
	}
}
