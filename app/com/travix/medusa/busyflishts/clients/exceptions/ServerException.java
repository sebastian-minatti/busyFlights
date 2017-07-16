package com.travix.medusa.busyflishts.clients.exceptions;

import java.util.concurrent.CompletionException;

public class ServerException extends CompletionException {
	private static final long serialVersionUID = 1L;
	
	public ServerException(String message){
		super(message);
	}
	
    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
