/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kabaso.askweb.services.Impl;

import com.kabaso.askweb.domain.Person;
import com.kabaso.askweb.respository.PersonRepository;
import com.kabaso.askweb.services.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hashcode
 */
@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person find(Long id) {
        return personRepository.findOne(id);
    }

    @Override
    public Person persist(Person entity) {
        return personRepository.save(entity);
    }

    @Override
    public Person merge(Person entity) {
        if (entity.getId()!=null) {
            return personRepository.save(entity);
        }
        return null;
        }

    @Override
    public void remove(Person entity) {
    
        personRepository.delete(entity);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
    
}
