package com.database.jpa.hibernate.demo.practiseSpring;

import com.database.jpa.hibernate.demo.entity.Course;
import com.database.jpa.hibernate.demo.entity.GlobalEntity;
import com.database.jpa.hibernate.demo.restTemplate.FetchAllEmployees;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class SampleTestRestController
{

    private static Logger logger = LoggerFactory.getLogger(SampleTestRestController.class);

    @Autowired
    FetchAllEmployees fetchAllEmployees;

    @Autowired
    TestService testService;

    @Autowired
    GlobalEntity globalEntity;

    @GetMapping(value = "/findAll")
//    @RequestMapping(value = "/findAll", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
    public List<Course> findAllCourses()
    {
        return testService.findAll();
    }

    @GetMapping(value = "/findCourse/{courseId}")
    public Course findCourse(@PathVariable("courseId") String name)
    {
        logger.debug(name);
        return testService.find(name);
    }

    @GetMapping(value = "/findCourseByParam")
    public ResponseEntity<Course> findCourseByParam(@RequestParam("courseName") String name)
    {
        logger.debug(name);
        return new ResponseEntity<Course>(testService.find(name),
                HttpStatus.OK);

    }

    @GetMapping(value = "/findCourse")
    public Course saveCourse()
    {
        globalEntity.put(1,1);
        return testService.find("Course in 50 Steps");
    }

    @PostMapping(value = "/save")
    public Course saveCourse1(@RequestBody Course course)
    {
        fetchAllEmployees.fetchAllCourses();
        logger.info(course.toString());
        return testService.createCourse(course);
    }

    @GetMapping(value = "/test")
    public Course test()
    {
       return fetchAllEmployees.fetchAllCourses();
    }
}
