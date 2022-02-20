package com.example.Restaurant.Reservation.System.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {

        super(message + " not found!");
    }
}
