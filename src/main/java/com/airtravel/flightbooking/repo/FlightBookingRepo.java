package com.airtravel.flightbooking.repo;

import com.airtravel.flightbooking.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FlightBookingRepo extends JpaRepository<FlightBooking, Long> {
}
