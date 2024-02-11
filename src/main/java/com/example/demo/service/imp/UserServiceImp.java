package com.example.demo.service.imp;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserServiceImp {
    List<UserDTO> getAllUser();
}
