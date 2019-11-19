package com.shopping.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("hello");
		return "Hello";
	}

	@RequestMapping("/product")
	public List<Product> getAllProduct(){
		System.out.println("getAllProduct");
		return productService.getAllProducts();
	}
	
	@RequestMapping("/product/{productId}")
	public Optional<Product> getProduct(@PathVariable("productId") String productId){
		return productService.getProduct(productId);
	}

	@PostMapping("/product")
	public void addProduct(@RequestBody Product product){
		System.out.println("addProduct");
		 productService.addProduct(product);
	}
	
}
