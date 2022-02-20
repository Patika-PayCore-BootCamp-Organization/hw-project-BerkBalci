package com.example.Restaurant.Reservation.System.model.mapper;

import com.example.Restaurant.Reservation.System.model.Restaurant;
import com.example.Restaurant.Reservation.System.model.RestaurantDTO;

public class RestaurantMapper {

    public static RestaurantDTO toDto(Restaurant restaurant){
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setName(restaurant.getName());
        restaurantDTO.setAddresses(restaurant.formatToAdressList());
        restaurantDTO.setReservationfee(restaurant.getReservationfee());
        return restaurantDTO;

    }

    public static Restaurant toEntity(RestaurantDTO restaurantDTO){
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantDTO.getName());
        restaurant.setAddress(restaurantDTO.formatRestaurant());
        restaurant.setReservationfee(restaurantDTO.getReservationfee());
        return restaurant;
    }
}
