package com.springboot.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.domain.Customer;
import com.springboot.repositories.CustomerBlockingRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(CustomerBlockingController.ROOT_URI)
public class CustomerBlockingController {
    
    public static final String ROOT_URI = "/blocking/customers";
    
    private final CustomerBlockingRepository customerRepository;
    
    @GetMapping
    public List<Customer> getAllCustomers() throws InterruptedException {
   //     Thread.sleep(10);
        return customerRepository.findAll();
    }
}
