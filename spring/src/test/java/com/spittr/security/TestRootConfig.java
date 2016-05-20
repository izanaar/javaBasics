package com.spittr.security;

import com.spittr.data.SpittleRepository;
import com.spittr.model.Spittle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class TestRootConfig {

    @Bean
    @Qualifier("h2")
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .addScript("classpath:test-data.sql")
                .build();
    }

   /* @Bean
    public SpittleRepository spittleRepository(){
        return new SpittleRepository() {
            @Override
            public List<Spittle> getSpittles(long max, int count) {
                return null;
            }

            @Override
            public Spittle findOne(Long spittleId) {
                return null;
            }

            @Override
            public Spittle saveSpittle(Spittle spittle) {
                return null;
            }
        };
    }*/

}
