package com.revature.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

// Inside of here will be my configuration for a large portion of the spring security setup
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // First thing we want to start with is setting up the security filter chain

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests() // Underneath here is where we describe the permissions we want to allow
                .anyRequest().permitAll()
                .and()
                .httpBasic();

        return http.build();
    }
}
