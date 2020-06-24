package com.mnzit.learner.spring.aop.demoaop.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Manjit Shakya
 * @email manjit.shakya@f1soft.com
 */
@Component
@Aspect
@Slf4j
public class LoggingAspects2 {

    @Pointcut("execution(public * *(..))")
    public void anyPublicMethod() {
    }
}
