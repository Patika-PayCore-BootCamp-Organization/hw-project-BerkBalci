package com.example.Restaurant.Reservation.System.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

public class UserDataDTO implements Serializable {

    @NotBlank
    private String username;

    @NotBlank
    @Email(message = "Email not valid")
    private String email;

    @NotBlank
    private String password;

    List<Role> roles;



}
