package com.spittr.config.mixed;

import com.spittr.pojo.SimpleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:context.xml")
public class MixedConfig {

    @Bean
    public SimpleBean secondBean(){
        return new SimpleBean("Second bean");
    }

}
