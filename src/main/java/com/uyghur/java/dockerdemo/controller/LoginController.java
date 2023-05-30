package com.uyghur.java.dockerdemo.controller;

import com.uyghur.java.dockerdemo.model.request.UserDetails;
import com.uyghur.java.dockerdemo.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/user")
    public ResponseEntity<String> getUserDetails( @Validated @RequestBody UserDetails userDetails) {
        String username = loginService.checkUsername(userDetails.getUsername()).getName();
        logger.info("login username has been successfully retrieved in LoginController");
        return new ResponseEntity<>("Hello %s, you have been successfully logged in !".formatted(username), HttpStatus.OK);
    }
}
