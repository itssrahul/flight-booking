package com.airtravel.flightbooking.model;

import javax.persistence.*;

@Entity
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingId;

    @Column
    private String departureCode;

    @Column
    private String arrivalCode;

    @Column
    private String passengerName;


    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getDepartureCode() {
        return departureCode;
    }

    public void setDepartureCode(String departureCode) {
        this.departureCode = departureCode;
    }

    public String getArrivalCode() {
        return arrivalCode;
    }

    public void setArrivalCode(String arrivalCode) {
        this.arrivalCode = arrivalCode;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public FlightBooking(String departureCode, String arrivalCode, String passengerName) {
        this.departureCode = departureCode;
        this.arrivalCode = arrivalCode;
        this.passengerName = passengerName;
    }

    public FlightBooking(){}
}
