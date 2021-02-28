package com.simplilearn.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.dto.OrderResponse;
import com.simplilearn.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query("SELECT new com.simplilearn.dto.OrderResponse(c.name, p.productName) FROM Customer c JOIN c.products p")
	public List<OrderResponse> getJoinInfo();
}