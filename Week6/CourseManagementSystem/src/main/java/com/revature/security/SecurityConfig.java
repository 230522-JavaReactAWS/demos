package com.revature.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// Inside of here will be my configuration for a large portion of the spring security setup
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Inject in our CustomUsersDetailsService
    private final CustomUserDetailsService customUserDetailsService;

    private final JwtAuthEntryPoint jwtAuthEntryPoint;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    public SecurityConfig(CustomUserDetailsService customUserDetailsService, JwtAuthEntryPoint jwtAuthEntryPoint, JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtAuthEntryPoint = jwtAuthEntryPoint;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }


    // First thing we want to start with is setting up the security filter chain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthEntryPoint) // This is for exception handling
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // JWTs are stateless so we need to make this too
                .and()
                .authorizeRequests() // Underneath here is where we describe the permissions we want to allow
                .antMatchers("/auth/**").permitAll()
//                .antMatchers("/courses/**").hasAuthority("Student")
                // We want all our courses available to the public
                .antMatchers(HttpMethod.GET, "/courses/**").permitAll()
                .antMatchers(HttpMethod.POST, "/courses/**").hasAuthority("Teacher")
                .antMatchers(HttpMethod.PUT, "/courses/**").hasAuthority("Teacher")
                .antMatchers(HttpMethod.DELETE, "/courses/**").hasAuthority("Teacher")
                .antMatchers("/users/courses/**").hasAuthority("Student")
                .and()
                .httpBasic();

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // We need to get the AuthenticationManager, so it can actually load users by their username
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }


    // One other thing I'm going to do since it's important to think about security of passwords
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
