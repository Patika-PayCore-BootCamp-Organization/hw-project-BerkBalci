package com.example.Restaurant.Reservation.System.model;

import lombok.Getter;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;

@Getter
public class UserLoginDTO {

   @NotBlank
   private String username;
   @NotBlank
   private String password;
}
