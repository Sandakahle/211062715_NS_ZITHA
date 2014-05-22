/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kabaso.askweb.presentation.rest;

import com.kabaso.askweb.domain.Club;
import com.kabaso.askweb.services.ClubService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author hashcode
 */
@Controller  // Annotation to make this class be detectable by the config as a controller
@RequestMapping(value = "api/club") // This the url e.g http://localhost:8084/askweb/api/club
public class ClubRestController {
    @Autowired
    private ClubService clubService;
    

    @RequestMapping(value = "create",method = RequestMethod.POST) // This the uri e.g http://localhost:8084/askweb/api/club/create
    @ResponseBody //Converts output or response to JSON String
    public String create(@RequestBody Club club) { // @RequestBody for converting incoming JSON call to Object
        clubService.persist(club);
        
        System.out.println(" Create the Called ");
        return "Club Created";
    }

    @RequestMapping(value = "update",method = RequestMethod.PUT) //This the uri e.g http://localhost:8084/askweb/api/club/update
    @ResponseBody
    public String update(@RequestBody Club club) {
        clubService.merge(club);
        System.out.println(" Update Called ");
        return "Club Update";
    }

    @RequestMapping(value = "club/{id}",method = RequestMethod.GET) //http://localhost:8084/askweb/api/club/1234
    @ResponseBody
    public Club getClub(@PathVariable Long id) { //@PathVariable used to bind the id value
        
        System.out.println(" ID called ");
        return clubService.find(id);
    }

    @RequestMapping(value = "clubs",method = RequestMethod.GET) // Always Put HTTP Method
    @ResponseBody
    public List<Club> getClubs() {
        System.out.println("The CLUBS");
        return clubService.findAll();
    }

    @RequestMapping(value = "club/{name}",method = RequestMethod.GET) //http://localhost:8084/askweb/api/club/football
    @ResponseBody
    public Club getClubByName(@PathVariable String name) {
        Club club = clubService.getClubByName(name); // Call the Service;
        if(club!=null){
            return club;
        }
        return null;
    }

}
