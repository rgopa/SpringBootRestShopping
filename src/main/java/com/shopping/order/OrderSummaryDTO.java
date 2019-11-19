package com.shopping.order;

public class OrderSummaryDTO {
	
	String orderNumber;
	
	String customerName;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

//	public String getOrderValue() {
//		return orderValue;
//	}
//
//	public void setOrderValue(String orderValue) {
//		this.orderValue = orderValue;
//	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
