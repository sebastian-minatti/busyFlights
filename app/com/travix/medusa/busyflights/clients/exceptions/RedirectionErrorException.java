package com.travix.medusa.busyflights.clients.exceptions;

public class RedirectionErrorException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public RedirectionErrorException(String message) {
	        super(message);
	}
	public RedirectionErrorException(String message, Throwable throwable) {
        super(message, throwable);
	}
}
