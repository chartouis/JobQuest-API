package com.chitas.jobquest.controller;


import com.chitas.jobquest.model.DTO.UserDTO;
import com.chitas.jobquest.model.JWT;
import com.chitas.jobquest.model.User;
import com.chitas.jobquest.repo.UsersRepo;
import com.chitas.jobquest.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SuppressWarnings("unused")
@RestController
@RequestMapping
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UsersRepo usersRepo, UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserDTO register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public JWT login(@RequestBody User user, HttpServletResponse response){
        return userService.verify(user,response);
    }


}