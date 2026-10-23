package com.employee.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.employee")
@PropertySource(value = "file:./employee.properties", ignoreResourceNotFound = true)

public class SpringConfig {
    
}
