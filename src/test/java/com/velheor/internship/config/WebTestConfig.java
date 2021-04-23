package com.velheor.internship.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
    "com.velheor.internship.service",
    "com.velheor.internship.mappers",
    "com.velheor.internship.controllers",
    "com.velheor.internship.security"
})
public class WebTestConfig {

}
