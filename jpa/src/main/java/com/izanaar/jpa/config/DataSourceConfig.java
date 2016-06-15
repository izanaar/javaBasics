package com.izanaar.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Profile("h2")
    public DataSource h2DataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                /*.addScript("classpath:schema.sql")
                .addScript("classpath:test-data.sql")*/
                .build();
    }

    @Bean
    @Profile("mysql")
    public DataSource mySqlDataSource(){
        return null;
    }

}
