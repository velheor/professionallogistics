package com.velheor.internship.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.velheor.internship")
@Import({PersistenceConfig.class, LiquiBaseConfig.class})
public class ApplicationConfig {

}
