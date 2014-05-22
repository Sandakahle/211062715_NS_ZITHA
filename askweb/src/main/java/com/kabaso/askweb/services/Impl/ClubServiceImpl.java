/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kabaso.askweb.services.Impl;

import com.kabaso.askweb.domain.Club;
import com.kabaso.askweb.domain.Person;
import com.kabaso.askweb.respository.ClubRepository;
import com.kabaso.askweb.respository.PersonRepository;
import com.kabaso.askweb.services.ClubService;
import com.kabaso.askweb.services.PersonService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author hashcode
 */
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Club find(Long id) {
        return clubRepository.findOne(id);
    }

    @Override
    public Club persist(Club entity) {
        return clubRepository.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Club merge(Club entity) {

        if (entity.getId() != null) {
            return clubRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Club entity) {
        clubRepository.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Club> findAll() {
        return clubRepository.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Club getClubByName(String name) {
        List<Club> clubs = findAll();
        Club foundClub = null;
        for (Club club : clubs) {
            if (club.getName().equalsIgnoreCase(name)) {
                foundClub = club;
            }
        }
        return foundClub;

    }

    @Override
    public int getNumberOfClubs() {
        List<Club> clubs = findAll();
        return clubs.size();
    }

    @Override
    public int numberOfPeopleInaClub(String clubName) {
        List<Person> people = personRepository.findAll();
        Club club = getClubByName(clubName);
        List<Person> persons = new ArrayList<>();
        for(Person person: people){
            if(person.getClubs().contains(club)){
                persons.add(person);
            }
        }
        return persons.size(); //To change body of generated methods, choose Tools | Templates.
    }

}
