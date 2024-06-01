//package com.example;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//
//import com.example.controller.CustomerController;
//import com.example.model.Customer;
//import com.example.service.CustomerService;
//
//public class CustomerControllerTest {
//
//    @Test
//    public void testAddCustomer() {
//        CustomerService customerServiceMock = mock(CustomerService.class);
//        CustomerController customerController = new CustomerController(customerServiceMock);
//
//        Customer customer = new Customer();
//        customer.setId(1);
//        customer.setName("John");
//        customer.setBalance(100);
//
//        when(customerServiceMock.add(customer)).thenReturn(customer);
//
//        Customer addedCustomer = customerController.add(customer);
//
//        assertEquals(customer, addedCustomer);
//    }
//
//    @Test
//    public void testReadOneCustomer() {
//        CustomerService customerServiceMock = mock(CustomerService.class);
//        CustomerController customerController = new CustomerController(customerServiceMock);
//
//        Customer customer = new Customer();
//        customer.setId(1);
//        customer.setName("Alice");
//        customer.setBalance(200);
//
//        when(customerServiceMock.readOne(1)).thenReturn(customer);
//
//        Customer retrievedCustomer = customerController.readOne(1);
//
//        assertEquals(customer, retrievedCustomer);
//    }
//}
