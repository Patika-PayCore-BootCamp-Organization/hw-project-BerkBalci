package com.example.Restaurant.Reservation.System.model.mapper;

import com.example.Restaurant.Reservation.System.model.Person;
import com.example.Restaurant.Reservation.System.model.PersonDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper  {
    PersonDTO toDto(PersonDTO entity);

    Person toEntity(PersonDTO dto);
}
