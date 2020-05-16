package com.testapp.testclient;

/**
 * General exception for all external services.
 */
public class ExtServiceException extends ASBaseException {

    public ExtServiceException(ASError error) {
        super(error);
    }

    public ExtServiceException(ASError error, String message) {
        super(error, message);
    }

    public ExtServiceException(ASError error, String message, Throwable cause) {
        super(error, message, cause);
    }
}
