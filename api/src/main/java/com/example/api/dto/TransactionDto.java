package com.example.api.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TransactionDto {

    private Long id;
    private int accountId;
    private Date dateTime;
    private String details;
    private String fromAccount;
    private BigDecimal amount;

}
