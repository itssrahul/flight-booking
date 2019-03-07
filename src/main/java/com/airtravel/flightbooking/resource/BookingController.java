package com.airtravel.flightbooking.resource;

import com.airtravel.flightbooking.model.Flight;
import com.airtravel.flightbooking.model.FlightBooking;
import com.airtravel.flightbooking.repo.FlightBookingRepo;
import com.airtravel.flightbooking.repo.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    private FlightBookingRepo flightBookingRepo;

    @Autowired
    private FlightRepo flightRepo;

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public String bookFlight(@RequestParam("from") String from, @RequestParam("to") String to,
                                                 @RequestParam("flightId") String flightId, @RequestParam("passengerName") String passengerName){

        // Assuming From/To codes would be correct; so not validating
        FlightBooking flightBooking = new FlightBooking(from, to, passengerName);

        // validating is passed flight  id is correct or not
        Optional<Flight> flightOptional = flightRepo.findById(Long.valueOf(flightId));
        if(flightOptional.isPresent()){
            Flight flight =  flightOptional.get();
            flightBooking.setFlight(flight);

            flightBookingRepo.save(flightBooking);
            return "Booking Completed";

        }else {
            return "Booking Failed, invalid Flight ID";
        }

    }
}


