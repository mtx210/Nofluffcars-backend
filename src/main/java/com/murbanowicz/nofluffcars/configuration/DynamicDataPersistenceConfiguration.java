package com.murbanowicz.nofluffcars.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource("classpath:persistence.properties")
@EnableJpaRepositories(
        basePackages = "com.murbanowicz.nofluffcars.data.dynamicdata.repo",
        entityManagerFactoryRef = "servicedbEntityManager",
        transactionManagerRef = "servicedbTransactionManager"
)
public class DynamicDataPersistenceConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public DataSource servicedbDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("secondary.datasource.url"));
        dataSource.setUsername(env.getProperty("secondary.datasource.username"));
        dataSource.setPassword(env.getProperty("secondary.datasource.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean servicedbEntityManager() {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "none");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setJpaPropertyMap(properties);
        em.setDataSource(servicedbDataSource());
        em.setPackagesToScan("com.murbanowicz.nofluffcars.data.dynamicdata.entity");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean
    public PlatformTransactionManager servicedbTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(servicedbEntityManager().getObject());
        return transactionManager;
    }

    /*@Bean(name = "dataJdbcTemplate")
    public NamedParameterJdbcTemplate dataJdbcTemplate(@Qualifier("dataDb") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean(name = "serviceJdbcTemplate")
    public NamedParameterJdbcTemplate serviceJdbcTemplate(@Qualifier("serviceDb") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }*/
}