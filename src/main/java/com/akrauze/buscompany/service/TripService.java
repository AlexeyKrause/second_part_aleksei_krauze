package com.akrauze.buscompany.service;

import com.akrauze.buscompany.dtorequest.AddTripDtoRequest;
import com.akrauze.buscompany.dtoresponse.TripDatesDtoResponse;
import com.akrauze.buscompany.dtoresponse.TripDtoResponse;
import com.akrauze.buscompany.dtoresponse.TripScheduleDtoResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TripService {


    public TripDtoResponse postTrip(AddTripDtoRequest dtoRequest, HttpServletRequest httpServletRequest) {
        if (dtoRequest.getClass().getName().equals("AddTripScheduleDtoRequest")) {

            return new TripScheduleDtoResponse();
        } else {

            return new TripDatesDtoResponse();
        }
    }
}
