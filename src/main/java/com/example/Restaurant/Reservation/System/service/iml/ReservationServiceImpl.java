package com.example.Restaurant.Reservation.System.service.iml;


import com.example.Restaurant.Reservation.System.exception.NotFoundException;
import com.example.Restaurant.Reservation.System.model.Reservation;
import com.example.Restaurant.Reservation.System.repository.ReservationRepository;
import com.example.Restaurant.Reservation.System.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservation(Integer id) {
        Optional<Reservation> byId = reservationRepository.findById(id);
        return byId.orElseThrow(() -> new NotFoundException("Reservation"));
    }

    @Override
    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public boolean deleteReservation(Integer id) {
        reservationRepository.delete(getReservation(id));
        return true;
    }

    @Override
    public List<Reservation> getAllReservationDateBetween(Date start, Date end) {
        return reservationRepository.getAllReservationDateBetween(start, end);
    }

    @Override
    public Reservation getReservationByCode(String code) {
        return reservationRepository.getByCode(code);
    }



}
