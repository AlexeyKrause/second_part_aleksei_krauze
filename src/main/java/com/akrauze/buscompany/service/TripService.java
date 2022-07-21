package com.akrauze.buscompany.service;

import com.akrauze.buscompany.daoimpl.BusDaoImpl;
import com.akrauze.buscompany.daoimpl.DateTripDaoImpl;
import com.akrauze.buscompany.daoimpl.TripDaoImpl;
import com.akrauze.buscompany.dtorequest.AddTripDtoRequest;
import com.akrauze.buscompany.dtoresponse.TripDtoResponse;
import com.akrauze.buscompany.dtoresponse.TripScheduleDtoResponse;
import com.akrauze.buscompany.exception.ServerException;
import com.akrauze.buscompany.mappers.TripMapper;
import com.akrauze.buscompany.model.Trip;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
        if (dtoRequest.getSchedule()!=null && dtoRequest.getDates()==null) {
            Trip trip = tripMapper.dtoScheduleToModel(dtoRequest);
            tripDao.insertTripSchedule(trip, busDao.getByName(dtoRequest.getBusName()).getId());
            dateTripDao.insertDates(getDatesByPeriod(trip), trip.getId());

            return new TripScheduleDtoResponse();
        } else

        return null;
    }

    private List<String> getDatesByPeriod(Trip trip) {
        List<String> period = Arrays.asList(trip.getSchedule().getPeriod().split(","));
        List<String> dates = new ArrayList<>();
        LocalDate from = LocalDate.parse(trip.getSchedule().getFromDate());
        LocalDate to = LocalDate.parse(trip.getSchedule().getToDate());
        int type = checkTypePeriod(period.get(0));
        if (type == 1) {
            switch (period.get(0)) {
                case "daily":
                    dates = from.datesUntil(to).map(LocalDate::toString).collect(Collectors.toList());
                    break;
                case "odd":
                    dates = from.datesUntil(to).filter(p -> p.getDayOfMonth() % 2 == 1)
                            .map(LocalDate::toString).collect(Collectors.toList());
                    break;
                case "even":
                    dates = from.datesUntil(to).filter(p -> p.getDayOfMonth() % 2 == 0)
                            .map(LocalDate::toString).collect(Collectors.toList());
                    break;
            }
        }else if(type == 2) {
            for (String d : period) {
                switch (d) {
                    case "Sun": dates.addAll(from.datesUntil(to).filter(p -> p.getDayOfWeek().name().equals("SUNDAY"))
                            .map(LocalDate::toString).collect(Collectors.toList()));
                        break;
                    case "Mon": dates.addAll(from.datesUntil(to).filter(p -> p.getDayOfWeek().name().equals("MONDAY"))
                            .map(LocalDate::toString).collect(Collectors.toList()));
                        break;
                    case "Tue": dates.addAll(from.datesUntil(to).filter(p -> p.getDayOfWeek().name().equals("TUESDAY"))
                            .map(LocalDate::toString).collect(Collectors.toList()));
                        break;
                    case "Wed": dates.addAll(from.datesUntil(to).filter(p -> p.getDayOfWeek().name().equals("WEDNESDAY"))
                            .map(LocalDate::toString).collect(Collectors.toList()));
                        break;
                    case "Thu": dates.addAll(from.datesUntil(to).filter(p -> p.getDayOfWeek().name().equals("THURSDAY"))
                            .map(LocalDate::toString).collect(Collectors.toList()));
                        break;
                    case "Fri": dates.addAll(from.datesUntil(to).filter(p -> p.getDayOfWeek().name().equals("FRIDAY"))
                            .map(LocalDate::toString).collect(Collectors.toList()));
                        break;
                    case "Sat": dates.addAll(from.datesUntil(to).filter(p -> p.getDayOfWeek().name().equals("SATURDAY"))
                            .map(LocalDate::toString).collect(Collectors.toList()));
                        break;
                }
            }
        }else {
            int dayNumber = 0;
            for (String d : period) {
                dayNumber = Integer.parseInt(d);
                int finalDayNumber = dayNumber;
                int finalDayNumber1 = dayNumber;
                dates.addAll(from.datesUntil(to).filter(p -> p.getDayOfMonth()== finalDayNumber1)
                        .map(LocalDate::toString).collect(Collectors.toList()));
            }
        }
        return dates;
    }

    private int checkTypePeriod(String period) {
        int result;
        if(period.equalsIgnoreCase("daily") || (period.equalsIgnoreCase("odd"))
            || period.equalsIgnoreCase("even")) {
            result = 1;
        }else if(period.equals("Sun") || period.equals("Mon") || period.equals("Tue") || period.equals("Wed")
                    || period.equals("Thu") || period.equals("Fri") || period.equals("Sat")) {
            result = 2;
        }else {
            result = 3;
        }
        return result;
    }
}

