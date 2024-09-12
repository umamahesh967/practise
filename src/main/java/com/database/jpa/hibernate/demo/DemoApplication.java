package com.database.jpa.hibernate.demo;

import com.database.jpa.hibernate.demo.aop.business.Business1;
import com.database.jpa.hibernate.demo.aop.business.Business2;
import com.database.jpa.hibernate.demo.cacheable.CacheRelated;
import com.database.jpa.hibernate.demo.jpql.JPQLNamedTest;
import com.database.jpa.hibernate.demo.jpql.JPQLTest;
import com.database.jpa.hibernate.demo.nativeQuery.NativeQuery;
import com.database.jpa.hibernate.demo.repository.CourseRepository;
import com.database.jpa.hibernate.demo.repository.EmployeeRepository;
import com.database.jpa.hibernate.demo.repository.StudentRepository;
import com.database.jpa.hibernate.demo.service.StudentService;
import com.database.jpa.hibernate.demo.service.TestPropagation;
import com.database.jpa.hibernate.demo.springConcepts.DI;
import com.database.jpa.hibernate.demo.springDataJPA.CourseSpringDataJpaService;
import io.micrometer.core.instrument.MeterRegistry;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
//@EnableSwagger2
@PropertySource("classpath:application.properties") //To load application.properties
//@EnableHystrix
//@ComponentScan({ "com.database.jpa.hibernate.demo.*" })
public class DemoApplication implements CommandLineRunner
{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired(required=true)
	CourseRepository courseRepository;

	@Autowired
	JPQLTest jpqlTest;

	@Autowired
	JPQLNamedTest jpqlNamedTest;

	@Autowired
	NativeQuery nativeQuery;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	StudentService studentService;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	TestPropagation testPropagation;

	@Autowired
	Business1 business1;

	@Autowired
	Business2 business2;

	@Autowired
	CourseSpringDataJpaService courseSpringDataJpaService;

	@Autowired
	DI di;

	@Autowired
	MeterRegistry meterRegistry;

	@Autowired
	CacheRelated cacheRelated;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);;
	}

	private final ScheduledExecutorService executorService =
			Executors.newScheduledThreadPool(1);

//	@Bean
//	ApplicationRunner runner(MeterRegistry mr){
//		System.out.println("Println Runner");
//		return args -> {
//			this.executorService.scheduleWithFixedDelay(() -> {
//				long sleep = (long)(Math.random() * 1000);
//				mr.timer("transform-photo-task").record(Duration.ofMillis(sleep));
//			}, 500, 500, TimeUnit.MILLISECONDS);
//		};
//	}

	@Override
	public void run(String... args) throws Exception
	{
//		testJPA();
//		testSpringDataJpa();
//		testSpringProfiles();
//		testAspectj();

		logger.trace("This is a TRACE log");
		logger.debug("This is a DEBUG log");
		logger.info("This is an INFO log");
		logger.error("This is an ERROR log");

		System.out.println("Println Runner");
		this.executorService.scheduleWithFixedDelay(() -> {
			long sleep = (long)(Math.random() * 1000);
			meterRegistry.timer("transform-photo-task").record(Duration.ofMillis(sleep));
		}, 500, 500, TimeUnit.MILLISECONDS);


		testCache();
	}

	private void testSpringDataJpa()
	{
//		courseSpringDataJpaService.saveCourse();
		courseSpringDataJpaService.playIngAroundWithSpringDataJPA();
//		courseSpringDataJpaService.playIngAroundWithSpringDataJPACache();
		courseSpringDataJpaService.sort();
	}

	private void testCache()
	{
//		cacheRelated.playIngAroundWithSpringDataJPACache();
	}

	public void testJPA()
	{
//		logger.info("details of the course: {}", courseRepository.findById(10001L));
//		courseRepository.deleteById(10001L);
//		logger.info("New Course: {}", courseRepository.save(new Course("New Course")));
		try {
//			courseRepository.playWithEntityManager();
		}
		catch (Exception e){}
//		courseRepository.playWithEntityManager2();
//		courseRepository.playWithEntityManager3();
//		courseRepository.playWithEntityManager4();
//		courseRepository.playWithEntityManager5();
//
//		courseRepository.addReviewsForCourse(10003L, Arrays.asList(new Review("5", "Great Stuff"),
//				new Review("5", "Hastoff.")));

//		jpqlTest.findById_where();

//		jpqlNamedTest.jpqlNamed_basic2();

//		nativeQuery.nativeQuery_basic();
//		nativeQuery.nativeQuery_basic2();
//		nativeQuery.nativeQuery_parameterPosition_basic3();
//		nativeQuery.nativeQuery_namedParameter_basic4();
//		nativeQuery.nativeQuery_update();
//		studentRepository.saveStudentWithPassport();

//		studentService.retrieveStudentAndPassportDetails();
//		studentService.someOperationToUnderstandPersistenceContext();
//		studentService.retrievePassportAndStudentDetails();



//		studentRepository.retrieveStudentAndCourses();
//		studentRepository.insertHardcodedStudentAndCourse();
//		studentRepository.insertStudentAndCourse(new Student("Jack"), new Course("Microservices in 100 Steps"));

//		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
//		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
//
//		logger.info("Full Time Employees -> {}",
//				employeeRepository.retrieveAllFullTimeEmployees());
//
//		logger.info("Part Time Employees -> {}",
//				employeeRepository.retrieveAllPartTimeEmployees());

//		jpqlTest.jpql_courses_without_students();
//		courseRepository.saveCourse();
//		testPropagation.testSample();
	}

	public void testSpringProfiles()
	{
//		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//		context.getEnvironment().setActiveProfiles("pdf-reader");
//		context.register(Configuration.class);
//		context.refresh();
//		context.getBean(Reader.class).read();
//		context.close();
	}

	public void testAspectj()
	{
		logger.info(business1.calculateSomething());
		logger.info(business2.calculateSomething());
	}

	public void testAutoWiring()
	{

	}
}
