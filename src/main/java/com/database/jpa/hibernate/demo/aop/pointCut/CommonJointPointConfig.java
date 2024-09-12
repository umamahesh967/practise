//package com.database.jpa.hibernate.demo.aop.pointCut;
//
//import org.aspectj.lang.annotation.Pointcut;
//
//public class CommonJointPointConfig
//{
//
//    //The format to intercept something
//    //execution(* PACKAGE.*.*(..))
//    //first * define return type of the method.
//    //2nd * is any class
//    //3rd *(..) is for any method with any number of parameters.
//
//
//    @Pointcut("execution(* com.database.jpa.hibernate.demo.aop.data.*.*(..))") //How point cut is defined
//    public void dataLayerExecution() {}
//
//    @Pointcut("execution(* com.database.jpa.hibernate.demo.aop.business.*.*(..))")
//    public void businessLayerExecution() {}
//
//    //We can combine PointCuts and create another PointCut
//    @Pointcut("com.database.jpa.hibernate.demo.aop.pointCut.CommonJointPointConfig.dataLayerExecution() && com.database.jpa.hibernate.demo.aop.pointCut.CommonJointPointConfig.businessLayerExecution()")
//    public void allLayerExecution(){}
//
//    @Pointcut("bean(dao*)")
//    public void beanContainingDao(){}
//
//    @Pointcut("within(com.database.jpa.hibernate.demo.aop.data..*)") // For with we don't need return type i.e 1st *.
//    public void dataLayerExecutionWithIn(){}
//
//    @Pointcut("@annotation(com.database.jpa.hibernate.demo.aop.aspect.TrackTime)")
//    public void trackTimeAnnotation(){}
//}
