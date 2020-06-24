package com.mnzit.learner.spring.aop.demoaop;

import com.mnzit.learner.spring.aop.demoaop.test.TestAOP;
import com.mnzit.learner.spring.aop.demoaop.test.subtest.SubTestAOP;
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
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DemoAop implements CommandLineRunner {

    @Autowired
    private TestAOP testAOP;

    @Autowired
    private SubTestAOP subTestAOP;

    public static void main(String[] args) {
        SpringApplication.run(DemoAop.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        testAOP.testPublicInt();
        testAOP.testPublicIntInt(1);
        testAOP.testPublicVoid();
        testAOP.testPublicVoidInt(1);

        subTestAOP.subTestPublicVoid();
    }

}
