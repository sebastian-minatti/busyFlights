package com.travix.medusa.busyflights.clients.exceptions;

public class ClientErrorException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ClientErrorException(String message) {
	        super(message);
	}
	public ClientErrorException(String message, Throwable throwable) {
        super(message, throwable);
	}
}
