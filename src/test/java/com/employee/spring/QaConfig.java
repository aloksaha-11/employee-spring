package com.employee.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(
        basePackages = "com.employee",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                value = SpringConfig.class))
@PropertySource(value = "classpath:com/employee/test.properties", ignoreResourceNotFound = true)
public class QaConfig {
}
