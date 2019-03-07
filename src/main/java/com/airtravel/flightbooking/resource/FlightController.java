package com.airtravel.flightbooking.resource;

import com.airtravel.flightbooking.model.Airport;
import com.airtravel.flightbooking.model.Flight;
import com.airtravel.flightbooking.repo.AirportRepo;
import com.airtravel.flightbooking.repo.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightRepo flightRepo;

    @Autowired
    private AirportRepo airportRepo;


    @RequestMapping(value = "/findFlightsByCode", method = RequestMethod.POST)
    public Flight findFlightsByAirportCode(@RequestParam("from") String from, @RequestParam("to") String to){
        return flightRepo.findByDepartureAndArrival(from,to);
    }

    @RequestMapping(value = "/findFlightsByCityName", method = RequestMethod.POST)
    public Flight findFlightsByCity(@RequestParam("from") String from, @RequestParam("to") String to){

        Airport fromAirport = airportRepo.findByNameIsContaining(from);
        Airport toAirport = airportRepo.findByNameIsContaining(to);

        if(fromAirport != null && toAirport != null) {

            Flight flight = flightRepo.findByDepartureAndArrival(fromAirport.getIataCode(),toAirport.getIataCode());
            // setting null as we dont want booked flights as of now in response
            if(flight !=null){
                flight.setFlightBookings(null);
            }
            return flight;
        }
        else{
            return new Flight();
        }
    }
}
