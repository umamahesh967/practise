//package com.database.jpa.hibernate.demo.hystrix;
//
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/hystrix")
//public class HystrixTestController
//{
//    @RequestMapping(value = "/")
//    @HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//    })
//    public String hello() throws InterruptedException {
//        Thread.sleep(3000);
//        return "Welcome Hystrix";
//    }
//    private String fallback_hello() {
//        return "Request fails. It takes long time to response";
//    }
//}

/**
 * 1. Timing out calls if time taken by downstream service is greater than certain threshold
 * 2. Reject request when Thread pool is full
 * 3. Disconnect the service if errors percentage is greater than certain threshold
 * 4. Fall back to default response.
 * 5. Metrics (Latency, performance)
 */