package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.dto.OrderRequest;
import com.simplilearn.dto.OrderResponse;
import com.simplilearn.entity.Customer;
import com.simplilearn.repository.CustomerRepository;
import com.simplilearn.repository.ProductRepository;

@RestController
public class OrderController {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	@PostMapping("placeOrder")
	public Customer placeOrder(@RequestBody OrderRequest request) {
		return customerRepository.save(request.getCustomer());
	}

	@GetMapping("findAllOrders")
	public List<Customer> findAllOrders() {
		return customerRepository.findAll();
	}

	@GetMapping("findOrderById/{id}")
	public Customer findOrderById(@PathVariable int id) {
		return customerRepository.findById(id).get();
	}

	@GetMapping("getInfo")
	public List<OrderResponse> joinInfo() {
		return customerRepository.getJoinInfo();
	}

}

//customer name & product name