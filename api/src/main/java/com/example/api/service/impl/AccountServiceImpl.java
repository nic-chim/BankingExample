package com.example.api.service.impl;

import com.example.api.dto.AccountDto;
import com.example.api.model.AccountEntity;
import com.example.api.model.CustomerEntity;
import com.example.api.repository.AccountRepository;
import com.example.api.repository.CustomerRepository;
import com.example.api.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepository customerRepo;


    @Override
    //handle account not found better
    public AccountDto getAccountById(int accountId) {
        AccountEntity accountEntity = accountRepo.getAccountById(accountId);
        if (accountEntity != null) {
            return modelMapper.map(accountEntity, AccountDto.class);
        }
        return new AccountDto();
    }

    @Override
    public int createAccount(AccountDto accountDetails) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(accountDetails.getCustomerId());

        AccountEntity accountEntity = new AccountEntity();
        String accountName = accountDetails.getAccountName() != null ? accountDetails.getAccountName() : accountDetails.getType();
        accountEntity.setAccountName(accountName);
        CustomerEntity customer = customerRepo.getCustomerById(accountDetails.getCustomerId());
        accountEntity.setCustomer(customer);
        accountEntity.setType(accountDetails.getType());

        int id = accountRepo.createAccount(accountEntity);

        return id;
    }
}
