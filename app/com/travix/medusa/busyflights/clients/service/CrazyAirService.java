package com.travix.medusa.busyflights.clients.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.google.inject.ImplementedBy;
import com.travix.medusa.busyflights.clients.CrazyAirClient;
import com.travix.medusa.busyflights.clients.exceptions.ServerException;
import com.travix.medusa.busyflights.domain.Response;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;

@ImplementedBy(CrazyAirClient.class)
public interface CrazyAirService {
	CompletableFuture<List<Response>> getCrazyAirFlight(final CrazyAirRequest request) throws ServerException;
}
