package com.spittr.security;

import com.spittr.data.SpittleRepository;
import com.spittr.model.Spittle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TestRootConfig {

    @Bean
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
    }

}
