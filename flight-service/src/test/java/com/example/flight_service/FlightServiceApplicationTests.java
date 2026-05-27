package com.example.flight_service;

import com.example.flight_service.entity.Flight;
import com.example.flight_service.service.FlightService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightServiceApplicationTests {

    @Autowired
    private FlightService service;

    @Test
    void testSave() {

        Flight f = new Flight();

        f.setCode("TEST101");
        f.setCarrier("Test Airline");
        f.setSource("Nagpur");
        f.setDestination("Delhi");
        f.setCost(5000);

        Flight saved = service.save(f);

        assertNotNull(saved);
    }

    @Test
    void testFindByCode() {

        Flight f = service.findByCode("AI101");

        assertNotNull(f);
    }

    @Test
    void testFindByCarrier() {

        List<Flight> list =
                service.findByCarrier("Air India");

        assertFalse(list.isEmpty());
    }

    @Test
    void testFindByRoute() {

        List<Flight> list =
                service.findByRoute(
                        "Nagpur",
                        "Delhi"
                );

        assertFalse(list.isEmpty());
    }

    @Test
    void testFindByPriceRange() {

        List<Flight> list =
                service.findByPriceRange(
                        4000,
                        6000
                );

        assertFalse(list.isEmpty());
    }

    @Test
    void testList() {

        List<Flight> list = service.list();

        assertNotNull(list);
    }
}