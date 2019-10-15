package com.catalogue.model;

import java.util.ArrayList;
import java.util.List;

import com.sapient.ecomm_commons.domain.Product;

public class Products {

	private List<Product> list=new ArrayList();

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}
	
}
