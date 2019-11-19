package com.shopping.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	//List<Product> list = new ArrayList<>();
	
	@Autowired
	ProductRepository productRepository;
	
	public Optional<Product> getProduct(String productId){
		//return list.stream().filter(p -> p.getId().equalsIgnoreCase(productId)).findFirst().get();
		
		return productRepository.findById(productId);
	}
	
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<>();
		
		productRepository.findAll().forEach(products::add);
		return products;
		
	}
	
	public void addProduct(Product product){
		productRepository.save(product);
	}

}
