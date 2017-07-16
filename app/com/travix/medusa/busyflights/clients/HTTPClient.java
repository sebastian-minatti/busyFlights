package com.travix.medusa.busyflights.clients;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.fasterxml.jackson.databind.JsonNode;
import com.travix.medusa.busyflights.clients.exceptions.ServerException;
import com.travix.medusa.busyflights.clients.util.ErrorHandler;
import com.travix.medusa.busyflights.domain.Request;
import com.travix.medusa.busyflights.domain.Response;

import play.Logger;
import play.libs.Json;
import play.libs.ws.WSClient;

/**
 * Default HTTP client. Should be used only when the response from server is a JSON.
 * 
 * (TODO) we need to configuring client timeout, idle, request, SSL, caching, etc
 * should be done by application.conf file.
 * 
 * @param <T> The Response expected.
 */
@Singleton
public class HTTPClient<T extends Response> {
	
	private final WSClient ws;
	private final ErrorHandler errorHandler;
	
	@Inject
	public HTTPClient(WSClient ws, ErrorHandler errorHandler){
		this.ws = ws;
		this.errorHandler = errorHandler;
	}
	
	/**
	 * Execute a request.
	 * 
	 * @param url     The url to connect with.
	 * @param method  The HTTP Method.
	 * @param request The request to send.
	 * @param clazz   The response class expected.
	 * @return The response from server could be an exception.
	 */
    protected CompletableFuture<List<Response>> execute(String url, String method, Request request, Class<T> clazz) {    	
    	return ws.url(url).setMethod(method).setBody(Json.toJson(request)).stream().thenApply( response -> {
				try {
					errorHandler.handleErrors(response);
					Logger.info("Request to client successfully done for url {} with body {}.", url, Json.toJson(request));
					return parseJsonAsArray(response.asJson(), clazz);					
				} catch (Exception e) {
					Logger.error("Exception on request url {} with body {}, cause {} ", url, Json.toJson(request), e.getMessage());
					throw new ServerException(e.getMessage(), e.getCause());
				} 								
    	}).toCompletableFuture();
    }
    
    private List<Response> parseJsonAsArray(final JsonNode json, final Class<T> clazz){
    	List<Response> resṕonse = new ArrayList<Response>();
    	
    	if(json.isArray()){
    		for(final JsonNode node: json){
    			resṕonse.add( Json.fromJson(node, clazz) );
    		}
    	} else {
    		resṕonse.add( Json.fromJson(json, clazz) );
    	}
    	
    	return resṕonse;
    }
}
