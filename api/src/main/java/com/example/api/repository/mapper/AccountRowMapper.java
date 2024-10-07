package com.example.api.repository.mapper;

import com.example.api.model.AccountEntity;
import com.example.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<AccountEntity> {

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public AccountEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        AccountEntity account = new AccountEntity();
        account.setId(rs.getInt("id"));
        account.setType(rs.getString("type"));
        account.setAccountName(rs.getString("account_name"));

        return account;
    }
}
