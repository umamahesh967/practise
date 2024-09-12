//package com.database.jpa.hibernate.demo;
//
//import com.database.jpa.hibernate.demo.entity.Course;
//import com.database.jpa.hibernate.demo.entity.Passport;
//import com.database.jpa.hibernate.demo.entity.Student;
//import com.database.jpa.hibernate.demo.forTesting.Test1;
//import com.database.jpa.hibernate.demo.forTesting.Test2;
import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Captor;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
///**
// * This runner is responsible for injecting mocks and injectmocks into the
// * class when we write @Mock and @Injectmock
// *
// * https://www.youtube.com/watch?v=2dpUw0WQqAs
// * https://www.youtube.com/watch?v=FLwGdJIRNmc&t=616s
// * https://www.youtube.com/watch?v=d2KwvXQgQx4
// */
//@RunWith(MockitoJUnitRunner.class)
//class DemoApplicationUnitTest
//{
//
//	@Mock
//	Test2 test2;
//
//	/**
//	 * This will check for all the dependencies that are present in StudentService and inject them.
//	 * StudentService is dependent on EntityManager. So EntityManager is automatically injected as mock in
//	 * studentService class.
//	 */
//	@InjectMocks
//	Test1 test1;
//
//	@Captor
//	ArgumentCaptor<Passport> argumentCaptor;
//
//	@Test
//	void contextLoads()
//	{
//		Student student = new Student();
//		student.setName("Mahesh");
//		student.setPassport(new Passport());
//
//		Mockito.when(test2.m2(Mockito.any(Passport.class))).thenReturn(student);
//		Student result = test1.m1(new Course());
//
//		ArgumentCaptor<Passport> argumentCaptor = ArgumentCaptor.forClass(Passport.class);
//		Mockito.verify(test2, Mockito.times(1)).m2(argumentCaptor.capture());
//		Passport capturedPassport = argumentCaptor.getValue();
//		//We can do assertions on capturedPassport
//
//		Assert.assertEquals("Mahesh", result.getName());
//	}
//
//}
