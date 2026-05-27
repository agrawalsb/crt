package com.example.flight_service.serviceImpl;

import com.example.flight_service.entity.Flight;
import com.example.flight_service.repository.FlightRepository;
import com.example.flight_service.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository repo;

    @Override
    public Flight save(Flight f) {
        return repo.save(f);
    }

    @Override
    public Flight findByCode(String code) {
        return repo.findById(code).orElse(null);
    }

    @Override
    public List<Flight> findByCarrier(String carrier) {
        return repo.findByCarrier(carrier);
    }

    @Override
    public List<Flight> findByRoute(
            String source,
            String destination
    ) {
        return repo.findBySourceAndDestination(
                source,
                destination
        );
    }

    @Override
    public List<Flight> findByPriceRange(
            double min,
            double max
    ) {
        return repo.findByCostBetween(min, max);
    }

    @Override
    public List<Flight> list() {
        return repo.findAll();
    }

    @Override
    public void delete(String code) {
        repo.deleteById(code);
    }
}