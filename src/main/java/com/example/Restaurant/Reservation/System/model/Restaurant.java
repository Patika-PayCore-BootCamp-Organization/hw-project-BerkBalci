package com.example.Restaurant.Reservation.System.model;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "restaurant")

public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @NotNull
    @Column(name = "restaurantname")
    private String name;

    @NotNull
    private String address;

    @Transient
    private List<Address> addresses;


    @Column(name = "reservationfee")
    private Integer reservationfee;


    public List<Address> formatToAdressList() {
        String[] splitedAddresses = address.split("//");
        List<Address> response = new ArrayList<>();
        Arrays.stream(splitedAddresses).forEach(split -> {
            String[] splited = split.trim().split("/");
            response.add(new Address(splited[1], splited[0]));

        });
        return response;
    }


}
