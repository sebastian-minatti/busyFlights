package com.travix.medusa.busyflishts.controllers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * This should be deployed in other server for now is OK. And we should create service and repositories to access
 * data.
 */

public class ToughJetController extends Controller {
	private final FormFactory formFactory;
    private final HttpExecutionContext ec;

    @Inject
    public ToughJetController(FormFactory formFactory, HttpExecutionContext ec) {
    	this.formFactory = formFactory;
    	this.ec = ec;
    }
    
    public CompletionStage<Result> getFlights(){
    	Form<ToughJetRequest> form = formFactory.form(ToughJetRequest.class).bindFromRequest();
    	
    	if(form.hasErrors()){
    		return CompletableFuture.supplyAsync(()	-> badRequest());
    	} else {    	
	        return CompletableFuture.supplyAsync(()	-> { 
	    		// (TODO) We should create DAO pattern to get information and create data dynamically
	        	ToughJetRequest request = form.get();
	    		ToughJetResponse response = new ToughJetResponse("airline", 100.0, 200D, 20D, "ARG", "BRA", "12-05-2017","16-05-2017");
	        	return ok(Json.toJson(response));
    		});
    	}
    }
}
