package com.akrauze.buscompany.service;

import com.akrauze.buscompany.dtorequest.AddTripDtoRequest;
import com.akrauze.buscompany.dtoresponse.TripDatesDtoResponse;
import com.akrauze.buscompany.dtoresponse.TripDtoResponse;
import com.akrauze.buscompany.dtoresponse.TripScheduleDtoResponse;
import com.akrauze.buscompany.exception.ServerException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TripService {
    private final ValidateService validateService;

    public TripService(ValidateService validateService) {
        this.validateService = validateService;
    }

    public TripDtoResponse postTrip(AddTripDtoRequest dtoRequest,
                                    HttpServletRequest httpServletRequest) throws ServerException {
        validateService.checkUserRole(httpServletRequest, "ADMIN");
        if (dtoRequest.getClass().getName().equals("AddTripScheduleDtoRequest")) {

            return new TripScheduleDtoResponse();
        } else {

            return new TripDatesDtoResponse();
        }
    }
}
