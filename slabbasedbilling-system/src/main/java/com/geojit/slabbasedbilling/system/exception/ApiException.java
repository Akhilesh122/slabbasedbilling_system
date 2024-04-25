package com.geojit.slabbasedbilling.system.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message, Exception e) {
        super(message);
    }
}
