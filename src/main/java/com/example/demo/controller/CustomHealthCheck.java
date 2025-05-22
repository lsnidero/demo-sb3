package com.example.demo.controller;

import com.example.demo.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConditionalOnEnabledHealthIndicator("custom")
public class CustomHealthCheck extends AbstractHealthIndicator {

    private final ConfigurationService configurationService;

    public CustomHealthCheck(@Autowired ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        if (configurationService.customHealthSwitch()) {
            builder.up();
        } else {
            builder.withDetails(Map.of("reason","disabled on DB")).down();
        }
    }
}
