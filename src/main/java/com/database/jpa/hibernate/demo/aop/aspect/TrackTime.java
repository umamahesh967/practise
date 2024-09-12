package com.database.jpa.hibernate.demo.aop.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//Only for Methods
@Retention(RetentionPolicy.RUNTIME)//Available at Runtime
public @interface TrackTime
{

}
