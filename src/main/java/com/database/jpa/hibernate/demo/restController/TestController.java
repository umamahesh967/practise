package com.database.jpa.hibernate.demo.restController;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.Document;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController
{
    @RequestMapping(value = "/geturl", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
    public Map getShipment()
    {
        Map<String, String> map = new HashMap<>();
        map.put("URL", "https://tpestg.logistics.com/services/rest/cbotrans/cbodocument-webservice/downloadDocument?objectId=61384482&objectType=SHIP&docId=270749&docType=530&revNo=1&docFileName=Test+2.pdf");
        return map;
    }
}
