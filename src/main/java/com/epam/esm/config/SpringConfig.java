package com.epam.esm.config;

import com.epam.esm.util.PropertiesUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
@ComponentScan("com.epam.esm")
@EnableWebMvc
public class SpringConfig {

    //JDBC config
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setPassword(PropertiesUtil.get("db.password"));
        dataSource.setUrl(PropertiesUtil.get("db.url"));
        dataSource.setUsername(PropertiesUtil.get("db.username"));
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
}
