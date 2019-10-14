package com.catalogue.model;

import java.util.ArrayList;
import java.util.List;

public class ConstantItems {

    public static List<Item> items=new ArrayList(); 
	static {
		items.add(new Item(1,"Book","Data Structure"));
		items.add(new Item(2,"Laptop","Lenevo TouchPad"));
		items.add(new Item(3,"Mobile","Redmi Note 5 Pro"));
	}
}
