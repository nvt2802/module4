package com.example.security.service;



import com.example.security.entity.Customer;
import com.example.security.exception.ResourceNotFoundException;

import java.util.List;


public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId) throws ResourceNotFoundException;

    void deleteCustomer(int theId) throws ResourceNotFoundException;

    List<Customer> findCustomersByFirstName(String name);
}