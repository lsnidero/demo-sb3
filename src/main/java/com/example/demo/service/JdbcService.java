package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JdbcService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<String> getAllLinks() {
        List<Map<String, Object>> bookmarks = jdbcTemplate.queryForList("SELECT url,created_at FROM BOOKMARKS");
        return bookmarks.stream().map(stringObjectMap -> (String) stringObjectMap.get("url")).collect(Collectors.toList());
    }

}
