package com.spittr.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.constraints.NotNull;

@Configuration
@ComponentScan(basePackages = {"com.spittr.model","com.spittr.data","com.spittr.config"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
public class RootConfig {

        @Bean
        public BasicDataSource dataSource() {
                BasicDataSource ds = new BasicDataSource();
                ds.setDriverClassName("org.h2.Driver");
                ds.setUrl("jdbc:h2:tcp://localhost/test");
                ds.setUsername("root");
                ds.setPassword("davidian");
                ds.setInitialSize(5);
                ds.setMaxActive(10);
                return ds;
        }
}



