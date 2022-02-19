package com.sanjay;

import java.io.Serializable;

public class Product implements Serializable {

	
	int ProductId;
	String Name;
	int Price;
	int Quantity;
	int Discount;
	
	
	public Product() {
		
	}
	
	
	public Product(int productId, String name, int price, int quantity, int discount) {
		ProductId = productId;
		Name = name;
		Price = price;
		Quantity = quantity;
		Discount = discount;
	}
	
	
	
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getDiscount() {
		return Discount;
	}
	public void setDiscount(int discount) {
		Discount = discount;
	}
	
	
}
