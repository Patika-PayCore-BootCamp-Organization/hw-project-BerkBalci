package com.example.Restaurant.Reservation.System.repository;

import com.example.Restaurant.Reservation.System.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    Reservation getByCode(String code);

    List<Reservation> getAllReservationDateBetween(Date startDate, Date endDate);



}
