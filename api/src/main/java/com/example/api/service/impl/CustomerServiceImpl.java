package com.example.api.service.impl;

import com.example.api.dto.CustomerDto;
import com.example.api.model.CustomerEntity;
import com.example.api.repository.CustomerRepository;
import com.example.api.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository cRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDto getCustomerById(int id) {
        CustomerEntity customerEntity = cRepo.getCustomerById(id);
        CustomerDto customerDto = modelMapper.map(customerEntity, CustomerDto.class);
        return customerDto;
    }

    @Override
    public int createCustomer(CustomerDto customer) {
        CustomerEntity customerEntity = modelMapper.map(customer, CustomerEntity.class);
        int id = cRepo.createCustomer(customerEntity);
        return id;
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customer) {
        return null;
    }

    @Override
    public void deleteCustomer(int id) {

    }
}
