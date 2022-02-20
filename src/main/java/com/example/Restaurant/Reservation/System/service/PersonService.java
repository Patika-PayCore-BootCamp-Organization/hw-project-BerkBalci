package com.example.Restaurant.Reservation.System.service;

import com.example.Restaurant.Reservation.System.model.Person;
import com.example.Restaurant.Reservation.System.model.PersonDTO;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;



public interface PersonService {


    List<Person> getAllPerson();

    PersonDTO getPerson(Integer id);

    void addPerson(@RequestBody Person person);

    Person updatePerson(@RequestBody Person Person);

    boolean deletePerson(Integer id);

    List <Person> getPersonNameStartsWith(String prefix);

    List <Person> getPersonSortedViaLastNameAsUpperClass();

    List<Person> getPersonSortedViaLastNameAsUpperCase();
}
