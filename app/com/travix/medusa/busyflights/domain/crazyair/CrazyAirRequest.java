package com.travix.medusa.busyflights.domain.crazyair;

import com.travix.medusa.busyflights.domain.Request;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;

public class CrazyAirRequest implements Request {

    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private int passengerCount;

    public CrazyAirRequest() {} // I need a default constructor for parsing staff
    
    public CrazyAirRequest(BusyFlightsRequest request){
    	this.origin = request.getOrigin();
    	this.destination = request.getDestination();
    	this.departureDate = request.getDepartureDate();
    	this.returnDate = request.getReturnDate();
    	this.passengerCount = request.getNumberOfPassengers();
    }
    
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(final String returnDate) {
        this.returnDate = returnDate;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(final int passengerCount) {
        this.passengerCount = passengerCount;
    }
}
