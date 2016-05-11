package com.spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.spittr.model","com.spittr.data","com.spittr.config"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
public class RootConfig {

        @Bean
        public DataSource dataSource() {
                return new EmbeddedDatabaseBuilder()
                        .setType(EmbeddedDatabaseType.H2)
                        .addScript("classpath:schema.sql")
                        .addScript("classpath:test-data.sql")
                        .build();
        }
}



