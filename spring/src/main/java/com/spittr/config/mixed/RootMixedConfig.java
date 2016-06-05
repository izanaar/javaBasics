package com.spittr.config.mixed;

import com.spittr.pojo.SimpleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MixedConfig.class)
public class RootMixedConfig {

    @Bean
    public SimpleBean firstBean(){
        return new SimpleBean("First bean");
    }

}
