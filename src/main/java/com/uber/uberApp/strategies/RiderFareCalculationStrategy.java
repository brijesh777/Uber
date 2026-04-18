package com.uber.uberApp.strategies;

import com.uber.uberApp.entities.RideRequest;

public interface RiderFareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER = 10;
    double SURGE_FACTOR = 2;

    double calculateFare(RideRequest request);


}
