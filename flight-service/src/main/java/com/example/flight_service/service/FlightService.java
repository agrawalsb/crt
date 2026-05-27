package com.example.flight_service.service;

import com.example.flight_service.entity.Flight;

import java.util.List;

public interface FlightService {

    Flight save(Flight f);

    Flight findByCode(String code);

    List<Flight> findByCarrier(String carrier);

    List<Flight> findByRoute(
            String source,
            String destination
    );

    List<Flight> findByPriceRange(
            double min,
            double max
    );

    List<Flight> list();

    void delete(String code);
}