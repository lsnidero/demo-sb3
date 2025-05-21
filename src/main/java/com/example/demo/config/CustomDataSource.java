package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class CustomDataSource {


    @Bean
    public DataSource dataSource(DataSourceProperties properties) {
        DataSourceBuilder<?> dataSourceBuilder = properties.initializeDataSourceBuilder();
        log.info("Initializing DataSource with, possibly, some customization");

        return dataSourceBuilder.build();
    }
}
