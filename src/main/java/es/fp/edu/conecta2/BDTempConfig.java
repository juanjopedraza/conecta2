package es.fp.edu.conecta2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "adminEntityManagerFactory",
        transactionManagerRef = "adminTransactionManger",
        basePackages = {"es.fp.edu.conecta2.repo.admin"})

public class BDTempConfig {
    @Autowired
    private Environment env;

    @Bean(name="adminDataSource")
    public DataSource userDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("temporal.datasource.url"));
        dataSource.setUsername(env.getProperty("temporal.datasource.username"));
        dataSource.setPassword(env.getProperty("temporal.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("temporal.datasource.driver-class-name"));

        return dataSource;

    }
    @Bean(name = "adminEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        // TODO: 27/01/2023
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(userDatasource());
        em.setPackagesToScan("es.fp.edu.conecta2.modelo.admin");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String,Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("temporal.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.show-sql", env.getProperty("temporal.jpa.show-sql"));
        properties.put("hibernate.dialect", env.getProperty("temporal.jpa.properties.hibernate.dialect"));

        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean(name = "adminTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }





}

