package com.example.Restaurant.Reservation.System.service;

import com.example.Restaurant.Reservation.System.model.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationService {

    List<Reservation> getAllReservation();

    Reservation getReservation(Integer id);

    void addReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);

    boolean deleteReservation(Integer id);


    List<Reservation> getAllReservationDateBetween(Date start, Date end);

    Reservation getReservationByCode(String code);
}
