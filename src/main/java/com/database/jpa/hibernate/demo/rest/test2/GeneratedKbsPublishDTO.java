package com.database.jpa.hibernate.demo.rest.test2;

import java.util.List;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class GeneratedKbsPublishDTO {
  private List<PublishedKbDTO> publishedKbDtos;

  public GeneratedKbsPublishDTO() {
  }

  public GeneratedKbsPublishDTO(List<PublishedKbDTO> publishedKbDtos) {
    this.publishedKbDtos = publishedKbDtos;
  }

  public List<PublishedKbDTO> getPublishedKbDtos() {
    return publishedKbDtos;
  }

  public void setPublishedKbDtos(
      List<PublishedKbDTO> publishedKbDtos) {
    this.publishedKbDtos = publishedKbDtos;
  }
}
