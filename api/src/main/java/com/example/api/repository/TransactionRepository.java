package com.example.api.repository;

import com.example.api.model.TransactionEntity;
import com.example.api.repository.mapper.TransactionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TransactionEntity> getTransactions(int accountId) {
        String sql = "select * from transactions where account_id = ? order by date_time desc";
        List<TransactionEntity> transactions = jdbcTemplate.query(sql, new TransactionRowMapper(), accountId);
        return transactions;
    }

    public Long createTransaction(TransactionEntity transaction) {

        String sql = "insert into transactions (account_id, date_time, details, from_account, amount) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, transaction.getAccount().getId(), transaction.getDateTime(),
                transaction.getDetails(), transaction.getFromAccount(), transaction.getAmount());
        return 1L;

    }
}
