package com.airtravel.flightbooking.resource;

import com.airtravel.flightbooking.model.FlightOffer;
import com.airtravel.flightbooking.repo.OfferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {

    @Autowired
    private OfferRepo offerRepo;

    @RequestMapping(value = "/getFlightOfferByAirportCodes", method = RequestMethod.POST)
    public FlightOffer getFlightOffer(@RequestParam("from") String from, @RequestParam("to") String to){
        return offerRepo.findByDepartureAndArrival(from,to);
    }
}
