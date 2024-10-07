package com.example.api.repository;

import com.example.api.model.AccountEntity;
import com.example.api.repository.mapper.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class AccountRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createAccount(AccountEntity accDetails){
        Random random = new Random();

        int id = random.nextInt(999999999);
        String sql = "insert into accounts (id, customer_id, account_name, type) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, id, accDetails.getCustomer().getId(), accDetails.getAccountName(), accDetails.getType());
        return id;
    }

    public AccountEntity getAccountById(int accId){
        String sql = "select * from accounts where id = ?";

        return jdbcTemplate.query(sql, new AccountRowMapper(), accId)
                .stream()
                .findFirst()
                .orElse(null);


    }

}
