package com.uskoryaev.travelbot.exception;

public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException(String message) {
        super(String.format("City not found by %s", message));
    }
}
