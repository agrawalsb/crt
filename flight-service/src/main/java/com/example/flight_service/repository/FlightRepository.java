package com.example.flight_service.repository;

import com.example.flight_service.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, String> {

    List<Flight> findByCarrier(String carrier);

    List<Flight> findBySourceAndDestination(
            String source,
            String destination
    );

    List<Flight> findByCostBetween(
            double min,
            double max
    );
}