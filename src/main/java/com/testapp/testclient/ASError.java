package com.testapp.testclient;

/**
 * Application error interface
 */
public interface ASError {

    /**
     * Returns error code. Error codes are recognize system-wide and are returned by web services
     * for exceptional situations. the codes are used in the other applications, such AS AS2.0 UI
     * component that uses these codes to get the error message from dotCMS static content service.
     *
     * @return Error code
     */
    String getCode();

    /**
     * Returns human-friendly error message. These message are returned by web services, but they
     * are not necessarily be presented to end user and mostly are meant to be for logging purposes.
     *
     * @return Error message
     */
    String getMessage();
}
