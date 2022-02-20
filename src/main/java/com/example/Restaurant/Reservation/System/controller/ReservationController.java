package com.example.Restaurant.Reservation.System.controller;


import com.example.Restaurant.Reservation.System.model.Reservation;
import com.example.Restaurant.Reservation.System.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public String welcome() {
        return "Welcome to Reservation Service!";
    }

 //   @GetMapping(value = "/all")
  //  public List<Reservation> getAllReservation() {
 //       return reservationService.getAllReservation();
  //  }

    @GetMapping(value = "/{id}")
    public Reservation getReservation(@PathVariable @Min(1) Integer id) {
        return reservationService.getReservation(id);
    }

    @PostMapping(value = "/create")
    public void saveReservation(@Valid @RequestBody Reservation reservation) {
        reservationService.addReservation(reservation);
    }

    @PutMapping(value = "/update")
    public Reservation updateReservation(@Valid @RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteReservation(@RequestParam @Min(1) Integer id) {
        return reservationService.deleteReservation(id);
    }

    @GetMapping(value = "/all/reservation-data-between")
    public List<Reservation> getAllReservationDateBetween(@Valid @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam Date start,
                                                          @Valid @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam Date end) {
        return reservationService.getAllReservationDateBetween(start, end);
    }

    // We can write an annotation and validator to check
    // whether this is a valid code or not
    @GetMapping("/by-code/{code}")
    public Reservation getReservationtByCode(@PathVariable String code) {
        return reservationService.getReservationByCode(code);
    }
}
