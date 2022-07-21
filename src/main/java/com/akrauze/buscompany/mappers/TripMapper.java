package com.akrauze.buscompany.mappers;

import com.akrauze.buscompany.dtorequest.AddTripDtoRequest;
import com.akrauze.buscompany.dtoresponse.TripDatesDtoResponse;
import com.akrauze.buscompany.dtoresponse.TripScheduleDtoResponse;
import com.akrauze.buscompany.model.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TripMapper {
    TripMapper INSTANCE = Mappers.getMapper(TripMapper.class);

    Trip dtoScheduleToModel(AddTripDtoRequest tripDtoRequest);

    TripScheduleDtoResponse modelToScheduleDtoResponse(Trip trip);

    TripDatesDtoResponse modelToDatesDtoResponse(Trip trip);
}
