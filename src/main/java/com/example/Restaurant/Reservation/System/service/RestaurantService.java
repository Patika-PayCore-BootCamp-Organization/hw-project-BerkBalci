package com.example.Restaurant.Reservation.System.service;

import com.example.Restaurant.Reservation.System.model.Restaurant;
import com.example.Restaurant.Reservation.System.model.RestaurantDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RestaurantService {

    List<RestaurantDTO> getAllRestaurants();

    RestaurantDTO getRestaurant(Integer id);

    boolean addRestaurant( Restaurant restaurant);

    RestaurantDTO updateRestaurant(Integer id,Restaurant restaurant);

    boolean deleteRestaurant (Integer id);
}
