package com.travix.medusa.busyflights.model.service;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import com.google.inject.ImplementedBy;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflishts.clients.exceptions.ServerException;

@ImplementedBy(BusyFlightServiceImpl.class)
public interface BusyFlightService {
	CompletableFuture<Stream<BusyFlightsResponse>> getFlights(BusyFlightsRequest request) throws ServerException;
}
