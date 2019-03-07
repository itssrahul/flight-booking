package com.airtravel.flightbooking.repo;

import com.airtravel.flightbooking.model.FlightOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface OfferRepo extends JpaRepository<FlightOffer, Long> {

    FlightOffer findByDepartureAndArrival(String departure, String arrival);
}
