package com.database.jpa.hibernate.demo.entity;

import javax.persistence.Embeddable;

/**
 * If you want an object to embedded in another entity. we uses Embeddable.
 */
@Embeddable
public class Address
{
    private String line1;
    private String line2;
    private String city;

    public Address() {
    }

    public Address(String line1, String line2, String city) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
    }
}
