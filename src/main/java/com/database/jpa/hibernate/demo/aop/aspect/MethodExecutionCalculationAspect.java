package com.database.jpa.hibernate.demo.aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect //Is generally PointCut(What kind of methods to intercept) + Advice(What to do after intercepting)
public class MethodExecutionCalculationAspect
{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Around(value = "execution(* com.database.jpa.hibernate.demo.aop.business.*.*(..))")
//    public void afterReturning(ProceedingJoinPoint joinPoint) throws Throwable {
//        long startTime  = System.currentTimeMillis();
//        Object result = joinPoint.proceed();
//        long endTime  = System.currentTimeMillis();
//        long timeTaken =  endTime - startTime;
//        logger.info("TimeTaken by {} is {}", joinPoint, timeTaken);
//        return result;
//    }


//    @Around("com.database.jpa.hibernate.demo.aop.pointCut.CommonJointPointConfig.trackTimeAnnotation()")
//    //Above pointCut helps us track those methods which has @TrackTime annotation on methods in Project.
//    public Object afterReturning(ProceedingJoinPoint joinPoint) throws Throwable {
//        long startTime  = System.currentTimeMillis();
//        Object result = joinPoint.proceed();
//        long endTime  = System.currentTimeMillis();
//        long timeTaken =  endTime - startTime;
//        logger.info("TimeTaken by {} is {}", joinPoint, timeTaken);
//        return result; // Always should
//    }

}
