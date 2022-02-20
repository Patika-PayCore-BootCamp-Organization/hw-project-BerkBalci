package com.example.Restaurant.Reservation.System.model;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class Address {

    @NotNull
    private String city;
    @NotNull
    private String province;
    private String streetCode;
    private Integer buildingNo;

    public Address(String city, String province) {
        this.city = city;
        this.province = province;
    }

   public String addressDBFormat() {
       return province + "/" + city;
   }
}

