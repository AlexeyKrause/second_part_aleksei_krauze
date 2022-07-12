package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.model.TripDtoRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/trips")
public class TripController {



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void postTrip(@Valid @RequestBody TripDtoRequest dtoRequest, HttpServletRequest httpServletRequest) {

    }
}
