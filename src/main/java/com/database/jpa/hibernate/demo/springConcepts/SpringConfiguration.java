package com.database.jpa.hibernate.demo.springConcepts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration is similar to defining beans.xml
 */
//@Configuration
public class SpringConfiguration
{
    //@Component auto detects and configures the beans using classpath scanning whereas
    //@Bean explicitly declares a single bean, rather than letting Spring do it automatically.
    @Bean
    public SpringIOC springIOCBean()
    {
        return new SpringIOC();
    }
}
