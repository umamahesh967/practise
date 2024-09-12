package com.database.jpa.hibernate.demo.rest.test2;


import com.database.jpa.hibernate.demo.entity.Course;
import com.database.jpa.hibernate.demo.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Path("/generatedKbsPublishHistory")
//@Api(value = "Auditor for Generated KBs Published to SOR", description = "Endpoint for managing Published KB to SOR")
//@Slf4j
@RestController //RestController == Controller + ResponseBody
@RequestMapping("/generatedKbsPublishHistory")
public class GeneratedKbsPublishHistory {

//  private static final Gson gson = new Gson();
//  private static final int BATCH_SIZE = 50;
//
//  private static final ExternalDocumentController edc = new ExternalDocumentController();

  @PostMapping
//  @ProduceS(MediaType.APPLICATION_JSON)
//  @Consumes(MediaType.APPLICATION_JSON)
//  @ApiOperation(value = "Save the KB Information irrespective of published or not", response = String.class)
  public void persistGeneratedKbsPublishHistory(@RequestBody GeneratedKbsPublishDTO generatedKbsPublishDTO) {
//    try {
//      String msg = isValid(tenantId, generatedKbsPublishDTO);
//      if (StringUtils.isNotEmpty(msg)) {
//        log.debug("Failed to persist the Content information. {}", msg);
//        return Response.status(Response.Status.BAD_REQUEST.getStatusCode())
//          .entity(
//            RestTools.getErrorJson(Response.Status.BAD_REQUEST.getStatusCode(), msg, true, null))
//          .build();
//      }
//      edc.batchPersistPublishedKbsToSOR(tenantId, generatedKbsPublishDTO, BATCH_SIZE);
//      return Response.ok().build();
//    } catch (Exception e) {
//      log.error("Exception during request", e);
//      return Response.serverError()
//        .entity(RestTools.getErrorJson("Exception during request", true, Optional.of(e))).build();
//    }
    System.out.println("xys");
    return;
  }

//  private String isValid(String tenantId, GeneratedKbsPublishDTO generatedKbsPublishDTO) {
//    if (StringUtils.isEmpty(tenantId)) {
//      return "No/Invalid tenant information provided";
//    }
//
//    if (generatedKbsPublishDTO == null || CollectionUtils.isEmpty(
//      generatedKbsPublishDTO.getPublishedKbDtos())) {
//      return "No/Invalid content(s) information provided";
//    }
//
//    for (PublishedKbDTO publishedKbDTO : generatedKbsPublishDTO.getPublishedKbDtos()) {
//      //TODO To check which all fields are optional/mandatory
//      if (publishedKbDTO.getSourceDocumentKey() == null
//        || publishedKbDTO.getSourceDocumentKey() == 0
//        || publishedKbDTO.getDataSourceId() == null || publishedKbDTO.getDataSourceId() == 0
//        || publishedKbDTO.getStatus() == null
//        || (GeneratedKbPublishStatus.SUCCESS.equals(publishedKbDTO.getStatus()) &&
//        (publishedKbDTO.getPublishedBy() == null ||
//          publishedKbDTO.getSource() == null || !publishedKbDTO.getSource().isPresent()))
//      ) {
//        return "Invalid information provided for one of the content object - " + gson.toJson(
//          publishedKbDTO);
//      }
//
//      if (((publishedKbDTO.getFlowDbId() == null || !publishedKbDTO.getFlowDbId().isPresent()) &&
//        (publishedKbDTO.getExternalSystemId() == null || !publishedKbDTO.getExternalSystemId().isPresent()))
//        || ((publishedKbDTO.getFlowDbId() != null && !publishedKbDTO.getFlowDbId().isPresent()) &&
//        (publishedKbDTO.getExternalSystemId() != null && !publishedKbDTO.getExternalSystemId().isPresent()))) {
//        return
//          "Only one of either flowDbId or externalSystemId field should be populated for one of"
//            + " the content object - " + gson.toJson(publishedKbDTO);
//      }
//    }
//    return null;
//  }
}
