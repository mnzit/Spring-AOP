package com.mnzit.learner.spring.aop.demoaop.test;

import com.mnzit.learner.spring.aop.demoaop.annotation.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Manjit Shakya
 * @email manjit.shakya@f1soft.com
 */
@Slf4j
@Component
public class TestMethods {

    public void doSomething() {
        log.info("Inside method (EXECUTING)");
    }

    public void doSomething(String name, int age) {
        log.info("Inside method (EXECUTING) name: {}, age: {}", name, age);
    }

    @LogExecutionTime
    public void withAnnotation() {
        log.info("With Annotation Executing");
    }
}
