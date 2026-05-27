package com.example.flight_service.controller;

import com.example.flight_service.entity.Flight;
import com.example.flight_service.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "http://localhost:5173")
public class FlightController {

    @Autowired
    private FlightService service;

    @PostMapping
    public Flight save(@RequestBody Flight f) {
        return service.save(f);
    }

    @GetMapping
    public List<Flight> getAll() {
        return service.list();
    }

    @GetMapping("/{code}")
    public Flight getOne(@PathVariable String code) {
        return service.findByCode(code);
    }

    @GetMapping("/carrier/{carrier}")
    public List<Flight> getByCarrier(
            @PathVariable String carrier
    ) {
        return service.findByCarrier(carrier);
    }

    @GetMapping("/route")
    public List<Flight> getByRoute(
            @RequestParam String source,
            @RequestParam String destination
    ) {
        return service.findByRoute(
                source,
                destination
        );
    }

    @GetMapping("/price")
    public List<Flight> getByPrice(
            @RequestParam double min,
            @RequestParam double max
    ) {
        return service.findByPriceRange(min, max);
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable String code) {
        service.delete(code);
    }
}