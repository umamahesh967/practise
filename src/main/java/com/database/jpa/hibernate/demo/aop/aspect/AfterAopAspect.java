package com.database.jpa.hibernate.demo.aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect //Is generally PointCut(What kind of methods to intercept) + Advice(What to do after intercepting)
public class AfterAopAspect
{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Commenting so that every method will not be intercepted.
     * While learning/Testing you can remove comments.
     */

//    @AfterReturning( //This will intercept only if method is successfully executed. In cases of exception it is not executed.
//            value = "execution(* com.database.jpa.hibernate.demo.aop.business.*.*(..))",
//            returning = "result"
//    )
//    public void afterReturning(JoinPoint joinPoint, Object result)
//    {
//        //Advice
//        logger.info("{} returned with value {}", joinPoint, result);
//    }
//
//    @AfterThrowing( //This will intercept only if exception is thrown in method.
//            value = "execution(* com.database.jpa.hibernate.demo.aop.business.*.*(..))",
//            throwing = "exception"
//    )
//    public void afterThrowing(JoinPoint joinPoint, Object exception)
//    {
//        //Advice
//        logger.info("{} throw exception {}", joinPoint, exception);
//    }
//
//    @After( //This will intercept whether exception is thrown or method is successfully executed.
//            value = "execution(* com.database.jpa.hibernate.demo.aop.business.*.*(..))"
//    )
//    public void after(JoinPoint joinPoint)
//    {
//        //Advice
//        logger.info("Intercepted after {}", joinPoint);
//    }
}
