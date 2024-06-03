package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.model.Customer;

public class CustomerTest {

    @Test
    public void testCustomerConstructor() {
        Customer customer = new Customer(1, "John Doe", "johndoe", "password", "johndoe@example.com", "1234567890", 1000);
        assertEquals(1, customer.getId());
        assertEquals("John Doe", customer.getName());
        assertEquals("johndoe", customer.getUsername());
        assertEquals("password", customer.getPass());
        assertEquals("johndoe@example.com", customer.getEmail());
        assertEquals("1234567890", customer.getPhone());
        assertEquals(1000, customer.getBalance());
    }

    @Test
    public void testCustomerSetters() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setUsername("johndoe");
        customer.setPass("password");
        customer.setEmail("johndoe@example.com");
        customer.setPhone("1234567890");
        customer.setBalance(1000);
        assertEquals(1, customer.getId());
        assertEquals("John Doe", customer.getName());
        assertEquals("johndoe", customer.getUsername());
        assertEquals("password", customer.getPass());
        assertEquals("johndoe@example.com", customer.getEmail());
        assertEquals("1234567890", customer.getPhone());
        assertEquals(1000, customer.getBalance());
    }
}

