package com.ankit.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

	private List<Product> products=new ArrayList<Product>();
	
	private List<User> users=new ArrayList<User>();
	
	public void addUserToWareHouse(User user){
		
		users.add(user);
	}
	
	public void addProduct(Product product){
		
		products.add(product);
		notifyAllUsers(product);
	}
	
	public void notifyAllUsers(Product product){
		
		users.forEach(user ->{
			
			if(user.getproducts().contains(product)){
				user.Alert(product);
			}
			
			
		});
		
	}
	public List<Product> getProducts(){
		return products;
	}
}
