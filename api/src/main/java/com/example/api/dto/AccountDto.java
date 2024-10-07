package com.example.api.dto;

import lombok.Data;

@Data
public class AccountDto {

    private int accountId;
    private int customerId;
    private String accountName;
    private String type;

}
