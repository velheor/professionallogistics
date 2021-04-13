package com.velheor.internship;

import com.velheor.internship.conf.ApplicationConfig;
import com.velheor.internship.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        UserService userService = ctx.getBean(UserService.class);
        System.out.println(userService.findByEmail("pet@gmail.com"));
    }
}
