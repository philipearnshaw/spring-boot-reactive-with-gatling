package com.springboot.controllers;

import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.springboot.domain.Customer;
import com.springboot.repositories.CustomerRepository;

import reactor.core.publisher.Flux;

public class CustomerControllerTest {
    
    private WebTestClient webTestClient;
    private CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        customerRepository = Mockito.mock(CustomerRepository.class);
        webTestClient = WebTestClient.bindToController(new CustomerController(customerRepository)).build();
    }

    @Test
    public void testGetAllCustomers() {
        
        given(customerRepository.findAll()).willReturn(
                Flux.just(
                        buildCustomer(1),
                        buildCustomer(2)));
                
        webTestClient.get()
            .uri(CustomerController.ROOT_URI)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(Customer.class)
            .hasSize(2)
            .contains(buildCustomer(1), buildCustomer(2));
    }

    
    private Customer buildCustomer(final int suffix) {
        return Customer.builder()
                .firstName("first-name" + suffix)
                .lastName("last-name" + suffix)
                .randomLargeString("sdfdslskdjfdsdl")
                .build();
    }
}
