package com.example.Restaurant.Reservation.System.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "code can not be null")
    private String code;

    @NotNull(message = "quota can not be null")
    private Integer quota;

    @NotNull(message = "price can not be null")
    private Integer price;

    @NotNull(message = "reservation date can not be null")
    @Column(name = "reservation_date")
    private Date departureDate;


    @NotNull(message = "restaurant can not be null")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private Restaurant restaurant;


}
