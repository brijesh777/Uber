package com.uber.uberApp.strategies;

import com.uber.uberApp.entities.Driver;
import com.uber.uberApp.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {
    List<Driver> findMatchingDriver(RideRequest rideRequest);

}
