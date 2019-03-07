package com.airtravel.flightbooking.model;

import javax.persistence.*;

@Entity
public class FlightOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String departure;
    @Column
    private String arrival;
    @Column
    private String offerPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(String offerPrice) {
        this.offerPrice = offerPrice;
    }

    public FlightOffer(String departure, String arrival, String offerPrice) {
        this.departure = departure;
        this.arrival = arrival;
        this.offerPrice = offerPrice;
    }

    public FlightOffer(){}
}
