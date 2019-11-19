package com.shopping.product;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	String id;
	
	String name;
	
	double price;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

//	public OrderDetails getOrderDetails() {
//		return orderDetails;
//	}
//
//	public void setOrderDetails(OrderDetails orderDetails) {
//		this.orderDetails = orderDetails;
//	}

}
