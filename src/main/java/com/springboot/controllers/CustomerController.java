package com.springboot.controllers;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.domain.Customer;
import com.springboot.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
@RequestMapping(CustomerController.ROOT_URI)
public class CustomerController {
    
    public static final String ROOT_URI = "/customers";
    
    private final CustomerRepository customerRepository;
    
    @GetMapping
    public Flux<Customer> getAllCustomers() {
        return customerRepository.findAll();//.delayElements(Duration.ofMillis(10));
    }
}
