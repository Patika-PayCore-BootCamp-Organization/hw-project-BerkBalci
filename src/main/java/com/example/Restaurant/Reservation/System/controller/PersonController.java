package com.example.Restaurant.Reservation.System.controller;

import com.example.Restaurant.Reservation.System.exception.InvalidRequestException;
import com.example.Restaurant.Reservation.System.model.Person;
import com.example.Restaurant.Reservation.System.model.PersonDTO;
import com.example.Restaurant.Reservation.System.model.mapper.PersonMapper;
import com.example.Restaurant.Reservation.System.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/passenger")
public class PersonController {

    private final PersonService personService;
    private static final PersonMapper PERSON_MAPPER = Mappers.getMapper(PersonMapper.class);

    @GetMapping
    public String welcome() {
        return "Welcome to Person Service!";
    }



    @GetMapping(value = "/{id}")
    public PersonDTO getPerson(@PathVariable @Min(1) Integer id) {
        return PERSON_MAPPER.toDto(personService.getPerson(id));
    }

    @PostMapping(value = "/create")
    public void savePerson(@Valid @RequestBody PersonDTO Person) {
        personService.addPerson(PERSON_MAPPER.toEntity(Person));
    }

    @PutMapping(value = "/update")
    public PersonDTO updatePerson(@Valid @RequestBody Person person) {
        if (person.getId() == null) {
            throw new InvalidRequestException("Person id can not be null for update!");
        }
 //       return PERSON_MAPPER.toDto(personService.updatePerson(person));
        return null;
    }

    @DeleteMapping(value = "/delete")
    public boolean deletePerson(@RequestParam @Min(1) Integer id) {
        return personService.deletePerson(id);
    }
}
