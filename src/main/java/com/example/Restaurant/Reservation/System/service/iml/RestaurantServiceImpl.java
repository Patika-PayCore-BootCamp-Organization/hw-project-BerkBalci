package com.example.Restaurant.Reservation.System.service.iml;

import com.example.Restaurant.Reservation.System.model.Restaurant;
import com.example.Restaurant.Reservation.System.model.RestaurantDTO;
import com.example.Restaurant.Reservation.System.model.mapper.RestaurantMapper;
import com.example.Restaurant.Reservation.System.repository.RestaurantRepository;
import com.example.Restaurant.Reservation.System.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;







    @Override
    public List<RestaurantDTO> getAllRestaurants() {
        List<Restaurant> all = restaurantRepository.findAll();
        return all.stream().map(RestaurantMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public RestaurantDTO getRestaurant(Integer id) {
        Optional<Restaurant> byId = restaurantRepository.findById(id);
        if(byId.isPresent()){
            return RestaurantMapper.toDto( byId.get());
        }
        return null;
    }

    @Override
    public boolean addRestaurant(Restaurant restaurant) {
        Restaurant save = restaurantRepository.save(restaurant);
        if(save==null)
            return false;
        return true;



    }

    @Override
    public RestaurantDTO updateRestaurant(Integer id,Restaurant restaurant) {
        RestaurantDTO currentRestaurant = getRestaurant(id);
        if(currentRestaurant ==null)
            return null;
        restaurant.setId(id);
        return RestaurantMapper.toDto(restaurantRepository.save(restaurant));

    }
    @Override
    public boolean deleteRestaurant(Integer id) {
        restaurantRepository.deleteById(id);
        return true;
    }
}
