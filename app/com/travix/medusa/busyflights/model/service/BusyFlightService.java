package com.travix.medusa.busyflights.model.service;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import com.google.inject.ImplementedBy;
import com.travix.medusa.busyflights.clients.exceptions.ServerException;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

@ImplementedBy(BusyFlightServiceImpl.class)
public interface BusyFlightService {
	CompletableFuture<Stream<BusyFlightsResponse>> getFlights(BusyFlightsRequest request) throws ServerException;
}
