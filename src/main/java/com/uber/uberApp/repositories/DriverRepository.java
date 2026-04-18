package com.uber.uberApp.repositories;

import com.uber.uberApp.entities.Driver;
import com.uber.uberApp.entities.Rider;
import com.uber.uberApp.entities.User;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    // ST_Distance(point1, point2)
    // ST_DWithin(point1, 1000)
    @Query(value = "SELECT D.*, ST_Distance(D.current_location, :pickupLocation) AS DISTANCE " +
            "FROM DRIVER D " +
            "WHERE AVAILABLE = TRUE AND ST_DWithin(D.current_location, :pickupLocation, 1000) " +
            "ORDER BY DISTANCE LIMIT 10", nativeQuery = true)
    List<Driver> findMatchingDrivers(Point pickupLocation);

    @Query(value = "SELECT D.* FROM DRIVER D WHERE D.AVAILABLE = TRUE AND ST_DWithin(d.current_location, :pickupLocation, 15000) " +
            "ORDER BY D.RATING DESC LIMIT 10", nativeQuery = true)
    List<Driver> findTenNearByTopRatedDrivers(Point pickupLocation);

    Optional<Driver> findByUser(User user);

}
