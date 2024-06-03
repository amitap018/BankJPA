package com.example;


import com.example.controller.CustomerController;
import com.example.model.Customer;
import com.example.repo.CustomerRepository;
import com.example.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

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
    void testRead() throws Exception {
        List<Customer> customers = Arrays.asList(cust1, cust2);
        when(customerService.read()).thenReturn(customers);

        mockMvc.perform(get("/bank/read"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Amit"))
                .andExpect(jsonPath("$[1].name").value("Shubham"));
    }

    @Test
    void testReadOne() throws Exception {
        when(customerService.readOne(1)).thenReturn(cust1);

        mockMvc.perform(get("/bank/readone/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Amit"));
    }

    @Test
    void testAdd() throws Exception {
        when(customerService.add(any(Customer.class))).thenReturn(cust1);
        ObjectMapper objectMapper = new ObjectMapper();
        String customerJson = objectMapper.writeValueAsString(cust1);

        mockMvc.perform(post("/bank/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(customerJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Amit"));
    }

    @Test
    void testUpdate() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String customerJson = objectMapper.writeValueAsString(cust1);

        mockMvc.perform(put("/bank/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(customerJson))
                .andExpect(status().isOk());

        verify(customerService).update(eq(1), any(Customer.class));

    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(delete("/bank/delete/1"))
                .andExpect(status().isOk());

        verify(customerService).delete(1);
    }

//    @Test
//    void testCheckBalance() throws Exception {
//        when(customerRepository.findById(1)).thenReturn(java.util.Optional.of(cust1));
//
//        mockMvc.perform(get("/bank/checkBalance/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("1000"));
//    }

//    @Test
//    void testDeposit() throws Exception {
//        when(customerRepository.findById(1)).thenReturn(java.util.Optional.of(cust1));
//        
//        mockMvc.perform(put("/bank/deposit/1/500"))
//                .andExpect(status().isOk());
//
//        verify(customerService).deposit(1, 500);
//    }
//
//    @Test
//    void testMoneyTransfer() throws Exception {
//        when(customerRepository.findById(1)).thenReturn(java.util.Optional.of(cust1));
//        when(customerRepository.findById(2)).thenReturn(java.util.Optional.of(cust2));
//
//        mockMvc.perform(put("/bank/moneyTransfer/1/500/2"))
//                .andExpect(status().isOk());
//
//        verify(customerService).moneyTransfer(1, 500, 2);
//    }
}
