package com.database.jpa.hibernate.demo.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.HashMap;

@Component
@ApplicationScope
public class GlobalEntity extends HashMap {
}
