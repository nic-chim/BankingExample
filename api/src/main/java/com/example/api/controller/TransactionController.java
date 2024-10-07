package com.example.api.controller;

import com.example.api.dto.TransactionDto;
import com.example.api.dto.TransactionResponseDto;
import com.example.api.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts/{accId}/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("")
    public ResponseEntity<TransactionResponseDto> getTractions(@PathVariable int accId){
        TransactionResponseDto response = transactionService.getTransactions(accId);

        return ResponseEntity.ok(response);

    }

    @PostMapping("/")
    public ResponseEntity<String> createTransaction(@RequestBody TransactionDto transactionDto){
        Long transId = transactionService.createTransaction(transactionDto);

        return ResponseEntity.ok("Transaction created");
    }
}
