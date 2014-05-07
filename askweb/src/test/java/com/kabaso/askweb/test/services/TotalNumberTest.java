/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kabaso.askweb.test.services;

import com.kabaso.askweb.domain.Account;
import com.kabaso.askweb.domain.Club;
import com.kabaso.askweb.domain.Person;
import com.kabaso.askweb.respository.ClubRepository;
import com.kabaso.askweb.respository.PersonRepository;
import com.kabaso.askweb.services.TotalPeopleService;
import com.kabaso.askweb.test.ConnectionConfigTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author hashcode
 */
public class TotalNumberTest {

    public static ApplicationContext ctx;

    private TotalPeopleService service;
    private PersonRepository personRepository;
    private ClubRepository clubRepository;
    private Long id;

    public TotalNumberTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testClub() {
        clubRepository = ctx.getBean(ClubRepository.class);
        Club club1 = new Club.Builder("Football").build();
        Club club2 = new Club.Builder("Tennis").build();

        clubRepository.save(club1);
        clubRepository.save(club2);

    }

    @Test(dependsOnMethods = "testClub")
    private void createPerson() {
        clubRepository = ctx.getBean(ClubRepository.class);
        personRepository = ctx.getBean(PersonRepository.class);

        List<Account> accounts = new ArrayList<>();

        Account ac1 = new Account.Builder("accout1").balance(new BigDecimal("200.00")).build();
        Account ac2 = new Account.Builder("accout2").balance(new BigDecimal("400.00")).build();
        Account ac3 = new Account.Builder("accout3").balance(new BigDecimal("500.00")).build();
        accounts.add(ac1);
        accounts.add(ac2);
        accounts.add(ac3);

        List<Club> clubs = clubRepository.findAll();

        Person person = new Person.Builder("test@test.com")
                .accounts(accounts)
                .age(20)
                .clubs(clubs)
                .firstname("jon")
                .lastnaname("Dole")
                .build();

        personRepository.save(person);
        id = person.getId();

        Assert.assertNotNull(person);
    }

    @Test(dependsOnMethods = "createPerson")
    private void readAccounts() {
        personRepository = ctx.getBean(PersonRepository.class);
         Person person = personRepository.findOne(id);
      
        List<Account> accounts = person.getAccounts();

        for (Account account : accounts) {
            System.out.println(" The Account Name is " + account.getName() + " The Balance is " + account.getBalance());

        }
    }

    @Test(dependsOnMethods = "readAccounts")
    private void readClubs() {
        personRepository = ctx.getBean(PersonRepository.class);
        Person person = personRepository.findOne(id);
         Hibernate.initialize(person.getClubs());
        List<Club> clubs = person.getClubs();
        for (Club club : clubs) {
            System.out.println("The Club name is " + club.getName());

        }

    }

    @Test(enabled = false)
    public void total() {
        service = ctx.getBean(TotalPeopleService.class);
        List<Person> people = service.getTotalPeople();

        Assert.assertEquals(people.size(), 0, " Expert no People");

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
//        personRepository = ctx.getBean(PersonRepository.class);
//        personRepository.deleteAll();
    }
}
