package com.employee.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.transaction.annotation.EnableTransactionManagment;

@Configuration
@EnableWebMvc
@ComponentScan("com.employee")
@EnableTransactionManagement
@PropertySource(value = "file:./employee.properties", ignoreResourceNotFound = true)

public class SpringConfig {
    

}
