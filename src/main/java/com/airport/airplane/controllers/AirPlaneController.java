package com.airport.airplane.controllers;

import com.airport.airplane.dto.airplane.input.AirPlaneDTO;
import com.airport.airplane.model.AirPlane;
import com.airport.airplane.service.AirPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("airplane")
public class AirPlaneController {

    @Autowired
    AirPlaneService airPlaneService;

    @PostMapping
    public ResponseEntity<AirPlane> saveAirPlane(@RequestBody AirPlaneDTO input) {
        return new ResponseEntity<>(
                airPlaneService.save(input),
                HttpStatus.CREATED
        );
    }

}
