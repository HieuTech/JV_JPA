package com.example.demo.repository;

import com.example.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    /**
     * tim username and password, if exist, return a list
     *đây la query Creation
     */
//    List<Users> findByUserNameAndUserPassword(String userName, String userPw);
    Users findByUserName(String userName);
}
