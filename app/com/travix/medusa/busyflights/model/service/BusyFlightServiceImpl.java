package com.travix.medusa.busyflights.model.service;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.travix.medusa.busyflights.domain.Response;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflishts.clients.exceptions.ServerException;
import com.travix.medusa.busyflishts.clients.service.CrazyAirService;
import com.travix.medusa.busyflishts.clients.service.ToughJetService;

@Singleton
public class BusyFlightServiceImpl implements BusyFlightService {
	
	private final CrazyAirService crazyAirClient;
	private final ToughJetService toughJetClient;
	
	@Inject
	public BusyFlightServiceImpl(CrazyAirService crazyAirClient, ToughJetService toughJetClient) {
		this.crazyAirClient = crazyAirClient;
		this.toughJetClient = toughJetClient;
	}
	
	// (TODO) in case of ServerException i should do something with that information.
	@Override
	public CompletableFuture<Stream<BusyFlightsResponse>> getFlights(final BusyFlightsRequest request) throws ServerException {
		final CrazyAirRequest crazyRequest = new CrazyAirRequest(request);
		final ToughJetRequest toughRequest = new ToughJetRequest(request);
		
		final CompletableFuture<List<Response>> crazyAirResponse = crazyAirClient.getCrazyAirFlight(crazyRequest);
		final CompletableFuture<List<Response>> toughJetResponse = toughJetClient.getToughJetFlight(toughRequest);
		 
		return crazyAirResponse.thenCombine(toughJetResponse, (crazyAirResponses, toughJetResponses) -> {	
			Stream<BusyFlightsResponse> r1 = crazyAirResponses.stream().filter(r -> r instanceof CrazyAirResponse) 
																	   .map(r -> new BusyFlightsResponse((CrazyAirResponse)r));
			Stream<BusyFlightsResponse> r2 = toughJetResponses.stream().filter(r -> r instanceof ToughJetResponse)
																	   .map(r -> new BusyFlightsResponse((ToughJetResponse)r));
			return Stream.concat(r1, r2).sorted(Comparator.comparing( bf -> bf.getFare()));
		});
	}
}
