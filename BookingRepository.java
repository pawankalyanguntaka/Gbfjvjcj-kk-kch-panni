package com.hallease.api.repo;
import com.hallease.api.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
public interface BookingRepository extends JpaRepository<Booking,Long> {
    boolean existsByHallIdAndBookingDate(Long hallId, LocalDate date);
    List<Booking> findByHallIdAndBookingDate(Long hallId, LocalDate date);
    List<Booking> findAllByOrderByCreatedAtDesc();
    List<Booking> findByHallIdOrderByBookingDateDesc(Long hallId);
}