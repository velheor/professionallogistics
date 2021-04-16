package com.velheor.internship.conf;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.velheor.internship")
@RequiredArgsConstructor
public class ApplicationConfig {

    private final ApplicationContext applicationContext;
}
