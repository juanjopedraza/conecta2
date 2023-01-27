package es.fp.edu.conecta2;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories (
        entityManagerFactoryRef = "userEntityManagerFactory",
        transactionManagerRef = "userTransactionManger",
        basePackages = {"es.fp.edu.conecta2.repo.user"})
public class BDConfig {
    @Autowired
    private Environment env;

    @Bean(name="userDataSource")
    public DataSource userDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("persistente.datasource.url"));
        dataSource.setUsername(env.getProperty("persistente.datasource.username"));
        dataSource.setPassword(env.getProperty("persistente.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("persistente.datasource.driver-class-name"));

        return dataSource;

    }
    @Bean(name="userEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        // TODO: 27/01/2023
    }


}
