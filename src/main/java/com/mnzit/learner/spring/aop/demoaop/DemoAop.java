package com.mnzit.learner.spring.aop.demoaop;

import com.mnzit.learner.spring.aop.demoaop.test.TestMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Manjit Shakya
 * @email manjit.shakya@f1soft.com
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoAop implements CommandLineRunner {

    @Autowired
    private TestMethods testMethods;

    public static void main(String[] args) {
        SpringApplication.run(DemoAop.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testMethods.doSomething();
    }
}
