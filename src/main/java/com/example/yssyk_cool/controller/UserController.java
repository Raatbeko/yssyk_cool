package com.example.yssyk_cool.controller;

import com.example.yssyk_cool.dto.user.request.UserAuthRequest;
import com.example.yssyk_cool.dto.user.request.UserRequest;
import com.example.yssyk_cool.dto.user.response.UserResponse;
import com.example.yssyk_cool.dto.user.response.UserTokenResponse;
import com.example.yssyk_cool.exception.EmailNotBeEmptyException;
import com.example.yssyk_cool.service.auth.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public UserResponse register(@RequestBody UserRequest request) throws EmailNotBeEmptyException {
        return userService.save(request);
    }

//    @PostMapping("/auto")
//    public UserTokenResponse auto(@RequestBody UserAuthRequest request) {
//        return userService.getToken(request);
//    }

    @GetMapping
    public UserTokenResponse getAll(@RequestBody UserAuthRequest request) {
        return  userService.getToken(request);
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }



}
