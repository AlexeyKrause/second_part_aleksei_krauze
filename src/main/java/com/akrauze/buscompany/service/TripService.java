package com.akrauze.buscompany.service;

import com.akrauze.buscompany.daoimpl.BusDaoImpl;
import com.akrauze.buscompany.daoimpl.DateTripDaoImpl;
import com.akrauze.buscompany.daoimpl.TripDaoImpl;
import com.akrauze.buscompany.dtorequest.AddTripDtoRequest;
import com.akrauze.buscompany.dtoresponse.TripDatesDtoResponse;
import com.akrauze.buscompany.dtoresponse.TripDtoResponse;
import com.akrauze.buscompany.dtoresponse.TripScheduleDtoResponse;
import com.akrauze.buscompany.exception.ServerException;
import com.akrauze.buscompany.mappers.TripMapper;
import com.akrauze.buscompany.model.TripSchedule;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TripService {
    private final DateTripDaoImpl dateTripDao;
    private final TripDaoImpl tripDao;
    private final BusDaoImpl busDao;
    private final TripMapper tripMapper;
    private final ValidateService validateService;

    public TripService(DateTripDaoImpl dateTripDao, TripDaoImpl tripDao, BusDaoImpl busDao, TripMapper tripMapper, ValidateService validateService) {
        this.dateTripDao = dateTripDao;
        this.tripDao = tripDao;
        this.busDao = busDao;
        this.tripMapper = tripMapper;
        this.validateService = validateService;
    }

    public TripDtoResponse postTrip(AddTripDtoRequest dtoRequest,
                                    HttpServletRequest httpServletRequest) throws ServerException {
        validateService.checkUserRole(httpServletRequest, "ADMIN");
        if (dtoRequest.getClass().getName().equals("AddTripScheduleDtoRequest")) {
            TripSchedule tripSchedule = tripMapper.dtoScheduleToModel(dtoRequest);
            tripDao.insertTripSchedule(tripSchedule, busDao.getByName(dtoRequest.getBusName()).getId());

            return new TripScheduleDtoResponse();
        } else {

            return new TripDatesDtoResponse();
        }
    }


}
