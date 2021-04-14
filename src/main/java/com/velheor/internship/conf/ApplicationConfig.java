package com.velheor.internship.conf;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.velheor.internship")
@Import({PersistenceConfig.class, LiquiBaseConfig.class, WebConfig.class})
@RequiredArgsConstructor
public class ApplicationConfig {

    private final ApplicationContext applicationContext;
}
