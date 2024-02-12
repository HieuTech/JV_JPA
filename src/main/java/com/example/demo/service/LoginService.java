package com.example.demo.service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.Roles;
import com.example.demo.entity.Users;
import com.example.demo.payload.request.SignUpRequest;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements LoginServiceImp {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public boolean checkLogin(String userName, String userPw){
    Users users = userRepository.findByUserName(userName);
    return passwordEncoder.matches(userPw, users.getUserPassword());
    }
   @Override
   public boolean checkSignup(SignUpRequest signUpRequest){
        //save là vừa thêm, vừa update.
       Roles roles = new Roles();
        roles.setId(signUpRequest.getRole_id());
       Users users = new Users();
       users.setUserName(signUpRequest.getUserName());
       users.setUserPassword(signUpRequest.getUserPw());
       users.setRoles(roles);
       try {
           userRepository.save(users);
            return true;
       }catch (Exception e){
           e.printStackTrace();
           return false;

       }
   }

}
