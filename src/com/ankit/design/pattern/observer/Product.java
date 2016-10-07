package com.ankit.design.pattern.observer;

public class Product {
	
	private int productId;
	

	public Product(int productId) {
		super();
		this.productId = productId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}
