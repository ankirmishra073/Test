package com.ankit.design.pattern.observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

	
	private int userId;
	
	private Set<Product> products=new HashSet<Product>(); 
	
	public User(int userId,Warehouse warehouse) {
		super();
		this.userId = userId;
		warehouse.addUserToWareHouse(this);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public Set<Product> getproducts(){
		return products;
	}
	public void subscribeProduct(Product product){
		if(products.isEmpty()){
			products=new HashSet<Product>();
		}
		products.add(product);
	}
	
	public void Alert(Product product){
		System.out.println( product.getProductId()+"Product is available for you Mr:"+userId);
	}
	
}
