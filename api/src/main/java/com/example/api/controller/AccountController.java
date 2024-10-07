package com.example.api.controller;


import com.example.api.dto.AccountDto;
import com.example.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accService;

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> getAccountDetails( @PathVariable int accountId){
        AccountDto account = accService.getAccountById(accountId);
        if (account != null) {
            return ResponseEntity.ok(account);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Integer> createAccount(@RequestBody AccountDto accountDetails){
        int accountId = accService.createAccount(accountDetails);
        return ResponseEntity.ok(accountId);
    }


}
