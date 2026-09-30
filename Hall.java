package com.hallease.api.model;

import jakarta.persistence.*;

@Entity
public class Hall {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private int capacity;
    private double price;

    public Hall() {}
    public Hall(String name, String location, int capacity, double price) {
        this.name=name; this.location=location; this.capacity=capacity; this.price=price;
    }
    public Long getId(){return id;} public String getName(){return name;}
    public void setName(String v){name=v;} public String getLocation(){return location;}
    public void setLocation(String v){location=v;} public int getCapacity(){return capacity;}
    public void setCapacity(int v){capacity=v;} public double getPrice(){return price;}
    public void setPrice(double v){price=v;}
}