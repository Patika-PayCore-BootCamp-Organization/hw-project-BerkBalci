package com.example.Restaurant.Reservation.System.model;

import com.sun.istack.NotNull;
import lombok.Data;

import java.util.List;
import java.util.StringJoiner;

@Data
public class RestaurantDTO {

    @NotNull
    private String name;

    @NotNull
    private List<Address> addresses;

    @NotNull
    private Integer reservationfee;

    public String formatRestaurant() {
        StringJoiner strJoiner = new StringJoiner(" // ");
        this.addresses.forEach(address -> strJoiner.add(address.addressDBFormat()));
        return strJoiner.toString();
    }

}