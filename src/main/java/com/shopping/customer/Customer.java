package com.shopping.customer;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	String id;
	
	String name;
	
//	@OneToMany
//	List<OrderDetails> orderDetails;
//	
//	@OneToMany //check
//	List<Product> productList;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<OrderDetails> getOrderDetails() {
//		return orderDetails;
//	}
//
//	public void setOrderDetails(List<OrderDetails> orderDetails) {
//		this.orderDetails = orderDetails;
//	}
//
//	public List<Product> getProductList() {
//		return productList;
//	}
//
//	public void setProductList(List<Product> productList) {
//		this.productList = productList;
//	}


}
