package com.example.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CLineRunner implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... strings) throws Exception {
        logger.info("Command line runner says hello.");
        logger.info("Arguments: " + Arrays.stream(strings).reduce((a, b) -> a + " " + b).get());
    }
}
