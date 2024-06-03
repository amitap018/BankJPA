//package com.example;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.example.custom.CustomRepositoryImpl;
//import com.example.model.Customer;
//import com.example.repo.CustomerRepository;
//
//import jakarta.persistence.EntityManager;
//import jakarta.transaction.Transactional;
//
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//@ComponentScan(basePackages = "com.example.custom")
//public class CustomRepositoryImplTest {
//
//    @Autowired
//    private CustomRepositoryImpl customRepository;
//
//    @Autowired
//    private EntityManager entityManager;
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    private Customer cust1;
//    private Customer cust2;
//
//    @BeforeEach
//    public void setUp() {
//        cust1 = new Customer();
//        cust1.setName("Amit");
//        cust1.setUsername("amit");
//        cust1.setPass("1234");
//        cust1.setEmail("amit@gmail.com");
//        cust1.setBalance(1000);
//
//        cust2 = new Customer();
//        cust2.setName("Shubham");
//        cust2.setUsername("shubham");
//        cust2.setPass("9876");
//        cust2.setEmail("shubham@gmail.com");
//        cust2.setBalance(2000);
//
//        customerRepository.save(cust1);
//        customerRepository.save(cust2);
//    }
//
//    @Test
//    @Transactional
//    void testDepositUpdate() {
//        customRepository.depositUpdate(cust1.getId(), 500);
//        Customer updatedCustomer = entityManager.find(Customer.class, cust1.getId());
//        assertEquals(1500, updatedCustomer.getBalance());
//    }
//
//    @Test
//    @Transactional
//    void testWithdrawUpdate() {
//        customRepository.withdwarlUpdate(cust1.getId(), 500);
//        Customer updatedCustomer = entityManager.find(Customer.class, cust1.getId());
//        assertEquals(500, updatedCustomer.getBalance());
//    }
//
//    @Test
//    @Transactional
//    void testMoneyTransfer() {
//        customRepository.moneyTransfer(cust1.getId(), 500, cust2.getId());
//        Customer updatedCustomer1 = entityManager.find(Customer.class, cust1.getId());
//        Customer updatedCustomer2 = entityManager.find(Customer.class, cust2.getId());
//        assertEquals(500, updatedCustomer1.getBalance());
//        assertEquals(2500, updatedCustomer2.getBalance());
//    }
//}
