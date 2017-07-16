package com.travix.medusa.busyflights.clients.exceptions;

public class ServerErrorException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ServerErrorException(String message) {
	        super(message);
	}
	public ServerErrorException(String message, Throwable throwable) {
        super(message, throwable);
	}
}
