package com.database.jpa.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Test4 {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(targetEntity = Test1.class)
  @JoinColumn(name = "ref_id")
  private Long refId;

  @OneToOne
  @JoinColumn(name = "test_id", nullable = false)
  private Test1 testId;

  public Test4() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getRefId() {
    return refId;
  }

  public void setRefId(Long refId) {
    this.refId = refId;
  }

  public Test1 getTestId() {
    return testId;
  }

  public void setTestId(Test1 testId) {
    this.testId = testId;
  }
}
