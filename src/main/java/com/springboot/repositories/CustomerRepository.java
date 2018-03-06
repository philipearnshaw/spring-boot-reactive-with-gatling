package com.springboot.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.springboot.domain.Customer;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, Long> {

}
