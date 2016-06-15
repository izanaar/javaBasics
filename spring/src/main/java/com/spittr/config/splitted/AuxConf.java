package com.spittr.config.splitted;

import com.spittr.model.SimpleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuxConf {

    @Bean
    public SimpleBean javAuxConfigBean(){
        return new SimpleBean("Java-configured bean.");
    }

}
