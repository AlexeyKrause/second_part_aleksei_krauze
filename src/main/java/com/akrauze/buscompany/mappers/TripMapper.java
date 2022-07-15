package com.akrauze.buscompany.mappers;

import com.akrauze.buscompany.dtorequest.AddTripDtoRequest;
import com.akrauze.buscompany.dtoresponse.TripDatesDtoResponse;
import com.akrauze.buscompany.dtoresponse.TripScheduleDtoResponse;
import com.akrauze.buscompany.model.TripDates;
import com.akrauze.buscompany.model.TripSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TripMapper {
    TripMapper INSTANCE = Mappers.getMapper(TripMapper.class);

    TripSchedule dtoScheduleToModel(AddTripDtoRequest tripDtoRequest);

    TripDates dtoDatesToModel(AddTripDtoRequest tripDtoRequest);

    TripScheduleDtoResponse modelToScheduleDtoResponse(TripSchedule tripSchedule);

    TripDatesDtoResponse modelToDatesDtoResponse(TripDates tripDates);
}
