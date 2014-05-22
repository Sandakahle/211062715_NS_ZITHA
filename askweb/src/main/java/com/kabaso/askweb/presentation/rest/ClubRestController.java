/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kabaso.askweb.presentation.rest;

import com.kabaso.askweb.domain.Club;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hashcode
 */
@Controller
@RequestMapping(value = "api/club")
public class ClubRestController {

    @RequestMapping(value = "create")
    public String create() {
        System.out.println(" Create the Called ");
        return "";
    }

    @RequestMapping(value = "update")
    public String update() {
        System.out.println(" Update Called ");
        return "";
    }

    @RequestMapping(value = "club/{id}")
    public Club getClub() {
        System.out.println(" ID called ");
        return null;
    }

    @RequestMapping(value = "clubs")
    public List<Club> getClubs() {
        System.out.println("The CLUBS");
        return null;
    }

    @RequestMapping(value = "club/{name}")
    public Club getClubByName(String name) {
        System.out.println("The Club name");
        return null;
    }

}
