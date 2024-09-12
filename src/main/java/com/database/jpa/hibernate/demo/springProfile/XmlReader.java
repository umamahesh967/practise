package com.database.jpa.hibernate.demo.springProfile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("xml-reader")
public class XmlReader implements Reader
{
    @Override
    public void read()
    {
        System.out.println("Xml Reader");
    }
}
