package com.example.api.repository;

import com.example.api.model.CustomerEntity;
import com.example.api.repository.mapper.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class CustomerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public CustomerEntity getCustomerById(int id){
        String sql = "select * from customers where id = ?";
        return jdbcTemplate.query(sql, new CustomerRowMapper(), id)
                .stream()
                .findFirst()
                .orElse(null);
    }

    public int createCustomer(CustomerEntity customer){
        Random random = new Random();

        int id = random.nextInt(999999999);
        String sql = "insert into customers (id, first_name, last_name) values (?, ?, ?)";
        jdbcTemplate.update(sql, id, customer.getFirstName(), customer.getLastName());
        return id;
    }

}
