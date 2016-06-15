package com.izanaar.jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataSourceConfig.class, JpaConfig.class})
public class RootConfig {

}
