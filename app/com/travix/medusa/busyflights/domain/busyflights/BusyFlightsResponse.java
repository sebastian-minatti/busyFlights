package com.travix.medusa.busyflights.domain.busyflights;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

public final class BusyFlightsResponse {
	private final String airline;
	private final String supplier;
	private final Double fare;
	private final String departureAirportCode;
    private final String destinationAirportCode;
    private final String departureDate;
    private final String arrivalDate;		
    
	public BusyFlightsResponse(CrazyAirResponse crazyAirResponse) {
		super();
		this.airline = crazyAirResponse.getAirline();
		this.supplier = crazyAirResponse.getClass().getName();
		this.fare = crazyAirResponse.getPrice();
		this.departureAirportCode = crazyAirResponse.getDepartureAirportCode();
		this.destinationAirportCode = crazyAirResponse.getDestinationAirportCode();
		this.departureDate = crazyAirResponse.getDepartureDate();
		this.arrivalDate = crazyAirResponse.getArrivalDate();
	}

	public BusyFlightsResponse(ToughJetResponse toughJetResponse){
		super();
		this.airline = toughJetResponse.getCarrier();
		this.supplier = toughJetResponse.getClass().getName();
		this.fare = toughJetResponse.getTotalPrice();
		this.departureAirportCode = toughJetResponse.getDepartureAirportName();
		this.destinationAirportCode = toughJetResponse.getArrivalAirportName();
		this.departureDate = toughJetResponse.getInboundDateTime();
		this.arrivalDate = toughJetResponse.getOutboundDateTime();		
	}

	public String getAirline() {
		return airline;
	}

	public String getSupplier() {
		return supplier;
	}

	public Double getFare() {
		return fare;
	}

	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}
}
