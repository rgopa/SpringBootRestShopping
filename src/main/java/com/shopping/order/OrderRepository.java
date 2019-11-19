package com.shopping.order;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderDetails, String>{

	//public List<OrderDetails> findByOrderedDate(Date date);
	
	public List<OrderDetails> findByCustomerId(String customerId);
	
	@Query(value = "SELECT od FROM OrderDetails od WHERE od.orderedDate = :date")
	List<OrderDetails> findByOrderedDate(@Param("date") Date date);
	
	//@Query(value = "SELECT od FROM OrderDetails od WHERE BETWEEN od.orderedDate = :start AND od.orderedDate = :end")
	List<OrderDetails> findByOrderedDateBetween(Date start, Date end);
}
