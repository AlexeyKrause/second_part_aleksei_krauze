package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.dtorequest.AddTripDtoRequest;
import com.akrauze.buscompany.dtoresponse.TripDtoResponse;
import com.akrauze.buscompany.service.TripService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/trips")
public class TripController {
    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TripDtoResponse postTrip(@Valid @RequestBody AddTripDtoRequest dtoRequest, HttpServletRequest httpServletRequest) {
//        tripService.
        return null;
    }
}
