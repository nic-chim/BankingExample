package com.example.api.repository.mapper;

import com.example.api.model.AccountEntity;
import com.example.api.model.TransactionEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRowMapper implements RowMapper<TransactionEntity> {

    @Override
    public TransactionEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        TransactionEntity transaction = new TransactionEntity();
        transaction.setId(rs.getLong("id"));

        AccountEntity account = new AccountEntity();
        account.setId(rs.getInt("account_id"));
        transaction.setAccount(account);
        transaction.setDateTime(rs.getTimestamp("date_time").toLocalDateTime());
        transaction.setDetails(rs.getString("details"));
        transaction.setFromAccount(rs.getString("from_account"));
        transaction.setAmount(rs.getBigDecimal("amount"));
        return transaction;
    }
}
