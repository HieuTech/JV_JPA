package com.example.demo.Controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.Users;
import com.example.demo.payload.ResponseData;
import com.example.demo.payload.request.SignInRequest;
import com.example.demo.payload.request.SignUpRequest;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoginService;
import com.example.demo.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class SigninController {

    //khi gọi interface thì các hàm trong nó sẽ kich họat, nhưng class nào implement lại sẽ dc chạy
    @Autowired
    LoginServiceImp loginServiceImp;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String userName, @RequestParam String userPw){
        ResponseData responseData = new ResponseData();
        if(loginServiceImp.checkLogin(userName,userPw)){
            responseData.setData(true);
        }else{
            responseData.setData(false);
        }

         return new ResponseEntity<>(responseData, HttpStatus.OK);

    }
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest){
        ResponseData responseData = new ResponseData();

        responseData.setData(loginServiceImp.checkSignup(signUpRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
