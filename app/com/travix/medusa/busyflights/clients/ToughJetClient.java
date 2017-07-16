package com.travix.medusa.busyflights.clients;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;

import com.travix.medusa.busyflights.clients.exceptions.ServerException;
import com.travix.medusa.busyflights.clients.service.ToughJetService;
import com.travix.medusa.busyflights.clients.util.HTTPMethod;
import com.travix.medusa.busyflights.domain.Response;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

public class ToughJetClient implements ToughJetService {
	
	// (TODO) move to application.conf file
	private String url = "http://localhost:9000/toughjet/flights";
	private final HTTPClient<ToughJetResponse> client;
	
	@Inject
	public ToughJetClient(HTTPClient<ToughJetResponse> client) {
		this.client = client;
	}

	@Override
	public CompletableFuture<List<Response>> getToughJetFlight(ToughJetRequest request) throws ServerException {
		return client.execute(url, HTTPMethod.POST, request, ToughJetResponse.class);		
	}

}
