package com.travix.medusa.busyflishts.clients;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;

import com.travix.medusa.busyflights.domain.Response;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflishts.clients.exceptions.ServerException;
import com.travix.medusa.busyflishts.clients.service.ToughJetService;
import com.travix.medusa.busyflishts.clients.util.HTTPMethod;

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
