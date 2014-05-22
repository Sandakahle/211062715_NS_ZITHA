/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kabaso.askweb.test.restapi;

import com.kabaso.askweb.domain.Club;
import com.kabaso.askweb.domain.Person;
import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author hashcode
 */
public class RestController {
    private RestTemplate restTemplate;
    private final static String URL = "http://localhost:8084/askweb/";
    
    
    public void testPost(){
        
        Club club2 = new Club.Builder("Chess").build();
        restTemplate.postForLocation(URL+"createclub", HttpMethod.POST, Club.class);
        
    }
    
    
    public void testRead(){
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Person[]> responseEntity = restTemplate.exchange("URL",HttpMethod.GET,requestEntity, Person[].class);
        
        Person [] people = responseEntity.getBody();
        for (Person person : people) {
            
            
        }
       
    }
    
    private HttpEntity<?> getHttpEntity(){
         HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application","json")));
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return requestEntity;
    }
    
}