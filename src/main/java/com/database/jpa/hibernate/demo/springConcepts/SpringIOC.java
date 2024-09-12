package com.database.jpa.hibernate.demo.springConcepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * The interface org.springframework.context.ApplicationContext represents the Spring IoC container
 * and is responsible for instantiating, configuring, and assembling the aforementioned beans.
 * The container gets its instructions on what objects to instantiate, configure, and assemble by reading
 * configuration metadata. The configuration metadata is represented in XML, Java annotations, or Java code.
 * It allows you to express the objects that compose your application and
 * the rich interdependencies between such objects.
 *
 *
 * The org.springframework.beans and org.springframework.context packages are the basis for
 * Spring Framework's IoC container. The BeanFactory interface provides an advanced configuration
 * mechanism capable of managing any type of object. ApplicationContext is a sub-interface of BeanFactory.
 *
 *
 * In short, the BeanFactory provides the configuration framework and basic functionality, and the
 * ApplicationContext adds more enterprise-specific functionality. The ApplicationContext is a complete
 * superset of the BeanFactory,
 *
 * In Spring, the objects that form the backbone of your application and that are managed by the
 * Spring IoC container are called beans. A bean is an object that is instantiated, assembled,
 * and otherwise managed by a Spring IoC container. Otherwise, a bean is simply one of many objects
 * in your application. Beans, and the dependencies among them, are reflected in the configuration
 * metadata used by a container.
 *
 * Several implementations of the ApplicationContext interface are supplied out-of-the-box with Spring.
 * In standalone applications it is common to create an instance of ClassPathXmlApplicationContext or
 * FileSystemXmlApplicationContext. While XML has been the traditional format for defining configuration
 * metadata you can instruct the container to use Java annotations or code as the metadata format by providing
 * a small amount of XML configuration to declaratively enable support for these additional metadata formats.
 *
 * https://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/beans.html
 *
 *@Primary Annotation
 * https://udemy.com/course/spring-tutorial-for-beginners/learn/lecture/7725676#overview
 *
 *
 *@SpringIOC: IOC means Inversion of Control. It means, rather than we creating the java objects,
 * spring will create the objects.
 * Spring IOC container will manage the complete lifecycle of Bean Object right from Creation,
 * Initialization and destruction .
 *
 *
 *@SpringBean: In spring terminology, Actually those java object which is created and
 * managed by ioc container is called spring bean.
 *
 *@DependencyInjection: Dependency Injection is a fundamental aspect of the Spring framework,
 * through which the Spring container "injects" objects into other objects or "dependencies".
 * Simply put, this allows for loose coupling of components and moves the responsibility of managing
 * components onto the container.
 *
 * DI provides objects that an object needs. So rather than the dependencies construct
 * themselves they are injected.
 *
 * Very Very Good article for IOC and DI
 * https://stackoverflow.com/questions/9403155/what-is-dependency-injection-and-inversion-of-control-in-spring-framework
 *
 * IoC is achieved through DI. DI is the process of providing the dependencies
 * and IoC is the end result of DI. (Note: DI is not the only way to
 * achieve IoC. There are other ways as well. Go through above article.)
 *
 * IOC stands for inversion of control and is a higher level concept that states that we
 * invert the control of the creation of objects from the caller to the callee.
 * Without inversion of control, you are in charge of the creation of objects. In an inversion of
 * control scenario a framework is in charge to create instances of a class.
 * Dependency injection is the method through which we can achieve inversion of control. In order for
 * us to leave the control up to the framework or job we declare dependencies and the IOC container
 * injects those dependencies in our class (i.e. the framework creates an instance for us and provides
 * that to our class).
 *
 *
 *
 */

@Component
@SpringBootApplication
public class SpringIOC
{
    public static void main(String[] args)
    {
        ApplicationContext context = SpringApplication.run(SpringIOC.class, args);
        DI test = context.getBean(DI.class);

        Queue<Integer> priorityQueue = new PriorityQueue<>();
    }


}
