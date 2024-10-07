package com.example.api.service;

import com.example.api.dto.CustomerDto;

public interface CustomerService {

    CustomerDto getCustomerById(int id);

    int createCustomer(CustomerDto customer);

    CustomerDto updateCustomer(CustomerDto customer);

    void deleteCustomer(int id);

}
