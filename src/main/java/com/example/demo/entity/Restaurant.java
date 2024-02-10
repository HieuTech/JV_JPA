package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "sub_title")
    private String subTitle;

    @Column(name = "description")
    private  String description;

    @Column(name = "image")
    private String image;

    @Column(name = "is_freeship")
    private boolean isFreeship;

    @Column(name = "address")
    private String address;

    @Column(name = "open_date")
    private Date openDate;


    @OneToMany(mappedBy = "restaurant")
    private Set<RatingRestaurant> ratingRestaurantList;

    @OneToMany(mappedBy = "restaurant")
    private Set<Orders> orderList;

    @OneToMany(mappedBy = "restaurant")
    private Set<RestaurantCategory> restaurantCategoryList;

    @OneToMany(mappedBy = "restaurant")
    private Set<Promo> promoList;

    public Set<Promo> getPromoList() {
        return promoList;
    }

    public void setPromoList(Set<Promo> promoList) {
        this.promoList = promoList;
    }

    public Set<RestaurantCategory> getRestaurantCategoryList() {
        return restaurantCategoryList;
    }

    public void setRestaurantCategoryList(Set<RestaurantCategory> restaurantCategoryList) {
        this.restaurantCategoryList = restaurantCategoryList;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFreeship() {
        return isFreeship;
    }

    public void setFreeship(boolean freeship) {
        isFreeship = freeship;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }
}
