package com.revature.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // This marks this class for confuration
@ComponentScan("com.revature") // This will take in a package and search the entire package for stereotype annotations
public class AppConfig {
}
