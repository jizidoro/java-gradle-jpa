/* 
 * Este arquivo pertence a Petrobras e nao pode ser utilizado fora desta empresa 
 * sem previa autorizacao.
 * ----------------------------------
 * Esta classe segue o padrao PE-2T0-00250
 */
package com.comrades.app;


import com.comrades.app.core.bases.MessageBundle;
import com.comrades.app.persistence.repositories.HashMapRepository;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Profile("!tests")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.comrades.app.domain.models",
        repositoryBaseClass = HashMapRepository.class)
@ComponentScan(basePackages = "com.comrades.app")
public class SpringBeansConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        Resource[] resources
                = new ClassPathResource[]{new ClassPathResource("server/app.properties"),
                    new ClassPathResource("server/infra.properties")};
        pspc.setLocations(resources);
        pspc.setLocalOverride(true);
        pspc.setIgnoreUnresolvablePlaceholders(false);
        return pspc;
    }

    @Bean(destroyMethod="")
    public DataSource dataSource() throws NamingException {
        Properties props = new Properties();

        props.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
        props.setProperty("dataSource.user", "postgres");
        props.setProperty("dataSource.password", "qwe123");
        props.setProperty("dataSource.databaseName", "comrades");
        props.put("dataSource.logWriter", new PrintWriter(System.out));

        HikariConfig config = new HikariConfig(props);
        HikariDataSource ds = new HikariDataSource(config);

        return ds;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() throws NamingException {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.POSTGRESQL);
        vendorAdapter.setGenerateDdl(false);

        LocalContainerEntityManagerFactoryBean factory
                = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.comrades.app");

        factory.setDataSource(dataSource());

        Map<String, String> jpaProperties = new HashMap<>();
        factory.setJpaPropertyMap(jpaProperties);

        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws NamingException {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        txManager.setDataSource(dataSource());
        return txManager;
    }

    @Bean
    public MessageSource messageSource() {
        String basename = "classpath:i18n/messages";
        MessageBundle messageSource = new MessageBundle(basename);
        messageSource.setFallbackToSystemLocale(false);
        messageSource.setBasename(basename);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    @Primary
    public LocalValidatorFactoryBean validatorFactory() {
        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setFallbackToSystemLocale(false);
        messageSource.setDefaultEncoding("UTF-8");
        validatorFactoryBean.setValidationMessageSource(messageSource);
        return validatorFactoryBean;
    }

}
