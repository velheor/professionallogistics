package com.velheor.internship;

import com.velheor.internship.conf.PersistenceConfig;
import com.velheor.internship.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(PersistenceConfig.class);


        UserRepository userRepository = ctx.getBean(UserRepository.class);
        System.out.println(userRepository.findByEmail("123").getFirstName());
    }

}
