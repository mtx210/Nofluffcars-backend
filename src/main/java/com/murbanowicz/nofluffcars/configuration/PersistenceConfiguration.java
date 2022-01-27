package com.murbanowicz.nofluffcars.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource({"classpath:persistence.properties"})
public class PersistenceConfiguration {

    @Bean(name = "serviceDb")
    public DataSource servicedbDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("${spring.datasource.url}");
        dataSource.setUsername("${spring.datasource.username}");
        dataSource.setPassword("${spring.datasource.password}");

        return dataSource;
    }

    @Bean(name = "serviceJdbcTemplate")
    public NamedParameterJdbcTemplate serviceJdbcTemplate(@Qualifier("serviceDb") DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean(name = "dataDb")
    public DataSource datadbDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("${secondary.datasource.url}");
        dataSource.setUsername("${secondary.datasource.username}");
        dataSource.setPassword("${secondary.datasource.password}");

        return dataSource;
    }

    @Bean(name = "dataJdbcTemplate")
    public NamedParameterJdbcTemplate dataJdbcTemplate(@Qualifier("dataDb") DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }
}