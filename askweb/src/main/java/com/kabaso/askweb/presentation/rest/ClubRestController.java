/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kabaso.askweb.presentation.rest;

import com.kabaso.askweb.domain.Club;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author hashcode
 */
@Controller
@RequestMapping(value = "api/club")
public class ClubRestController {
    

    @RequestMapping(value = "create")
    @ResponseBody
    public String create(@RequestBody Club club) {
        System.out.println(" Create the Called ");
        return "";
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(@RequestBody Club club) {
        System.out.println(" Update Called ");
        return "";
    }

    @RequestMapping(value = "club/{id}")
    @ResponseBody
    public Club getClub(@PathVariable String id) {
        System.out.println(" ID called ");
        return null;
    }

    @RequestMapping(value = "clubs")
    @ResponseBody
    public List<Club> getClubs(Club club) {
        System.out.println("The CLUBS");
        return null;
    }

    @RequestMapping(value = "club/{name}")
    @ResponseBody
    public Club getClubByName(@PathVariable String name) {
        System.out.println("The Club name");
        return null;
    }

}
