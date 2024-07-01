package com.codegyme.customer_list.services;

import com.codegyme.customer_list.models.Customer;
import com.codegyme.customer_list.repositories.CustomerRepository;

import java.util.List;

public class CustomerService {
    private CustomerRepository customerRepository = new CustomerRepository();
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }
}
