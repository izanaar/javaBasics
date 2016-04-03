package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PropertiesProvider {

    @Value("${prop1}")
    private String prop1;

    @Value("${overridenProp}")
    private String overridenProp;

    public String getProp1() {
        return prop1;
    }

    public String getOverridenProp() {
        return overridenProp;
    }
}
