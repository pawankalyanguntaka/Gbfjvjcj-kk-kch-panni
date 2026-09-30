package com.hallease.api.controller;

import com.hallease.api.model.*;
import com.hallease.api.repo.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins="*")
public class BookingController {
    private final BookingRepository bookings;
    private final HallRepository halls;
    public BookingController(BookingRepository bookings, HallRepository halls){this.bookings=bookings;this.halls=halls;}

    @GetMapping("/history")
    public List<Booking> history(){return bookings.findAllByOrderByCreatedAtDesc();}

    @GetMapping("/hall/{hallId}/history")
    public List<Booking> hallHistory(@PathVariable Long hallId){
        return bookings.findByHallIdOrderByBookingDateDesc(hallId);
    }

    @GetMapping
    public List<Booking> byDate(@RequestParam Long hallId,@RequestParam String date){
        return bookings.findByHallIdAndBookingDate(hallId,LocalDate.parse(date));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BookingRequest r){
        try{
            Hall hall=halls.findById(r.hallId()).orElseThrow();
            if(bookings.existsByHallIdAndBookingDate(hall.getId(),r.bookingDate()))
                return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message","Hall already booked for this date."));
            double total=hall.getPrice()+r.chairPackage()+r.decoration()+(r.extraChairs()*50.0);
            Booking b=new Booking();
            b.setCustomerName(r.customerName());b.setMobile(r.mobile());b.setEmail(r.email());
            b.setEventType(r.eventType());b.setHall(hall);b.setBookingDate(r.bookingDate());
            b.setGuests(r.guests());b.setExtraChairs(r.extraChairs());b.setChairPackage(r.chairPackage());
            b.setDecoration(r.decoration());b.setPaymentMethod(r.paymentMethod());b.setTotal(total);
            b.setAdvance(Math.round(total*.25*100)/100.0);b.setStatus("CONFIRMED");
            return ResponseEntity.ok(bookings.save(b));
        }catch(Exception e){return ResponseEntity.badRequest().body(Map.of("message","Invalid booking data."));}
    }

    public record BookingRequest(String customerName,String mobile,String email,String eventType,
        Long hallId,LocalDate bookingDate,int guests,int extraChairs,int chairPackage,int decoration,String paymentMethod){}
}