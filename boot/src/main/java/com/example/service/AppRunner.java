package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component
public class AppRunner implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        logger.info("Application  runner says hello.");
        logger.info("Arguments: " + (applicationArguments.getOptionNames().stream().reduce((a, b) -> a + " " + b).get()));
    }
}
