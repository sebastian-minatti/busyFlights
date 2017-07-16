package com.travix.medusa.busyflishts.clients.util;

import com.google.inject.Singleton;
import com.travix.medusa.busyflishts.clients.exceptions.RedirectionErrorException;

import play.Logger;
import play.libs.ws.WSResponse;

/**
 * (TODO) We must improve exceptions and check each status code.
 * WSResponse has more information that could be useful to take a look here.
 */
@Singleton
public final class ErrorHandler {
	
	/**
	 * Verify if the status code from server response has an error.
	 * @param response   The server response.
	 * @throws Exception
	 */
    public void handleErrors(final WSResponse response) throws Exception {    	  
        int status = response.getStatus();
    	if (isRedirection(status)) {
    		Logger.info("Redirection Error.");
            throw new RedirectionErrorException("Redirection Error");
        } else if (isClientError(status)) {
        	Logger.info("client Error.");
        	throw new RedirectionErrorException("client Error");
        } else if(isServerError(status)){
        	Logger.info("Server Error.");
        	throw new RedirectionErrorException("Server Error");
        } else if(!isSuccess(status)){
        	Logger.info("Unofficial Error.");
        	throw new RedirectionErrorException("Unofficial Error");
        }
    }
    
    private boolean isSuccess(int status) {
        return ((200 <= status) && (status < 300));
    }
    
    private boolean isRedirection(int status) {
        return ((300 <= status) && (status < 400));
    }

    private boolean isClientError(int status) {
        return ((400 <= status) && (status < 500));
    }
    
    private boolean isServerError(int status) {
        return ((500 <= status) && (status < 512));
    }
}
