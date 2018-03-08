package com.springboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.domain.Customer;

public interface CustomerBlockingRepository extends MongoRepository<Customer, Long> {

}
