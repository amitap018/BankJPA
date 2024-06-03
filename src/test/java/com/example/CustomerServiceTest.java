package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.model.Customer;
import com.example.repo.CustomerRepository;
import com.example.service.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer cust1;
    private Customer cust2;

    @BeforeEach
    public void setUp() {
        cust1 = new Customer();
        cust1.setId(1);
        cust1.setName("Amit");
        cust1.setUsername("amit");
        cust1.setPass("1234");
        cust1.setEmail("amit@gmail.com");
        cust1.setBalance(1000);

        cust2 = new Customer();
        cust2.setId(2);
        cust2.setName("Shubham");
        cust2.setUsername("shubham");
        cust2.setPass("9876");
        cust2.setEmail("shubham@gmail.com");
        cust2.setBalance(2000);
    }

    @Test
    void testRead() {
        List<Customer> customers = Arrays.asList(cust1, cust2);
        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> result = customerService.read();
        assertEquals(2, result.size());
        assertEquals("Amit", result.get(0).getName());
        assertEquals("Shubham", result.get(1).getName());
    }

    @Test
    void testReadOne() {
        when(customerRepository.findById(1)).thenReturn(Optional.of(cust1));

        Customer result = customerService.readOne(1);
        assertNotNull(result);
        assertEquals("Amit", result.getName());
    }

    @Test
    void testAdd() {
        when(customerRepository.save(any(Customer.class))).thenReturn(cust1);

        Customer result = customerService.add(cust1);
        assertNotNull(result);
        assertEquals("Amit", result.getName());
    }

    @Test
    void testUpdate() {
        when(customerRepository.findById(1)).thenReturn(Optional.of(cust1));

        Customer newCustomer = new Customer();
        newCustomer.setName("Updated Name");
        newCustomer.setUsername("updatedUsername");
        newCustomer.setEmail("updated@gmail.com");
        newCustomer.setPhone("1234567890");
        newCustomer.setBalance(5000);

        customerService.update(1, newCustomer);

        verify(customerRepository).save(cust1);
        assertEquals("Updated Name", cust1.getName());
        assertEquals("updatedUsername", cust1.getUsername());
        assertEquals("updated@gmail.com", cust1.getEmail());
        assertEquals("1234567890", cust1.getPhone());
        assertEquals(5000, cust1.getBalance());
    }

    @Test
    void testDelete() {
        customerService.delete(1);
        verify(customerRepository).deleteById(1);
    }
}
