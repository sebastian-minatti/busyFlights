package com.travix.medusa.busyflights.domain;

public class ServerException implements Response {
	private String message;
	
	public ServerException(String message){
		this.message = message;
	}
}
