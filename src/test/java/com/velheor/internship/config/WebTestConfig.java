package com.velheor.internship.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.velheor.internship.security",
        "com.velheor.internship.mappers"
})
public class WebTestConfig {

}
