package com.database.jpa.hibernate.demo.prometheus;

import io.micrometer.core.instrument.MeterRegistry;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties") //To load application.properties
public class MicroMeterApplication {
  public static void main(String[] args){
    SpringApplication.run(MicroMeterApplication.class, args);
  }

  private final ScheduledExecutorService executorService =
      Executors.newScheduledThreadPool(1);

  @Bean
  ApplicationRunner runner(MeterRegistry mr){
    return args -> {
      this.executorService.scheduleWithFixedDelay(() -> {
        long sleep = (long)(Math.random() * 1000);
        mr.timer("transform-photo-task").record(Duration.ofMillis(sleep));
      }, 500, 500, TimeUnit.SECONDS);
    };
  }

}
