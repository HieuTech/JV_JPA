package com.example.demo.Controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class SigninController {

    @Autowired
    LoginService loginService;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(){


         return new ResponseEntity<>(loginService.getAllUser(), HttpStatus.OK);

    }
}