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

    @AfterThrowing(pointcut = "applicationPackagePointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint jointPoint, Throwable e) {
        logger.error("Exception in {}.{}() with cause = {}", jointPoint.getSignature().getDeclaringTypeName(),
                jointPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
    }

    @AfterReturning("applicationPackagePointcut()")
    public void logAfterReturning(JoinPoint joinPoint) {
        logger.info("begin");
        logger.info(joinPoint.getTarget().toString());
        logger.info(joinPoint.getTarget().getClass().getName());
        logger.info(joinPoint.getSignature().getName());
        logger.info(joinPoint.getSignature().getDeclaringTypeName());
        logger.info(joinPoint.getSignature().getDeclaringType().getName());
        logger.info(joinPoint.getArgs().toString());
        logger.info(joinPoint.getThis().toString());
        logger.info("Testing this theory {} + {}", 1, 3);
        logger.info("end");
    }
}
