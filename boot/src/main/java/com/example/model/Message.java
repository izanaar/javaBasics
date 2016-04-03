package com.example.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;


@Component
@ConfigurationProperties(prefix = "message")
public class Message {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @NotEmpty
    private String text;

    @PostConstruct
    public void postConstruct(){
        logger.info("Message text: " + text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
