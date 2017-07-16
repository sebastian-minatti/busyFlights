package com.travix.medusa.busyflights.domain.toughjet;

import com.travix.medusa.busyflights.domain.Request;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;

public class ToughJetRequest implements Request { 

    private String from;
    private String to;
    private String outboundDate;
    private String inboundDate;
    private int numberOfAdults;

    public ToughJetRequest(){} // need a default constructor for parsing staff.
    
    public ToughJetRequest(BusyFlightsRequest request){
    	this.from = request.getOrigin();
    	this.to = request.getDestination();
    	this.outboundDate = request.getDepartureDate();
    	this.inboundDate = request.getReturnDate();
    	this.numberOfAdults = request.getNumberOfPassengers();
    }
    
    public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public String getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(final String outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(final String inboundDate) {
        this.inboundDate = inboundDate;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(final int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }
}
