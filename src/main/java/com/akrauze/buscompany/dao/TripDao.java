package com.akrauze.buscompany.dao;


import com.akrauze.buscompany.model.Trip;


public interface TripDao {
    Integer insertTripSchedule(Trip trip, int busId);

    Integer insertTripDates(Trip trip, int busId);
}
