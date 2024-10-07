package com.example.api.service;

import com.example.api.dto.TransactionDto;
import com.example.api.dto.TransactionResponseDto;

public interface TransactionService {

    TransactionResponseDto getTransactions(int accountId);
    Long createTransaction(TransactionDto transaction);
}
