package com.springboot.bootstrap;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.domain.Customer;
import com.springboot.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {
    
    private static final int NUM_RECORDS = 100;

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count().block() == 0) {
            loadCustomers();
        }
    }

    private void loadCustomers() {
        for (int i = 0; i < NUM_RECORDS; i++) {
            customerRepository.save(buildCustomer(i)).block();
        }
    }
    
    private Customer buildCustomer(final int i) {
        return Customer.builder()
                .firstName("first-name" + i)
                .lastName("last-name" + i)
                .randomLargeString(UUID.randomUUID().toString())
                .build();
    }
}
