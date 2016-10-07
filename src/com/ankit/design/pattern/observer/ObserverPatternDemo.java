package com.ankit.design.pattern.observer;

public class ObserverPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Product p1=new Product(1);
		Product p2=new Product(2);
		Product p3=new Product(3);
		Product p4=new Product(4);
		
		
		
		Warehouse wh = new Warehouse();
		wh.addProduct(p1);
		//System.out.println("Added p1");
		wh.addProduct(p2);
		User u1 = new User(1, wh);
		u1.subscribeProduct(p3);
		u1.subscribeProduct(p4);
		
		User u2 = new User(2, wh);
		u2.subscribeProduct(p4);
		
		wh.addProduct(p3);
		wh.addProduct(p4);
		
		
		
	}

}
