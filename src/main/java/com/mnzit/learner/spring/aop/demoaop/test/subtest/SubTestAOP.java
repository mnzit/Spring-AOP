package com.mnzit.learner.spring.aop.demoaop.test.subtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Manjit Shakya
 * @email manjit.shakya@f1soft.com
 */
@Slf4j
@Component
public class SubTestAOP {

    public void subTestPublicVoid() {
        log.debug("subTestPublicVoid");
    }
}