package com.spittr.config.splitted;

import com.spittr.model.SimpleBean;
import org.hibernate.service.spi.InjectService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:auxXmlConf.xml")
public class RootConf {

    @Bean
    public SimpleBean firstBean(){
        return new SimpleBean("First bean.");
    }

}
