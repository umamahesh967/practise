package com.database.jpa.hibernate.demo.springProfile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("pdf-reader")
public class PdfReader implements Reader
{
    @Override
    public void read()
    {
        System.out.println("Xml Reader");
    }
}
