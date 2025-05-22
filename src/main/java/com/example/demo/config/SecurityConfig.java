package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {

/*
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/actuator/**","/","/swagger-ui/*","/v3/*").permitAll()
                        .anyRequest().authenticated())
                .build();

 */
        return http.csrf().disable().authorizeRequests().anyRequest().permitAll().and().build();


    }
}
