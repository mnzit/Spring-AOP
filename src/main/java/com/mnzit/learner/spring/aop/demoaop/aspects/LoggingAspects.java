package com.mnzit.learner.spring.aop.demoaop.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

/**
 * @author Manjit Shakya
 * @email manjit.shakya@f1soft.com
 */
@Component
@Aspect
@Slf4j
public class LoggingAspects {

//    @Before("execution(* doSomething(..))")
//    public void methodEnteringLog(JoinPoint joinPoint) {
//        log.debug("@Before methodEnteringLog");
////
////        log.debug("joinPoint.getTarget() : {}", joinPoint.getTarget());
////        log.debug("joinPoint.getThis() : {}", joinPoint.getThis());
////
////        log.debug("joinPoint.getStaticPart().getSignature().toString() : {}", joinPoint.getStaticPart().getSignature().toString());
////        log.debug("joinPoint.getStaticPart().getSignature().toShortString() : {}", joinPoint.getStaticPart().getSignature().toShortString());
////        log.debug("joinPoint.getStaticPart().getSignature().toLongString() : {}", joinPoint.getStaticPart().getSignature().toLongString());
////        log.debug("joinPoint.getStaticPart().getKind() : {}", joinPoint.getStaticPart().getKind());
//
//        log.debug("Entering doSomething");
//    }

    @Around("execution(* doSomething(..))")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.debug("@Around aroundMethod");
//
//        log.debug("joinPoint.getTarget() : {}", proceedingJoinPoint.getTarget());
//        log.debug("joinPoint.getThis() : {}", proceedingJoinPoint.getThis());
//
//        log.debug("joinPoint.getStaticPart().getSignature().toString() : {}", proceedingJoinPoint.getStaticPart().getSignature().toString());
//        log.debug("joinPoint.getStaticPart().getSignature().toShortString() : {}", proceedingJoinPoint.getStaticPart().getSignature().toShortString());
//        log.debug("joinPoint.getStaticPart().getSignature().toLongString() : {}", proceedingJoinPoint.getStaticPart().getSignature().toLongString());
//        log.debug("joinPoint.getStaticPart().getKind() : {}", proceedingJoinPoint.getStaticPart().getKind());

        log.debug("Entering doSomething");

        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable ex) {
            log.error("Exception in : {} {}", proceedingJoinPoint.getStaticPart().toShortString(), ex);
            throw ex;
        } finally {
            log.info("Exiting : {}", proceedingJoinPoint.getStaticPart());
        }
    }

    private Method getCurrentMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod();
    }

//    @After("execution(* doSomething(..))")
//    public void afterEnteringMethod(JoinPoint joinPoint) {
//        log.debug("@After afterEnteringMethod");
////
////        log.debug("joinPoint.getTarget() : {}", joinPoint.getTarget());
////        log.debug("joinPoint.getThis() : {}", joinPoint.getThis());
////
////        log.debug("joinPoint.getStaticPart().getSignature().toString() : {}", joinPoint.getStaticPart().getSignature().toString());
////        log.debug("joinPoint.getStaticPart().getSignature().toShortString() : {}", joinPoint.getStaticPart().getSignature().toShortString());
////        log.debug("joinPoint.getStaticPart().getSignature().toLongString() : {}", joinPoint.getStaticPart().getSignature().toLongString());
////        log.debug("joinPoint.getStaticPart().getKind() : {}", joinPoint.getStaticPart().getKind());
//
//        log.debug("Entering doSomething");
//    }

    @Pointcut("@annotation(com.mnzit.learner.spring.aop.demoaop.annotation.LogExecutionTime)")
    public void annotatedMethod() {
    }

    @Pointcut("within(com.mnzit.learner.spring.aop.demoaop.test2.*)")
    // matched all the methods within all method of class in given package com.mnzit.learner.spring.aop.demoaop.test2.*
    public void withinType() {
    }

    @Pointcut("within(com.mnzit.learner.spring.aop.demoaop.test2..*)")
    // matched all the methods within all method of class in given package and subpackage com.mnzit.learner.spring.aop.demoaop.test2..*
    public void withinType2() {
    }

    @Pointcut("execution(* (@com.mnzit.learner.spring.aop.demoaop.annotation.LogExecutionTime *).*(..))")
    //class must be annotated
    public void executionAnnotated4() {
    }


    @Pointcut("execution(@com.mnzit.learner.spring.aop.demoaop.annotation.LogExecutionTime * *(..))")
    // method must be annotated
    public void executionAnnotated3() {
    }

    @Pointcut("execution(* com.mnzit..*(..))")
    // any return type from package with com.mnzit , any sub package, any method, any number of parameters
    public void execution2() {
    }

    @Pointcut("execution(* com.mnzit..*(*))")
    // any return type from package with com.mnzit , any sub package, any method, one parameter
    public void execution1() {
    }

//    @Pointcut("execution(* *.*(..))") // any return type, any package , any subclass, any method, one parameter //doesnt work
//    @Pointcut("execution(* *..*(..))") // any return type, any package or subpackage, any method, one parameter //doesnt work
//    @Pointcut("execution(* *..*(..))") // any return type, any package or subpackage, any method, one parameter //doesnt work

    @Around("withinType()")  // method must be annotated
    public Object methodTimeLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        // Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        // Measure method execution time
        StopWatch stopWatch = new StopWatch(className + "->" + methodName);
        stopWatch.start(methodName);
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
        // Log method execution time
        log.info(stopWatch.prettyPrint());
        return result;
    }

    //    Support for sub packages is provided with “..”
    @Before("within(*..*TestMethod2)")
    public void afterEnteringMethod2(JoinPoint joinPoint) {
//        log.debug("@After afterEnteringMethod2");
//
//        log.debug("joinPoint.getTarget() : {}", joinPoint.getTarget());
//        log.debug("joinPoint.getThis() : {}", joinPoint.getThis());
//
//        log.debug("joinPoint.getStaticPart().getSignature().toString() : {}", joinPoint.getStaticPart().getSignature().toString());
//        log.debug("joinPoint.getStaticPart().getSignature().toShortString() : {}", joinPoint.getStaticPart().getSignature().toShortString());
//        log.debug("joinPoint.getStaticPart().getSignature().toLongString() : {}", joinPoint.getStaticPart().getSignature().toLongString());
//        log.debug("joinPoint.getStaticPart().getKind() : {}", joinPoint.getStaticPart().getKind());

//        log.debug("Entering TestMethod2");
    }

}
