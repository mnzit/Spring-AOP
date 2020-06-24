package com.mnzit.learner.spring.aop.demoaop.test2.inner;

import com.mnzit.learner.spring.aop.demoaop.annotation.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Manjit Shakya
 * @email manjit.shakya@f1soft.com
 */
@Slf4j
@Component
@LogExecutionTime
public class TestMethod2Inner {

    public void callMe(){
        log.debug(" TestMethod2Inner CallMe executing");
    }

    public void callMe2(){
        log.debug(" TestMethod2Inner CallMe2 executing");
    }
}
