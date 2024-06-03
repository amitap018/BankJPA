package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Customer;
import com.example.repo.CustomerRepository;
import com.example.service.CustomerService;

@RestController
@RequestMapping("/bank")
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	CustomerRepository cr;
	@Autowired
	CustomerService cs;

	@Autowired
	RestTemplate rs;

	@GetMapping("/read")
	public List<Customer> read() {
		return cs.read();
	}

	@GetMapping("/readone/{id}")
	public Customer readOne(@PathVariable int id) {
		return cs.readOne(id);
	}

	// add
	@PostMapping("/add")
	public Customer add(@RequestBody Customer customer) {
		return cs.add(customer);
	}

	// update
	@PutMapping("/update/{id}")
	public void update(@PathVariable int id, @RequestBody Customer newCustomer) {
		cs.update(id, newCustomer);
	}

	// delete
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		cs.delete(id);
	}

//	@GetMapping("/checkBalance/{id}")
//	public int bankMethod(@PathVariable int id) {
//		int customerResponse = rs.getForObject("http://localhost:8889/customer/checkBalance/" + id, Integer.class);
//		return customerResponse;
//	}
//
//	@PutMapping("/deposit/{id}/{amount}")
//	public void bankDeposit(@PathVariable int id,@PathVariable int amount) {
//		rs.put("http://localhost:8889/customer/deposit/" + id + "/"+ amount, Integer.class);
//		
//	}
//	
//	@PutMapping("/moneyTransfer/{id}/{amount}/{receiverId}")
//	public void bankMoneyTransfer(@PathVariable int id, @PathVariable int amount,
//			@PathVariable int receiverId) {
//		rs.put("http://localhost:8889/customer/moneyTransfer/" + id + "/"+ amount+ "/"+receiverId, Integer.class);
//		
//	}
}
