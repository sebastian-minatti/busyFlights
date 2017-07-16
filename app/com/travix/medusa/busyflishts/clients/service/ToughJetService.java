package com.travix.medusa.busyflishts.clients.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.google.inject.ImplementedBy;
import com.travix.medusa.busyflights.domain.Response;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflishts.clients.ToughJetClient;
import com.travix.medusa.busyflishts.clients.exceptions.ServerException;

@ImplementedBy(ToughJetClient.class)
public interface ToughJetService {
	CompletableFuture<List<Response>> getToughJetFlight(final ToughJetRequest request) throws ServerException;
}
