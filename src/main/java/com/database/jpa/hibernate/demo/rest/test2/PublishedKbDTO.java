package com.database.jpa.hibernate.demo.rest.test2;

//import com.aisera.common.enums.GeneratedKbPublishStatus;

import java.util.Optional;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class PublishedKbDTO {

  private Long sourceDocumentKey;
  private Long dataSourceId;
//  private Optional<Long> flowDbId;
//  private Optional<String> source;
//
//  public PublishedKbDTO(Long sourceDocumentKey, Long dataSourceId, Optional<Long> flowDbId,
//      Optional<String> source) {
//    this.sourceDocumentKey = sourceDocumentKey;
//    this.dataSourceId = dataSourceId;
//    this.flowDbId = flowDbId;
//    this.source = source;
//  }
//
//
//
//  public Optional<Long> getFlowDbId() {
//    return flowDbId;
//  }
//
//  public void setFlowDbId(Optional<Long> flowDbId) {
//    this.flowDbId = flowDbId;
//  }
//
//
//  public Optional<String> getSource() {
//    return source;
//  }
//
//  public void setSource(Optional<String> source) {
//    this.source = source;
//  }
//


  public PublishedKbDTO(Long sourceDocumentKey, Long dataSourceId) {
    this.sourceDocumentKey = sourceDocumentKey;
    this.dataSourceId = dataSourceId;
  }

  public Long getSourceDocumentKey() {
    return sourceDocumentKey;
  }

  public void setSourceDocumentKey(Long sourceDocumentKey) {
    this.sourceDocumentKey = sourceDocumentKey;
  }

  public Long getDataSourceId() {
    return dataSourceId;
  }

  public void setDataSourceId(Long dataSourceId) {
    this.dataSourceId = dataSourceId;
  }

  public PublishedKbDTO() {
  }
}
