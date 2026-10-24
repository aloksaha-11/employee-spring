package com.employee.spring;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.employee")
@EnableTransactionManagement
@PropertySource(value = "file:./employee.properties", ignoreResourceNotFound = true)
public class DbConfig {

    public static final String PACKAGE_POJO = "com.employee.pojo";

    @Value("${jdbc.driverClassName:${jdbc.DriverClassName:com.mysql.cj.jdbc.Driver}}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;
    @Value("${hibernate.dialect:}")
    private String hibernateDialect;
    @Value("${hibernate.show_sql:false}")
    private String hibernateShowSql;
    @Value("${hibernate.hbm2ddl.auto:update}")
    private String hibernateHbm2ddl;    

    @Bean(name = "datasource")
    public DataSource getDataSource() {
        BasicDataSource bean = new BasicDataSource();
        bean.setDriverClassName(jdbcDriver);
        bean.setUrl(jdbcUrl);
        bean.setUsername(jdbcUsername);
        bean.setPassword(jdbcPassword);
        bean.setInitialSize(2);
        bean.setMaxTotal(10);
        bean.setMinIdle(2);
        bean.setValidationQuery("Select 1");
        bean.setTestWhileIdle(true);
        bean.setTimeBetweenEvictionRunsMillis(10 * 60 * 100);
        return bean;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource);
        bean.setPackagesToScan(PACKAGE_POJO);
        HibernateJpaVendorAdapter jpaAdapter = new HibernateJpaVendorAdapter();
        bean.setJpaVendorAdapter(jpaAdapter);
        Properties jpaProperties = new Properties();
        if (hibernateDialect != null && !hibernateDialect.isBlank()) {
            jpaProperties.put("hibernate.dialect", hibernateDialect);
        }
        jpaProperties.put("hibernate.show_sql", hibernateShowSql);
        jpaProperties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddl);
        bean.setJpaProperties(jpaProperties);
        return bean;
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean emf)  {
        JpaTransactionManager bean = new JpaTransactionManager();
        bean.setEntityManagerFactory(emf.getObject());
        return bean;
    }

    @Bean
    public org.springframework.context.ApplicationListener<org.springframework.context.event.ContextRefreshedEvent> fixAutoIncrement(DataSource dataSource) {
        return event -> {
            try (java.sql.Connection conn = dataSource.getConnection();
                 java.sql.Statement stmt = conn.createStatement()) {
                stmt.execute("ALTER TABLE employee MODIFY id INT NOT NULL AUTO_INCREMENT");
            } catch (Exception ignored) {
            }
        };
    }
}
