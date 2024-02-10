package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "users")
public class Users {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_pw")
    private String userPassword;


    @Column(name = "create_at")
    private Date createAt;

    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Roles roles;

    @OneToMany(mappedBy = "users")
    private Set<RatingFood> ratingFoodList;

    @OneToMany(mappedBy = "users")
    private Set<RatingRestaurant> ratingRestaurantList;

    @OneToMany(mappedBy = "users")
    private Set<Orders> orderList;

    public Set<Orders> getOrderList() {
        return orderList;
    }

    public void setOrderList(Set<Orders> orderList) {
        this.orderList = orderList;
    }

    public Set<RatingRestaurant> getRatingRestaurantList() {
        return ratingRestaurantList;
    }

    public void setRatingRestaurantList(Set<RatingRestaurant> ratingRestaurantList) {
        this.ratingRestaurantList = ratingRestaurantList;
    }

    public Set<RatingFood> getRatingFoodList() {
        return ratingFoodList;
    }

    public void setRatingFoodList(Set<RatingFood> ratingFoodList) {
        this.ratingFoodList = ratingFoodList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }



    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
