package com.example.Restaurant.Reservation.System.repository;


import com.example.Restaurant.Reservation.System.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {


}
