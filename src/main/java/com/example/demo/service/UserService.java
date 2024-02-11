package com.example.demo.service;


import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceImp {


    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUser(){
        List<Users> users = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for(Users user: users){
            UserDTO userDTO = new UserDTO();
            userDTO.setUserName(user.getUserName());
            userDTO.setCreateAt(user.getCreateAt());
            userDTO.setUserPassword(user.getUserPassword());
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

}
