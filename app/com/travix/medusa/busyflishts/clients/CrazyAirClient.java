package com.travix.medusa.busyflishts.clients;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;

import com.travix.medusa.busyflights.domain.Response;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflishts.clients.exceptions.ServerException;
import com.travix.medusa.busyflishts.clients.service.CrazyAirService;
import com.travix.medusa.busyflishts.clients.util.HTTPMethod;

public class CrazyAirClient implements CrazyAirService {

	// (TODO) move to application.conf file
	private String url = "http://localhost:9000/crazyair/flights"; 
	private final HTTPClient<CrazyAirResponse> client;
	
	@Inject
	public CrazyAirClient(HTTPClient<CrazyAirResponse> client) {
		this.client = client;
	}

	@Override
	public CompletableFuture<List<Response>> getCrazyAirFlight(final CrazyAirRequest request) throws ServerException {
		return client.execute(url, HTTPMethod.POST, request, CrazyAirResponse.class);
	}    
}
