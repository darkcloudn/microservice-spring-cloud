package com.darkcloudn.microservice.limitsservice;

import com.darkcloudn.microservice.limitsservice.bean.LimitsConfiguration;
import com.darkcloudn.microservice.limitsservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationController {

    @Autowired
    Configuration configuration;

    @GetMapping("/limits")
    public LimitsConfiguration retrieveLimitsFromConfigurations(){
        return new LimitsConfiguration(configuration.getMinimum(),configuration.getMaximun());
    }
}
