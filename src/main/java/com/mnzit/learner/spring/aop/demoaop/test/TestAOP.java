package com.mnzit.learner.spring.aop.demoaop.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Manjit Shakya
 * @email manjit.shakya@f1soft.com
 */
@Slf4j
@Component
public class TestAOP {

    public void testPublicVoid() {
        log.debug("testPublicVoid");
    }

    public int testPublicInt() {
        log.debug("testPublicInt");
        return 1;
    }

    public void testPublicVoidInt(int i) {
        log.debug("testPublicVoidInt");
    }

    public int testPublicIntInt(int i) {
        log.debug("testPublicIntInt");
        return 1;
    }
}
