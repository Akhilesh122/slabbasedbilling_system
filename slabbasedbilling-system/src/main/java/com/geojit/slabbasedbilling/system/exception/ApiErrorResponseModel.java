package com.geojit.slabbasedbilling.system.exception;

public record ApiErrorResponseModel(Integer errorCode, String errorMessage) {
}