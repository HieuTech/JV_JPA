package com.example.demo.entity;

import com.example.demo.entity.key.KeyOrderDetail;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "order_detail")
public class OrderDetail {

    @EmbeddedId
    KeyOrderDetail keys;

    @ManyToOne()
    @JoinColumn(name = "order_id",insertable=false,updatable = false)
    private Orders orders;

    @ManyToOne()
    @JoinColumn(name = "food_id",insertable = false, updatable = false)
    private Food food;

    @Column(name = "price")
    private double price;

    @Column(name = "create_at")
    private Date createAt;

    public KeyOrderDetail getKeys() {
        return keys;
    }

    public void setKeys(KeyOrderDetail keys) {
        this.keys = keys;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
