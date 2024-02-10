package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "category")
public class Category {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "cate_name")
    private String cateName;
    @Column(name = "create_date")
    private Date createDate;

    @OneToMany(mappedBy = "category")
    private Set<Food> foodList;

    @OneToMany(mappedBy = "category")
    private Set<RestaurantCategory> restaurantCategoryList;

    public Set<RestaurantCategory> getRestaurantCategoryList() {
        return restaurantCategoryList;
    }

    public void setRestaurantCategoryList(Set<RestaurantCategory> restaurantCategoryList) {
        this.restaurantCategoryList = restaurantCategoryList;
    }

    public Set<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(Set<Food> foodList) {
        this.foodList = foodList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
