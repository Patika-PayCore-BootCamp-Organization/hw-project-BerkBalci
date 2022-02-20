package com.example.Restaurant.Reservation.System.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "person")

public class  Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "firstname can not be null")
    private String  firstname;

    @NotBlank(message = "lastname can not be null")
    private String  lastname;

    @NotBlank(message = "gender can not be null")
    private String gender;

    @NotNull
    private Integer age;

    @NotBlank(message = "phone can not be null")
    private String phone;

    @Email(message = "email can not be null")
    private String email;



}
