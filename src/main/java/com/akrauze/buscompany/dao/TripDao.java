package com.akrauze.buscompany.dao;


import com.akrauze.buscompany.model.TripDates;
import com.akrauze.buscompany.model.TripSchedule;

public interface TripDao {
    Integer insertTripSchedule(TripSchedule trip, int busId);

    Integer insertTripDates(TripDates trip, int busId);
}
