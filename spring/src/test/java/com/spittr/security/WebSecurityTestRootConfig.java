package com.spittr.security;

import com.spittr.data.SpittleRepository;
import com.spittr.model.Spitter;
import com.spittr.model.Spittle;
import com.spittr.service.SpittleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.List;

import static org.mockito.Mockito.mock;

@Configuration
public class WebSecurityTestRootConfig {

    @Bean
    public SpittleService spittleService(){
        return new SpittleService();
    }

    @Bean
    @Qualifier("h2")
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .addScript("classpath:test-data.sql")
                .build();
    }

    @Bean
    public SpittleRepository spittleRepository(){
        return mock(SpittleRepository.class);
    }

}
