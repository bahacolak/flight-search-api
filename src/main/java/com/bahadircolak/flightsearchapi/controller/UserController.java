package com.bahadircolak.flightsearchapi.controller;

import com.bahadircolak.flightsearchapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestParam String username, @RequestParam String password) {
        String encryptedPassword = passwordEncoder.encode(password);
        userService.createUser(username, encryptedPassword);
        return new ResponseEntity<>("Kullanıcı başarıyla oluşturuldu.", HttpStatus.CREATED);
    }
}


