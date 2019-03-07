package com.airtravel.flightbooking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airport {

    @Id
    private String iataCode;

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airport(String iataCode, String name) {
        this.iataCode = iataCode;
        this.name = name;
    }

    public Airport(){}
    @Column
    private String name;
}
