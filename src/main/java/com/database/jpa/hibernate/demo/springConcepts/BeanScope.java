package com.database.jpa.hibernate.demo.springConcepts;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

/**
 * Singleton scope:- One Instance per SpringContext. By default it is singleton.
 * Prototype scope:- New bean created whenever requested
 * Request scope:- One bean created per HTTP request
 * Session scope:- One bean created per session.
 *
 *
 * Difference between GOF singleton and SpringSingleton
 * GOF singleton:- Once Instance per JVM.
 * SpringSingleton:- One Instance per ApplicationContext
 *
 * In JVM can have multiple ApplicationContext also.
 *
 * https://www.youtube.com/watch?v=NnNvDknQJt0&list=PLC97BDEFDCDD169D7&index=11
 */
@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@RequestScope
//@SessionScope
public class BeanScope {
}
