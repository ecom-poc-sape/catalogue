package com.catalogue.model;

public class Item {

	private int itemId;
	private String itemName;
	private String itemDescription;
	
	public Item() {
	}

	public Item(int itemId, String itemName, String itemDescription) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemDescription=" + itemDescription + "]";
	}
	
}
