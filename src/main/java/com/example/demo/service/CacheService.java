package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CacheService {

    @Cacheable("keyGenerated")
    public String generateKey() {
        String key = UUID.randomUUID().toString();
        log.info("Generated key {}", key);
        return key;
    }
}
