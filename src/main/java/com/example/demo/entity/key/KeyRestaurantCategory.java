package com.example.demo.entity.key;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class KeyRestaurantCategory implements Serializable {

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "restaurant_id")
    private int restaurantId;

    public KeyRestaurantCategory(){}

    public KeyRestaurantCategory(int categoryId,int restaurantId){
        this.categoryId = categoryId;
        this.restaurantId = restaurantId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}
