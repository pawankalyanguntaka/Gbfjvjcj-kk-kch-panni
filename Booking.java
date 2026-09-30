package com.hallease.api.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="bookings", uniqueConstraints=@UniqueConstraint(columnNames={"hall_id","booking_date"}))
public class Booking {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String mobile;
    private String email;
    private String eventType;
    @ManyToOne(optional=false) private Hall hall;
    @Column(name="booking_date", nullable=false) private LocalDate bookingDate;
    private int guests;
    private int extraChairs;
    private int chairPackage;
    private int decoration;
    private String paymentMethod;
    private double total;
    private double advance;
    private String status;
    private LocalDateTime createdAt;

    @PrePersist void created(){ createdAt=LocalDateTime.now(); if(status==null) status="CONFIRMED"; }

    public Long getId(){return id;} public String getCustomerName(){return customerName;}
    public void setCustomerName(String v){customerName=v;} public String getMobile(){return mobile;}
    public void setMobile(String v){mobile=v;} public String getEmail(){return email;}
    public void setEmail(String v){email=v;} public String getEventType(){return eventType;}
    public void setEventType(String v){eventType=v;} public Hall getHall(){return hall;}
    public void setHall(Hall v){hall=v;} public LocalDate getBookingDate(){return bookingDate;}
    public void setBookingDate(LocalDate v){bookingDate=v;} public int getGuests(){return guests;}
    public void setGuests(int v){guests=v;} public int getExtraChairs(){return extraChairs;}
    public void setExtraChairs(int v){extraChairs=v;} public int getChairPackage(){return chairPackage;}
    public void setChairPackage(int v){chairPackage=v;} public int getDecoration(){return decoration;}
    public void setDecoration(int v){decoration=v;} public String getPaymentMethod(){return paymentMethod;}
    public void setPaymentMethod(String v){paymentMethod=v;} public double getTotal(){return total;}
    public void setTotal(double v){total=v;} public double getAdvance(){return advance;}
    public void setAdvance(double v){advance=v;} public String getStatus(){return status;}
    public void setStatus(String v){status=v;} public LocalDateTime getCreatedAt(){return createdAt;}
}