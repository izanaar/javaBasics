package com.spittr.config.data;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

@Configuration
@PropertySource("file:///home/traum/Documents/Dropbox/dbCredentials.properties")
public class DataSourcesConfig {

    @Value("${db.password}")
    @NotNull
    private String dpPassword;

    @Bean
    @Qualifier("chwin")
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://jenkins.cloudapp.net:3306/chwin");
        ds.setUsername("root");
        ds.setPassword(dpPassword);
        return ds;
    }

    @Bean
    @Qualifier("h2")
    public DataSource embeddedDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .addScript("classpath:test-data.sql")
                .build();
    }

}
