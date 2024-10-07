package com.example.api.service;

import com.example.api.dto.AccountDto;

public interface AccountService {

    AccountDto getAccountById(int accountId);
    int createAccount(AccountDto accountDetails);

}
