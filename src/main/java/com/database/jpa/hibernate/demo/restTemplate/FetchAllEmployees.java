package com.database.jpa.hibernate.demo.restTemplate;

import com.database.jpa.hibernate.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;

// Go through ShipmentStrategyClientServiceImplBase.class in Shipment Component.
// https://www.baeldung.com/rest-template

@Component
public class FetchAllEmployees
{


    RestTemplate restTemplate = new RestTemplate();

    public Course fetchAllCourses()
    {
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl();

        //In httpEntity Course is the request body type and HttpHeader will contain headers;
        HttpEntity httpEntity = new HttpEntity<Course>(new HttpHeaders());

//        restTemplate.getForObject("http://localhost:8080/test/findCourse",Course.class);

        ResponseEntity<Course> responseEntity = restTemplate
                                .exchange("http://localhost:8080/test/findCourse",
                                        HttpMethod.GET, null, Course.class);
        return  responseEntity.getBody();
    }
}
