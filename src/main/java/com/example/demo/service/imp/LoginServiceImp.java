package com.example.demo.service.imp;

import com.example.demo.DTO.UserDTO;
import com.example.demo.payload.request.SignUpRequest;

import java.util.List;

public interface LoginServiceImp {
    List<UserDTO> getAllUser();
    boolean checkLogin(String userName, String userPw);

    boolean checkSignup(SignUpRequest signUpRequest);
}
