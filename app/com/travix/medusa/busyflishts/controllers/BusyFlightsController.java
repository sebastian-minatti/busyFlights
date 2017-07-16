package com.travix.medusa.busyflishts.controllers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.model.service.BusyFlightService;

import play.mvc.Result;
import play.data.Form;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import java.util.stream.Collectors;
import static play.libs.Json.toJson;

public class BusyFlightsController extends Controller {
	private final FormFactory formFactory;
	private final BusyFlightService service;
    private final HttpExecutionContext ec;

    @Inject
    public BusyFlightsController(FormFactory formFactory, BusyFlightService service, HttpExecutionContext ec) {
    	this.formFactory = formFactory;
    	this.service = service;
    	this.ec = ec;
    }
    
    public Result index() {
        return ok();
    }
    	
    public CompletionStage<Result> getFlights(){
    	Form<BusyFlightsRequest> form = formFactory.form(BusyFlightsRequest.class).bindFromRequest();
    	
    	if(form.hasErrors()){
    		return CompletableFuture.supplyAsync(()	-> badRequest());
    	} else {    
    		// Exceptions are handled by ErrorHandler
    		BusyFlightsRequest request = form.get();
	        return service.getFlights(request).thenApplyAsync( stream -> {
	        	return ok(toJson(stream.collect(Collectors.toList())));
	        }, ec.current());
    	}
    }
}