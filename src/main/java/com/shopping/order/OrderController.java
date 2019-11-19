package com.shopping.order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.customer.CustomerService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/order/{date}")
	public List<OrderSummaryDTO> orders(@PathVariable String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateObj = null;
		try {
			dateObj = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return orderService.getOrdersByDate(dateObj);
	}
	
	@RequestMapping("/order")
	public List<OrderDetails> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@RequestMapping("/customer/{customerId}/order")
	public List<OrderDetails> getOrderDetailsByCustomer(@PathVariable String customerId){
		return orderService.getOrderDetailsByCustomer(customerId);
	}
	
	@RequestMapping("/order/txnsummary")
	public Double getTransactionsByDate(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date start = null;
		Date end = null;
			try {
				start = sdf.parse(startDate);
				end = sdf.parse(endDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		return orderService.getTransactionsByDate(start,end);
	}
	
	@PostMapping("order")
	public void addOrderDetails(@RequestBody OrderDetails orderDetails) {
		
		orderService.addOrders(orderDetails);
	}
	

}
