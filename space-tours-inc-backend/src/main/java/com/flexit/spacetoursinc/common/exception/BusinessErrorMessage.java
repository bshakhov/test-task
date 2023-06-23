package com.flexit.spacetoursinc.common.exception;

public enum BusinessErrorMessage {
    AVAILABILITY_DATE_IN_THE_PAST("Availability date in the past has been provided"),
    FETCHING_LIST_OF_PROPELLANTS("Error fetching list of propellants"),
    FETCHING_SINGLE_PROPELLANT("Error fetching a single propellant"),
    PROPELLANT_FOR_SPACESHIP_NOT_FOUND("Propellant for spaceship not found");

    private final String errorMessage;

    BusinessErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
