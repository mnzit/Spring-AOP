package com.mnzit.learner.spring.aop.demoaop.test2;

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
public class TestMethod2 {

    public void callMe(){
        log.debug("CallMe executing");
    }

    public void callMe2(){
        log.debug("CallMe2 executing");
    }
}
