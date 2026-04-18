package com.uber.uberApp.services;

import com.uber.uberApp.dto.DriverDto;
import com.uber.uberApp.dto.RideDto;
import com.uber.uberApp.entities.Ride;

public interface RatingService {
    DriverDto rateDriver(Ride ride, Integer rating);

    RideDto rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);

}
