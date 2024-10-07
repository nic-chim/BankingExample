package com.example.api.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class TransactionResponseDto {

    private BigDecimal balance;
    List<TransactionDto> transactions;


}
