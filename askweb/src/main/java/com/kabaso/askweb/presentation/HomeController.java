/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kabaso.askweb.presentation;

import com.kabaso.askweb.domain.Person;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author hashcode
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getIndex(){
        return "index";
    }
    
    @RequestMapping(value = "/rest",method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getRndex(){
        List<Person> persons = new ArrayList<>();
        Person p1 = new Person.Builder("b@k.com")
                .age(5).build();
        Person p2 = new Person.Builder("b1@k.com")
                .age(12).build();
        Person p3 = new Person.Builder("b2@k.com")
                .age(16).build();
        persons.add(p3);
        persons.add(p1);
        persons.add(p2);
        
        return persons;
    }
    
}
