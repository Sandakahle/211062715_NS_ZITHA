/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kabaso.askweb.presentation;

import com.kabaso.askweb.domain.Person;
import com.kabaso.askweb.services.PeopleAgeService;
import com.kabaso.askweb.services.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author hashcode
 */
@Controller
public class PersonController {
    @Autowired
    private PeopleAgeService personService;
    @RequestMapping(value="person")
    @ResponseBody
    public Person getPerson(){
        Person p = null;
        List<Person> persons = personService.findAll();
        
        System.out.println(" THE COllection Size"+persons.size());
        
        if (persons.size()>0) {
            p = persons.get(0);
            
        }
        
        return p;
    }
     @RequestMapping(value="persons")
    @ResponseBody
    public List<Person> getPersons(){
       return personService.findAll();
        
        
    }
}
