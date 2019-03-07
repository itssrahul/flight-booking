package com.airtravel.flightbooking.repo;

import com.airtravel.flightbooking.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Transactional
public interface FlightRepo extends JpaRepository<Flight, Long> {

    List<Flight> findByDepartureAndDepartureDateGreaterThan(String departure, LocalDateTime departureDate);

    Flight findByDepartureAndArrival(String departure, String arrival);

    Flight findById(Id id);
}
