package com.example.yssyk_cool.controller;

import com.example.yssyk_cool.dto.user.request.UserAuthRequest;
import com.example.yssyk_cool.dto.user.request.UserRequest;
import com.example.yssyk_cool.dto.user.response.UserResponse;
import com.example.yssyk_cool.dto.user.response.UserTokenResponse;
import com.example.yssyk_cool.exception.EmailNotBeEmptyException;
import com.example.yssyk_cool.service.auth.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
public class UserController {

    final UserService userService;


    @PostMapping("/register")
    @ApiOperation("Регистрация")
    public UserResponse register(@RequestBody UserRequest request) throws EmailNotBeEmptyException, FileNotFoundException {
        return userService.save(request);
    }

    @PostMapping("/auth")
    @ApiOperation("Авторизация")
    public UserTokenResponse auto(@RequestBody UserAuthRequest request) {
        return userService.getToken(request);
    }

    @GetMapping
    public List<UserResponse> getAll()
    {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable("id") Long id) throws FileNotFoundException {
        return userService.findById(id);
    }

    @GetMapping("/chek/{check}")
    public boolean checkEmailOrLogin(@PathVariable String check){
        return userService.check(check);
    }




}
