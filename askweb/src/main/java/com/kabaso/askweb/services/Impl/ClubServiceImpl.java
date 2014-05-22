/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kabaso.askweb.services.Impl;

import com.kabaso.askweb.domain.Club;
import com.kabaso.askweb.respository.ClubRepository;
import com.kabaso.askweb.services.ClubService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author hashcode
 */
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepository clubRepository;

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

}
