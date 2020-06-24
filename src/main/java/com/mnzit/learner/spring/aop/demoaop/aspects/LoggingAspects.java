package com.mnzit.learner.spring.aop.demoaop.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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
public class LoggingAspects {
    /**
     * This doesn't work because
     * Pointcut is so generic
     *
     * @Reference: https://stackoverflow.com/questions/36775611/problems-with-aop-in-spring-boot/36775787#36775787
     */
    @Pointcut("execution(public * *(..))")
    private void allPublicMethods() {
    }

    /**
     * Matching all public methods in TransferService
     * Use public keyword in start, use * to match any return type.
     */
    @Pointcut("execution(public * com.mnzit.learner.spring.aop.demoaop.test.TestAOP.*(..))")
    private void anyPublicMethodOfGivenClass() {
    }

    /**
     * Works with public access modifier, any return type, from package com.mnzit, supports sub-packages, any no of parameters
     * (For all Methods in any Class in given package or subpackage)
     */
    @Pointcut("execution(public * com.mnzit.learner.spring.aop.demoaop.test..*(..))")
    private void anyPublicOperationInPackageAndItsSubPackages() {
    }

    /**
     * Matching any method defined in the service package or it’s sub-packages
     * Use * in start to match any return type, use two dots after service package means it’s include sub-packages as well, use second * to match any class name and use another * to match any method name.
     */
    @Pointcut("execution(* com.mnzit.learner.spring.aop.demoaop.test..*.*(..))")
    public void anyMethodInServicePackageAndSubPackages() {

    }

    /**
     * Matching any method defined in the service package
     * Use * in start to match any return type, use second * to match any class name and use another * to match any method name.
     */
    @Pointcut("execution(public * com.mnzit.*.*(..))")
    private void anyPublicOperationInPackage() {
    }

    /**
     * Matching all methods defined in classes inside package com.mnzit.learner.spring.aop.demoaop and it’s sub-packages
     * sub-packages use two dots.
     */
    @Pointcut("within(com.mnzit.learner.spring.aop.demoaop.test..*)")
    private void allMethodInGivenPackageAndItsSubPackages() {
    }

    /**
     * Matching all methods defined in classes inside package com.mnzit.learner.spring.aop.demoaop
     * sub-packages use two dots.
     */
    @Pointcut("within(com.mnzit.learner.spring.aop.demoaop.test.*)")
    private void allMethodInGivenPackages() {
    }


    @Around("allMethodInGivenPackages()")
    public Object customAOPInterceptor(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.debug("the execution of any public method: {}", proceedingJoinPoint.getStaticPart().toShortString());
        return proceedingJoinPoint.proceed();
    }
}
