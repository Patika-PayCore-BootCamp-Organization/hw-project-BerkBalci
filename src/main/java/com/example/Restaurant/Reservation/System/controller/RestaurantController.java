package com.example.Restaurant.Reservation.System.controller;

import com.example.Restaurant.Reservation.System.model.Restaurant;
import com.example.Restaurant.Reservation.System.model.RestaurantDTO;
import com.example.Restaurant.Reservation.System.model.mapper.RestaurantMapper;
import com.example.Restaurant.Reservation.System.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;



    @GetMapping( path = "/hello")
    public String welcome(){
        return "Wecome to Restaurant Reservation System";
    }

    @GetMapping( path = "/all")
    public List<RestaurantDTO> getAllRestaurants(){

        return restaurantService.getAllRestaurants();

    }

    @PostMapping( path = "/get")
    public RestaurantDTO getRestaurant(@RequestParam  Integer id){
        return restaurantService.getRestaurant(id);

    }

    @PostMapping( path = "/add")
    public boolean addRestaurant(@RequestBody RestaurantDTO restaurant){
        return restaurantService.addRestaurant(RestaurantMapper.toEntity(restaurant) );

    }

    @PutMapping(value= "/update/id={id}")
    public RestaurantDTO updateRestaurant(@PathVariable  Integer id,
                                          @RequestBody RestaurantDTO restaurant) {
        return restaurantService.updateRestaurant(id, RestaurantMapper.toEntity(restaurant));
    }

    @DeleteMapping(value = "/delete/id={id}")
    public boolean deleteRestaurant(@PathVariable  Integer id){
        return restaurantService.deleteRestaurant(id);
    }


}

