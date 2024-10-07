package com.example.api;

import com.example.api.dto.AccountDto;
import com.example.api.dto.CustomerDto;
import com.example.api.dto.TransactionDto;
import com.example.api.model.AccountEntity;
import com.example.api.model.CustomerEntity;
import com.example.api.model.TransactionEntity;
import com.example.api.repository.AccountRepository;
import com.example.api.repository.CustomerRepository;
import com.example.api.repository.TransactionRepository;
import com.example.api.service.AccountService;
import com.example.api.service.CustomerService;
import com.example.api.service.TransactionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Random;

@SpringBootApplication
public class ApiApplication {


    private final AccountService accService;
    private final CustomerService custService;
    private final TransactionService transactService;

    public ApiApplication(AccountService accountService, CustomerService customerService, TransactionService transactionService) {
        this.accService = accountService;
        this.custService = customerService;
        this.transactService = transactionService;
    }


    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Bean
    CommandLineRunner seedData(){
        return args -> {
            int cId = 12345;

            CustomerDto customer = new CustomerDto();
            customer.setId(cId);
            customer.setFirstName("Joe");
            customer.setLastName("Blogs");

            int customerid = custService.createCustomer(customer);
            AccountDto account1 = setAccount(customerid, "Travel Fund", "WebSaver");
            AccountDto account2 = setAccount(customerid, "General", "Connect Plus");

            int account1Id = accService.createAccount(account1);
            int account2Id = accService.createAccount(account2);

            createTransactions(account1Id, 10);
            createTransactions(account2Id, 3);

        };
    }

    AccountDto setAccount(int cId, String accountName, String accountType){

        AccountDto account = new AccountDto();
        account.setCustomerId(cId);
        account.setAccountName(accountName);
        account.setType(accountType);
        return account;
    }

    void createTransactions(int accountId, int noTansacts){
        Random random = new Random();

        TransactionDto transDto = new TransactionDto();
        transDto.setAccountId(accountId);

        for (int i = 0; i < noTansacts; i++) {
            double randomAmount = -100.00 + (1000.00 + 100) * random.nextDouble();
            transDto.setAmount(BigDecimal.valueOf(Math.round(randomAmount * 100.0) / 100.0));
            transDto.setDetails(String.valueOf(i));
            transDto.setFromAccount(String.valueOf(i));
            transactService.createTransaction(transDto);
        }


}

}
