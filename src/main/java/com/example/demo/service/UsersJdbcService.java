package com.example.demo.service;

import com.example.demo.controller.model.MockUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersJdbcService {


    private final JdbcTemplate jdbcTemplate;

    public UsersJdbcService(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public MockUser findUserById(String userId) {

        List<MockUser> query = jdbcTemplate.query("Select EXTERNAL_ID, EMAIL, AGE FROM USERS WHERE EXTERNAL_ID = ?", (rs, rowNum) -> new MockUser(String.valueOf(rs.getInt("AGE")), rs.getString("EMAIL"), UUID.fromString(rs.getString("EXTERNAL_ID"))), userId);
        //return query.getFirst();
        return query.get(0);
    }

}
