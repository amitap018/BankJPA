//package com.example;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.web.client.RestTemplate;
//
//import com.example.controller.CustomerController;
//import com.example.model.Customer;
//import com.example.service.CustomerService;
//
//public class TestController {
//
//    @InjectMocks
//    private CustomerController customerController;
//
//    @Mock
//    private CustomerService customerService;
//
//    @Mock
//    private RestTemplate restTemplate;
//
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//	@Before
//	public void uppu2() {
//		System.out.println("Before each cases");
//
//	}
//
//	@After
//	public void uppu3() {
//		System.out.println("after each cases");
//
//	}
//
//    @Test
//    public void testRead() {
//        List<Customer> customers = new ArrayList<>();
//        customers.add(new Customer(100,"John","amit","1234566","adgad@gmailcom","73498274",9999));
//      
//
//        when(customerService.read()).thenReturn(customers);
//
//        assertEquals(customers, customerController.read());
//    }
//
//    @Test
//    public void testReadOne() {
//        int id = 100;
//        Customer customer = new Customer(100,"John","amit","1234566","adgad@gmailcom","73498274",9999);
//
//        when(customerService.readOne(id)).thenReturn(customer);
//
//        assertEquals(customer, customerController.readOne(id));
//    }
//
//    @Test
//    public void testAdd() {
//        Customer customerToAdd = new Customer(101,"Shubz","amit","1234566","adgad@gmailcom","73498274",9999);
//        Customer addedCustomer = new Customer(101,"Shubz","amit","1234566","adgad@gmailcom","73498274",9999);
//
//        when(customerService.add(any(Customer.class))).thenReturn(addedCustomer);
//
//        assertEquals(addedCustomer, customerController.add(customerToAdd));
//    }
//
//    @Test
//    public void testUpdate() {
//        int id = 101;
//        Customer updatedCustomer = new Customer(101,"Shubz","amit","1234566","adgad@gmailcom","73498274",9999);
//
//        customerController.update(id, updatedCustomer);
//
//        verify(customerService, times(1)).update(id, updatedCustomer);
//    }
//
//    @Test
//    public void testDelete() {
//        int id = 1;
//
//        customerController.delete(id);
//
//        verify(customerService, times(1)).delete(id);
//    }
//
//    @SuppressWarnings("unchecked")
//	@Test
//    public void testBankMethod() {
//        int id = 1;
//        int balance = 100; // Set expected balance
//
//        when(restTemplate.getForObject(any(String.class), any(Class.class))).thenReturn(balance);
//
//        assertEquals(balance, customerController.bankMethod(id));
//    }
//
//    // Add similar tests for bankDeposit and bankMoneyTransfer methods
//}
