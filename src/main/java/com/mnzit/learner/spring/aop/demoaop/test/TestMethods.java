package com.mnzit.learner.spring.aop.demoaop.test;

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
        System.out.println("Doing Something" + (2 * 10));
    }
}
