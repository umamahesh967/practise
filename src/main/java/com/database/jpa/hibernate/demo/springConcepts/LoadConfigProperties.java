package com.database.jpa.hibernate.demo.springConcepts;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * https://www.baeldung.com/configuration-properties-in-spring-boot
 */
@Configuration
@ConfigurationProperties(prefix = "username")
public class LoadConfigProperties {

    private String name;
    private String email;
    // standard getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
