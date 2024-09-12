package com.database.jpa.hibernate.demo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import java.util.Map.Entry;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Test {

  public static void main(String[] args) {
    EventEntity eventEntity = new EventEntity(1l, "test event", "ticket created");
    checkEventTriggerConditions("{ \"id\": 1, \"eventName\": \"test sevent\", \"eventType\": \"ticket created\", \"age\": 20 }", eventEntity);
  }

  public static boolean checkEventTriggerConditions(String conditions, Object payload) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      Map<String, Object> conditionsMap = objectMapper.readValue(conditions, Map.class);
      Map<String, Object> eventMap = objectMapper.readValue(
          objectMapper.writeValueAsString(payload), Map.class);
      if (eventMap != null) {
        for (Entry<String, Object> entry : conditionsMap.entrySet()) {
          if (!eventMap.containsKey(entry.getKey()) || eventMap.get(entry.getKey()) == null
              || !eventMap.get(entry.getKey()).equals(entry.getValue())) {
            return false;
          }
        }
      }
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    return true;
  }

  public static class EventEntity {

    private Long id;

    private String eventName;

    private String eventType;

    public EventEntity(Long id, String eventName, String eventType) {
      this.id = id;
      this.eventName = eventName;
      this.eventType = eventType;
    }

    public EventEntity() {
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getEventName() {
      return eventName;
    }

    public void setEventName(String eventName) {
      this.eventName = eventName;
    }

    public String getEventType() {
      return eventType;
    }

    public void setEventType(String eventType) {
      this.eventType = eventType;
    }
  }
}