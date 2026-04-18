package com.uber.uberApp.strategies.impl;

import com.uber.uberApp.entities.Driver;
import com.uber.uberApp.entities.RideRequest;
import com.uber.uberApp.repositories.DriverRepository;
import com.uber.uberApp.strategies.DriverMatchingStrategy;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findMatchingDrivers((rideRequest.getPickupLocation()));
    }
}
