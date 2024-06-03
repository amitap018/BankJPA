package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.repo.CustomerRepository;

import jakarta.transaction.Transactional;

@RestController
public class CustomerService {
	@Autowired
	CustomerRepository tm;

	@Autowired
	//CustomRepository custRepo;

	public List<Customer> read() {
		return tm.findAll();
	}

	public Customer readOne(@PathVariable int id) {
		return tm.findById(id).orElse(null);
	}

	public Customer add(@RequestBody Customer customer) {
		return tm.save(customer);
	}

	public void update(@PathVariable int id, @RequestBody Customer newCustomer) {
		Optional<Customer> oldCustomer = tm.findById(id);
		oldCustomer.get().setName(newCustomer.getName());
		oldCustomer.get().setUsername(newCustomer.getUsername());
		//oldCustomer.get().setPass(newCustomer.getPass());
		oldCustomer.get().setEmail(newCustomer.getEmail());
		oldCustomer.get().setPhone(newCustomer.getPhone());
		oldCustomer.get().setBalance(newCustomer.getBalance());
		tm.save(oldCustomer.get());

	}

	public void delete(@PathVariable int id) {
		tm.deleteById(id);
	}


	

}
