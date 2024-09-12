package com.database.jpa.hibernate.demo.aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * spring-aop is one of the popular implementations of AOP this is provided by spring by default,
 * but spring-aop is not as powerful as Aspectjweaver,
 *
 * you can use spring-aop to intercept any calls to beans, so any beans which are managed by this spring framework
 * you can intercept the method calls and do some things around that,
 *
 * however Aspectjweaver is much more powerful, You can even intercept change of values on a field and things like that.
 *
 * We use spring aop for tracking performance across layers, for authorizing/security across some layers.
 */
@Configuration
@Aspect //Is generally PointCut(What kind of methods to intercept) + Advice(What to do after intercepting i.e method logic)
public class UserAccessAspect
{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //What kind of method call I need to intercept is called pointcut.
    //The format to intercept something
    //execution(* PACKAGE.*.*(..))
    //first * define return type of the method.
    //2nd * is any class
    //3rd *(..) is for any method with any number of parameters.
    //The logic inside intercept method is called advice.
    //The processing of implementing the AOP around your method calls is called weaving and the framework which implements is called weaver.
    //A specific interception is called JointPoint
//
////    @Before("execution(* com.database.jpa.hibernate.demo.aop.business.*.*(..))") //PointCut - by giving the path of package for interception
//    @Before("com.database.jpa.hibernate.demo.aop.pointCut.CommonJointPointConfig.businessLayerExecution()")  //PointCut - By giving PointCut reference, defined in CommonJointPointConfig.class
//    // You can define pointCut in above two ways
//    public void intercept(JoinPoint joinPoint)
//    {
//        logger.info(" Check for user access");
//        logger.info(" Allowed execution for {}", joinPoint);
//    }

//    @Before("execution(* com.database.jpa.hibernate..*.*(..))") // Intercept all methods calls in hibernate package.
//    public void intercept1(JoinPoint joinPoint)
//    {
//        //Advice
//        logger.info(" Check for user access");
//        logger.info(" Allowed execution for {}", joinPoint);
//    }
}
