package com.example;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import com.example.controller.CustomerController;
import com.example.model.Customer;
import com.example.service.CustomerService;



public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        // Setup mock data or behavior if needed
    	 MockitoAnnotations.initMocks(this); // Initialize mocks
    }

    @Test
    public void testRead() {
        List<Customer> customers = new ArrayList<>();
        // Add some test data to customers list
        when(customerService.read()).thenReturn(customers);

        assertEquals(customers, customerController.read());
    }

    @Test
    public void testReadOne() {
        int id = 1;
        Customer customer = new Customer(150, "John Doe", "johndoe", "password123", "john@example.com", "1234567890", 1000);

        when(customerService.readOne(id)).thenReturn(customer);

        assertEquals(customer, customerController.readOne(id));
    }

    @Test
    public void testAdd() {
    	Customer customer = new Customer(150, "Jane Doe", "johndoe", "password123", "john@example.com", "1234567890", 1000);

        when(customerService.add(any(Customer.class))).thenReturn(customer);

        assertEquals(customer, customerController.add(customer));
    }

    @Test
    public void testUpdate() {
        int id = 150;
        Customer updatedCustomer = new Customer(150, "John Doe", "johndoe", "password123", "john@example.com", "1234567890", 1000);

        doNothing().when(customerService).update(id, updatedCustomer);

        customerController.update(id, updatedCustomer);

        verify(customerService, times(1)).update(id, updatedCustomer);
    }

    @Test
    public void testDelete() {
        int id = 1;

        doNothing().when(customerService).delete(id);

        customerController.delete(id);

        verify(customerService, times(1)).delete(id);
    }

    @Test
    public void testBankMethod() {
        int id = 1;
        int balance = 100; // Set expected balance

        when(restTemplate.getForObject(any(String.class), any())).thenReturn(balance);

        assertEquals(balance, customerController.bankMethod(id));
    }

    // Add similar tests for bankDeposit and bankMoneyTransfer methods
}
