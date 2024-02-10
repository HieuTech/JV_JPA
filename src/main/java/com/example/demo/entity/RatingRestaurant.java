package com.example.demo.entity;

import jakarta.persistence.*;

@Entity(name = "rating_restaurant")
public class RatingRestaurant {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rate_point")
    private int ratePoint;

    @Column(name = "comment")
    private String comment;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne()
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
