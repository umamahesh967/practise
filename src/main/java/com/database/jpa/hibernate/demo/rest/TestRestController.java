package com.database.jpa.hibernate.demo.rest;

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

import java.text.MessageFormat;

/**
 * All the requests first go to the front controller(Dispatcher Servlet) then Dispatcher servlet finds
 * the Specific controller and calls the related method bases on the request path.
 *
 * ResponseBody(This would convert the response from the method to some
 * other format(like XML or JSON) based on the {@link org.springframework.http.converter.HttpMessageConverter} implemented in the classpath).
 *
 * @PathVariable Annotation which indicates that a method parameter should be bound to a URI template variable.
 * https://www.baeldung.com/spring-optional-path-variables#:~:text=Making%20Path%20Variables%20Optional&text=3%2C%20the%20%40PathVariable%20annotation%20defines,mandatory%20to%20a%20handler%20method.&text=Since%20the%20required%20attribute%20is,not%20sent%20in%20the%20request.
 *
 *
 * @RequestBody Annotation indicating a method parameter should be bound to the body of the web request.
 * The body of the request is passed through an {@link HttpMessageConverter} to resolve the
 * method argument depending on the content type of the request.
 *
 * @ApiIgnore
 * @ApiParam
 * @RequestParam
 */

@RestController //RestController == Controller + ResponseBody
@RequestMapping("/api2")
public class TestRestController
{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    Tracer tracer;

    @GetMapping(path = "/hello-world")
    public ResponseEntity<String> helloWorld() {
        logger.info("This is a hello-world log");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("trace-id", tracer.currentSpan().context().traceId());
        responseHeaders.add("span-id", tracer.currentSpan().context().spanId());
        logger.info(tracer.currentSpan().context().traceId() + "   "+ tracer.currentSpan().context().spanId());
        return new ResponseEntity<>("Hello World", responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/hello-world-bean",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.GET)
    public Course Course() {
        return new Course("Hello World");
    }

    //Try Difference between returning ResponseEntity with object and normal object.
    @GetMapping(path = "/hello-world/path-variable/{name}/test", produces = {MediaType.APPLICATION_JSON_VALUE, })
    public ResponseEntity<Course> helloWorldPathVariable(
            @RequestBody(required = false) Course course,
            @PathVariable(required = false, name = "name") String username,
            @RequestParam(required = true) String orgId,
            @RequestParam(required = false) String fac
    )
    {
        return new ResponseEntity<Course>(new Course(String.format("Hello World, %s", username)), HttpStatus.OK);
    }



    @GetMapping(path = "/hello-world/path-variable/{name}")
    public Course helloWorldPathVariable1(@PathVariable String name)
    {
        /**
         * To get request URI from REST API.
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        request.getRequestURL()
         */
        return new Course(String.format("Hello World, %s", name));
    }

    @GetMapping(path = "course/{id}")
    public Course getCourse(@PathVariable Long id)
    {
        /**
         * To get request URI from REST API.
         RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
         HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
         request.getRequestURL()
         */
        return courseRepository.findById(id);
    }


//    @RequestMapping(value = "/shipment/{pk}", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
//    @ApiOperation(value = "Get Shipment by PK", notes = "Get Shipment based on PK.", response=ShipmentDTO.class)
//    @ApiResponses(value = { @ApiResponse(code = 404, message = "Shipment not found"),
//            @ApiResponse(code = 200, message = "OK"),
//            @ApiResponse(code = 401, message = "Unauthorized"),
//            @ApiResponse(code = 403, message = "Forbidden")})
//    public ResponseEntity<RestApiResponse<Document>> getShipment(
//            @ApiIgnore Context context,
//            @ApiParam(value = "Shipment PK", required = true) @PathVariable String pk,
//            @ApiParam(value = "Organization Id", required = false) @RequestParam(required = false) String orgId,
//            @ApiParam(value = "Response Template Name", required = false) @RequestParam(required = false) String templateName)
//    {
//        logger.trace(() -> ">> getShipment()");
//        logger.debug(() -> MessageFormat.format(
//                "-- getShipment() Retrieve Shipment based on: {0} having user {1}, Organization {2} with relevant Org {3}, relevant node id {4} and relevant business unit {5}",
//                pk, context.getUser(), context.getOrganization(), context.getRelevantOrganizationId(), context.getRelevantNodeId(), context.getRelevantBusinessUnitId()));
//        Template template = getTemplate(context, templateName, Shipment.ENTITY_NAME, orgId);
//        Document document = shipmentMapService.getShipment(context, Long.parseLong(pk), orgId, template);
//
//        RestApiResponse<Document> response = RestApiResponseFactory.getApiResponse(Document.class,document);
//        setErrorResponse(response);
//        logger.trace(() -> "<< getShipment()");
//        return response.getHttpResponse();
//    }
//

//    @RequestMapping(value = "/shipment/shipmentId/{shipmentId}", method = RequestMethod.PUT,
//            produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
//    @ApiOperation(value = "Update Shipment By Business Keys", notes = "Update Shipment By Business Keys", response = ShipmentDTO.class)
//    @ApiResponses(value = { @ApiResponse(code = 404, message = "Shipment not found"),
//            @ApiResponse(code = 200, message = "OK"),
//            @ApiResponse(code = 401, message = "Unauthorized"),
//            @ApiResponse(code = 403, message = "Forbidden"),
//            @ApiResponse(code = 400, message = "Request contained data that was invalid")})
//    @ApiImplicitParams(value = {
//            @ApiImplicitParam(name = "ShipmentData", value = "Shipment JSON", required = true, dataType = "Shipment", paramType = "body")
//    })
//    public ResponseEntity<RestApiResponse<Document>> updateByShipmentId(
//            @ApiIgnore Context context,
//            @ApiParam(value = "Business Key", required = true) @PathVariable String shipmentId,
//            @ApiParam(name="ShipmentData") @RequestBody Document document,
//            @ApiParam(value = "Organization Id", required = false) @RequestParam(required = false) String orgId,
//            @ApiParam(value = "Response Template", required = false) @RequestParam(required = false) String templateName)
//    {
//        logger.trace(() -> ">> updateByShipmentId()");
//        logger.debug(() -> MessageFormat.format(
//                "-- updateByShipmentId() update Shipments based on business keys {0} having user {1}, Organization {2} with relevant Org {3}, relevant node id {4} and relevant business unit {5}",
//                shipmentId, context.getUser(), context.getOrganization(), context.getRelevantOrganizationId(), context.getRelevantNodeId(), context.getRelevantBusinessUnitId()));
//        document.put(Shipment.Fields.SHIPMENT_ID.getCode(), shipmentId);
//
//        Template template = getTemplate(context, templateName, Shipment.ENTITY_NAME, orgId);
//        document = shipmentMapService.updateByShipmentId(context, document, orgId, template);
//        RestApiResponse<Document> response = RestApiResponseFactory.getApiResponse(Document.class,document);
//        setErrorResponse(response);
//        logger.trace(() -> "<< updateByShipmentId()");
//        return response.getHttpResponse();
//    }
}
