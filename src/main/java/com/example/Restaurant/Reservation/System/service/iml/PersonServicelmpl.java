package com.example.Restaurant.Reservation.System.service.iml;

import com.example.Restaurant.Reservation.System.model.Person;
import com.example.Restaurant.Reservation.System.model.PersonDTO;
import com.example.Restaurant.Reservation.System.repository.PersonRepository;
import com.example.Restaurant.Reservation.System.service.PersonService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PersonServicelmpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

      @Override
      public PersonDTO getPerson(Integer id) {
           Optional<Person> byId = personRepository.findById(id);
       return null;
    }

    @Override
    public void addPerson (Person person) {
        personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public boolean deletePerson(Integer id) {
  //      personRepository.delete(getPerson(id));
        return true;
    }


    @Override
    public List<Person> getPersonNameStartsWith(String prefix) {
        List<Person> allPerson = getAllPerson();
        return allPerson.stream()
                .filter(p -> p.getFirstname().startsWith(prefix))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> getPersonSortedViaLastNameAsUpperClass() {
        return null;
    }

    @Override
    public List<Person> getPersonSortedViaLastNameAsUpperCase() {
        List<Person> allPerson = getAllPerson();
        return allPerson.stream()
                .sorted(Comparator.comparing(Person::getLastname))
                .peek(p -> p.setLastname(p.getLastname().toUpperCase()))
                .collect(Collectors.toList());
    }















}
