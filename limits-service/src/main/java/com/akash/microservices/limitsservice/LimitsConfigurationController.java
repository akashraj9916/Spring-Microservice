package com.akash.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping(value = "/limits")
    public LimitConfiguration getLimitsConfiguration(){
        return new LimitConfiguration(configuration.getMinimum(),configuration.getMaximum());
    }
}
