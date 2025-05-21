package com.example.demo.service;

import com.example.demo.repository.ConfigurationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    public ConfigurationService(@Autowired ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }

    public boolean customHealthSwitch() {
        return Boolean.parseBoolean(configurationRepository.findByName("HEALTHY").getValue());
    }
}
