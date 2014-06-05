/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kabaso.askweb.presentation;

import com.kabaso.askweb.domain.Person;
import com.kabaso.askweb.services.PeopleAgeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author hashcode
 */
@Controller
public class CputController {
    @Autowired
    private PeopleAgeService ageService;
    @RequestMapping(value = "cput",method = RequestMethod.GET)
    public String getHome(){
        
        List<Person> persons = ageService.getAgeAbove(3);
        
        System.out.println(" The CPUT COntroller was hit" +persons.size());
        
        return "cput";
    }
    @RequestMapping(value = "cput/students",method = RequestMethod.GET)
    public String getStudents(Model model){
        
        
        model.addAttribute("name1", "This is a Student Name");
        
        return "students";
    }
    
}
