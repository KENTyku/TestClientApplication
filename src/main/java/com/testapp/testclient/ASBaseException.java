package com.testapp.testclient;

import org.apache.commons.lang3.StringUtils;

/**
 * Base class for all application exceptions. It's abstract, so that only subclasses can be instantiated.
 * Accepts ASError from the application errors registry. The error itself contains self-sufficient
 * error message, so a possibility to pass message to the exception is optional, and is meant to provide
 * a way to specify the general error message.
 */
public abstract class ASBaseException extends RuntimeException {

    private final ASError error;

    public ASBaseException(ASError error) {
        this.error = error;
    }

    public ASBaseException(ASError error, String message) {
        super(message);
        this.error = error;
    }

    public ASBaseException(ASError error, String message, Throwable cause) {
        super(message, cause);
        this.error = error;
    }

    /**
     * Author Services (API-dependent) error.
     */
    public ASError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        StringBuilder result = new StringBuilder();

        result
                .append('(')
                .append(error.getCode())
                .append(") ")
                .append(error.getMessage());

        if (StringUtils.isNotBlank(super.getMessage())) {
            result
                    .append(": ")
                    .append(super.getMessage());
        }

        return result.toString();
    }

    public String getOriginalMessage() {
        return super.getMessage();
    }

}
