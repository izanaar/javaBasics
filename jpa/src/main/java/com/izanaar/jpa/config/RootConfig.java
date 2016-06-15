package com.izanaar.jpa.config;

import com.izanaar.jpa.service.CampaignService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackageClasses = CampaignService.class)
@Import({DataSourceConfig.class, JpaConfig.class})
public class RootConfig {

}
