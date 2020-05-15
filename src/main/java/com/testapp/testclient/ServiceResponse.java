package com.testapp.testclient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * This is the generic service VO object which is returned all web service operations.
 *
 * @param <P> payload type.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"status", "payload"})
public class ServiceResponse<P> {

    /**
     * Response statuses
     */
    public enum Status {
        SUCCESS,
        FAILURE
    }

    private Status status;
    private P payload;

    // hidden constructor; factory methods should be used for instance creations
    private ServiceResponse() {
    }

    /**
     * Creates a success response
     *
     * @return service response object
     */
    public static ServiceResponse<Void> success() {
        ServiceResponse<Void> response = new ServiceResponse<>();
        response.setStatus(Status.SUCCESS);
        return response;
    }

    /**
     * Creates a success response with payload
     *
     * @param <P>     type of response payload.
     * @param payload payload data.
     * @return service response object
     */
    public static <P> ServiceResponse<P> success(P payload) {
        ServiceResponse<P> response = new ServiceResponse<>();
        response.setStatus(Status.SUCCESS);
        response.setPayload(payload);
        return response;
    }

    /**
     * Creates a failure response
     *
     * @param <P> type of response payload.
     * @return service response object
     */
    public static <P> ServiceResponse<P> failure() {
        ServiceResponse<P> response = new ServiceResponse<>();
        response.setStatus(Status.FAILURE);
        return response;
    }

//    /**
//     * Creates an error response with ASError and payload
//     *
//     * @param <P>     type of response payload.
//     * @param error   ASError object
//     * @param payload payload to sen in service response.
//     * @param refId   transaction ID.
//     * @return response object with failure status and error information set.
//     */
//    public static <P> ServiceResponse<P> failure(ASError error, P payload, String refId) {
//        ServiceError serviceError = ServiceError.of(error, refId);
//        ServiceResponse<P> response = new ServiceResponse<>();
//        response.setStatus(Status.FAILURE);
//        response.setError(serviceError);
//        response.setPayload(payload);
//        return response;
//    }
//
//    /**
//     * Creates an error response with ServiceError an payload
//     */
//    public static <P> ServiceResponse<P> failure(ServiceError serviceError, P payload) {
//        ServiceResponse<P> response = new ServiceResponse<>();
//        response.setStatus(Status.FAILURE);
//        response.setError(serviceError);
//        response.setPayload(payload);
//        return response;
//    }
//
//    /**
//     * Creates an error response with ServiceError
//     *
//     * @param <P>          type of response payload.
//     * @param serviceError ServiceError object
//     * @return service response object
//     */
//    public static <P> ServiceResponse<P> failure(ServiceError serviceError) {
//        return failure(serviceError, null);
//    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
//
//    public ServiceError getError() {
//        return error;
//    }
//
//    public void setError(ServiceError error) {
//        this.error = error;
//    }

    public P getPayload() {
        return payload;
    }

    public void setPayload(P payload) {
        this.payload = payload;
    }
}
