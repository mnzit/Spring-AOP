package com.mnzit.learner.spring.aop.demoaop;

import com.mnzit.learner.spring.aop.demoaop.test.TestMethods;
import com.mnzit.learner.spring.aop.demoaop.test2.TestMethod2;
import com.mnzit.learner.spring.aop.demoaop.test2.inner.TestMethod2Inner;
import org.slf4j.MDC;
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
    private TestMethods testMethods;

    @Autowired
    private TestMethod2 testMethod2;

    @Autowired
    private TestMethod2Inner testMethod2Inner;

    public static void main(String[] args) {
        SpringApplication.run(DemoAop.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        MDC.put("username", "Manjit");
        MDC.put("mobileNumber", "9808546858");
        MDC.put("email", "manjit.shakya@f1soft.com");

//        testMethods.doSomething();
//        testMethods.doSomething("Manjit", 23);
//        testMethods.withAnnotation();

        testMethod2.callMe();
        testMethod2.callMe2();

        testMethod2Inner.callMe();
        testMethod2Inner.callMe2();
    }

}
