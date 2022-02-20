package com.example.Restaurant.Reservation.System.controller;

import com.example.Restaurant.Reservation.System.model.User;
import com.example.Restaurant.Reservation.System.model.UserDataDTO;
import com.example.Restaurant.Reservation.System.model.UserLoginDTO;
import com.example.Restaurant.Reservation.System.model.UserResponseDTO;
import com.example.Restaurant.Reservation.System.service.iml.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

        @PostMapping("/signin")
        private String login(@Valid  @RequestBody UserLoginDTO userLoginDTO) {
            return userService.signin(userLoginDTO.getUsername(), userLoginDTO.getPassword());
        }

        @PostMapping("/signup")
        public String signup(@RequestBody @Valid UserDataDTO user) {
            ModelMapper modelMapper = new ModelMapper();
            return userService.signup(modelMapper.map(user, User.class));
        }

        @DeleteMapping(value = "/{username}")
        public String delete(@PathVariable String username) {
            userService.delete(username);
            return username;
        }

        @GetMapping(value = "/me")
        public UserResponseDTO whoami(HttpServletRequest req) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
        }
    }



