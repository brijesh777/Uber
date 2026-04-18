package com.uber.uberApp.dto;


import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(indexes = {
        @Index(name = "idx_rating_rider", columnList = "rider_id"),
        @Index(name = "idx_rating_driver", columnList = "driver_id")
})
public class RatingDto {
    private Long rideId;
    private Integer rating;
}
