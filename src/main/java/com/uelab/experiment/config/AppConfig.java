package com.uelab.experiment.config;

import com.uelab.experiment.service.BusinessLogic;
import com.uelab.experiment.service.impl.SampleLogicImpl;
import com.uelab.experiment.service.impl.TestLogicImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "test")
    public BusinessLogic dummyLogicName1() {
        return new TestLogicImpl();
    }

    @Bean(name = "sample")
    public BusinessLogic dummyLogicName2() {
        return new SampleLogicImpl();
    }
}
