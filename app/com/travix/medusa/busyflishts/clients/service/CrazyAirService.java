package com.travix.medusa.busyflishts.clients.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.google.inject.ImplementedBy;
import com.travix.medusa.busyflights.domain.Response;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflishts.clients.CrazyAirClient;
import com.travix.medusa.busyflishts.clients.exceptions.ServerException;

@ImplementedBy(CrazyAirClient.class)
public interface CrazyAirService {
	CompletableFuture<List<Response>> getCrazyAirFlight(final CrazyAirRequest request) throws ServerException;
}
