package com.tkapps.social.service.message.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.tkapps.social.service.message.controller..*)")
    public void applicationPackagePointcut() {

    }

    @Before("applicationPackagePointcut()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("This is before the method");
    }

    @After("applicationPackagePointcut()")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("This is after the method");
    }

    @AfterThrowing("applicationPackagePointcut()")
    public void logAfterThrowing(JoinPoint jointPoint) {
        logger.info("This is after throwing an error");
    }

    @AfterReturning("applicationPackagePointcut()")
    public void logAfterReturning(JoinPoint joinPoint) {
        logger.info("This is after returning");
        logger.info(joinPoint.getSignature().getName());
        logger.info(joinPoint.getSignature().getDeclaringTypeName());
        logger.info(joinPoint.getSignature().getClass().getName());
        logger.info(Arrays.toString(joinPoint.getArgs()));
    }
}
