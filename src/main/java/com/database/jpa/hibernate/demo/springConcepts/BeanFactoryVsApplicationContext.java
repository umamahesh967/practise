package com.database.jpa.hibernate.demo.springConcepts;

/**
 * One difference between BeanFactory and ApplicationContext is that former only instantiate bean
 * when you call getBean() method while ApplicationContext instantiates Singleton bean when the
 * container is started, It doesn't wait for getBean to be called.
 *
 * b.ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
 *  or
 * ApplicationContext context = new ClassPathXmlApplicationContext{"spring_dao.xml","spring_service.xml};
 *
 * You can use one or more xml file depending on your project requirement. As I am here
 * using two xml files i.e. one for configuration details for service classes other for dao classes.
 * Here ClassPathXmlApplicationContext is child of ApplicationContext.
 *
 * c. BeanFactory Container is basic container, it can only create objects and
 * inject Dependencies. But we can’t attach other services like security, transaction, messaging , Spring AOP etc.
 * to provide all the services we have to use ApplicationContext Container.
 *
 * d. BeanFactory doesn't provide support for internationalization i.e. i18n but ApplicationContext
 * provides support for it.
 *
 * e. BeanFactory Container doesn't support the feature
 * of AutoScanning (Support Annotation based dependency Injection), but ApplicationContext Container supports.
 *
 * f. Beanfactory Container will not create a bean object until the request time.
 * It means Beanfactory Container loads beans lazily. While ApplicationContext Container creates objects of Singleton bean at the
 * time of loading only. It means there is early loading.
 *
 * g. Beanfactory Container support only two scopes (singleton & prototype) of the beans.
 * But ApplicationContext Container supports all the beans scope.
 * https://www.journaldev.com/21039/spring-bean-scopes
 *
 * One of the popular implementation of BeanFactory interface is XMLBeanFactory while one of
 * the popular implementation of ApplicationContext interface is ClassPathXmlApplicationContext.
 *
 * Another difference between BeanFactory vs ApplicationContext is ability to publish event to beans
 * that are registered as listener.
 *
 * https://www.javatpoint.com/q/6334/difference-between-applicationcontext-and-beanfactory-in-spring
 *
 * https://stackoverflow.com/questions/243385/beanfactory-vs-applicationcontext#:~:text=BeanFactory%20Container%20is%20basic%20container,create%20objects%20and%20inject%20Dependencies.&text=Beanfactory%20Container%20will%20not%20create,the%20time%20of%20loading%20only.
 */
public class BeanFactoryVsApplicationContext {
}
