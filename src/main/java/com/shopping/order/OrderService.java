package com.shopping.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.customer.CustomerRepository;
import com.shopping.product.Product;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	public List<OrderDetails> getOrderDetailsByCustomer(String customerId) {
		return orderRepository.findByCustomerId(customerId);
		
	}
	
	

	public List<OrderSummaryDTO> getOrdersByDate(Date date) {
		List<OrderDetails> custList = orderRepository.findByOrderedDate(new java.sql.Date(date.getTime()));
		List<OrderSummaryDTO> list = new ArrayList<>();
		for(OrderDetails ord: custList) {
			
			OrderSummaryDTO dto = new OrderSummaryDTO();
			dto.setCustomerName(ord.getCustomer().getName());
			dto.setOrderNumber(ord.getOrderId());
			
			list.add(dto);
		}
		return list;
	}
	
	public Double getTransactionsByDate(Date start, Date end) {
		List<OrderDetails> custList = orderRepository.findByOrderedDateBetween(
				new java.sql.Date(start.getTime()), new java.sql.Date(end.getTime()));
		//List<String> list = new ArrayList<String>();
		Double totalPrice = 0d;
		for(OrderDetails ord: custList) {
			
			for(Product prod: ord.getProducts()) {
				totalPrice += prod.getPrice();
			}
		}
		return totalPrice;
	}

	public void addOrders(OrderDetails orderDetails) {
		
//		Customer customer = customerRepository.findById(orderDetails.getCustomer().getId()).get();
//		customer.getOrderDetails().add(orderDetails);
//		customerRepository.save(customer);
		
		orderRepository.save(orderDetails);
	}



	public List<OrderDetails> getAllOrders() {
		List<OrderDetails> list = new ArrayList<OrderDetails>();
		orderRepository.findAll().forEach(list::add);
		return list;
	}

}
