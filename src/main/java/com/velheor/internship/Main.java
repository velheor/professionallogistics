package com.velheor.internship;

import com.velheor.internship.service.impl.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.velheor.internship")
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);

        UserService userService = ctx.getBean(UserService.class);
        System.out.println(userService.findByEmail("iv@gmail.com").getFirstName());
    }

}
