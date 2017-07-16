package com.travix.medusa.busyflights.clients.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.google.inject.ImplementedBy;
import com.travix.medusa.busyflights.clients.ToughJetClient;
import com.travix.medusa.busyflights.clients.exceptions.ServerException;
import com.travix.medusa.busyflights.domain.Response;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;

@ImplementedBy(ToughJetClient.class)
public interface ToughJetService {
	CompletableFuture<List<Response>> getToughJetFlight(final ToughJetRequest request) throws ServerException;
}
