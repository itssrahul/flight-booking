package com.airtravel.flightbooking.repo;

import com.airtravel.flightbooking.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface AirportRepo extends JpaRepository<Airport,String> {

    Airport findByNameIsContaining(String name);
}
