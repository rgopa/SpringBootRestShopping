package com.shopping.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/customer")
	public List<Customer> getCustomer() {
		return customerService.getAllCustomers();
	}
	
	@RequestMapping("/customer/{customerId}")
	public Optional<Customer> getCustomer(@PathVariable("customerId") String customerId) {
		return customerService.getCustomer(customerId);
	}
	
	@PostMapping("/customer")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}

}
