package com.spittr.config.data;

import org.h2.jdbcx.JdbcDataSource;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Profile("jpa-h2")
public class SpringDataConfig {

    @Bean
    public JpaVendorAdapter vendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.H2);
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
        vendorAdapter.setShowSql(true);
        return vendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            @Qualifier("h2") DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {

        LocalContainerEntityManagerFactoryBean emfb =
                new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setPackagesToScan("com.spittr.data.entities");
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        emfb.setJpaProperties(new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto", "update");
            }
        });
        return emfb;
    }

}
