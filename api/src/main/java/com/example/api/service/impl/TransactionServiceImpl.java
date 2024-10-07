package com.example.api.service.impl;

import com.example.api.dto.TransactionDto;
import com.example.api.dto.TransactionResponseDto;
import com.example.api.model.AccountEntity;
import com.example.api.model.TransactionEntity;
import com.example.api.repository.TransactionRepository;
import com.example.api.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TransactionResponseDto getTransactions(int accountId) {
        List<TransactionEntity>  transactions = transactionRepo.getTransactions(accountId);

        BigDecimal[] balance = {BigDecimal.ZERO};
        List<TransactionDto> transactionDtos = transactions.stream()
                .map(transaction -> {
                    balance[0] = balance[0].add(transaction.getAmount());
                    return modelMapper.map(transaction, TransactionDto.class);
                })
                .collect(Collectors.toList());

        TransactionResponseDto responseDto = new TransactionResponseDto();
        responseDto.setBalance(balance[0]);
        responseDto.setTransactions(transactionDtos);
        return responseDto;
    }

    @Override
    public Long createTransaction(TransactionDto transaction) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(transaction.getAccountId());

        TransactionEntity entity = new TransactionEntity();
        entity.setAccount(accountEntity);
        entity.setAmount(transaction.getAmount());
        entity.setDateTime(LocalDateTime.now());
        entity.setFromAccount(transaction.getFromAccount());
        Long transactionId = transactionRepo.createTransaction(entity);
        return transactionId;
    }
}
