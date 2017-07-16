package com.travix.medusa.busyflishts.clients.exceptions;

public class UnofficialErrorException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UnofficialErrorException(String message) {
	        super(message);
	}
	public UnofficialErrorException(String message, Throwable throwable) {
        super(message, throwable);
	}
}
