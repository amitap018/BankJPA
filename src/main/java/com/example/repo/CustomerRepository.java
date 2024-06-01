package com.example.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
}
