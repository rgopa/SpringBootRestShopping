package com.test.onlineShopping;

import org.junit.Test;
import org.springframework.boot.test.context.TestComponent;

import com.shopping.customer.Customer;

@TestComponent
public class TestCase {

	
	@Test
	public void addCustomer() {
		Customer customer = new Customer();
		customer.setName("ABC");
		customer.setId("1");
		
		
	}
}
