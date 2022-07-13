package com.akrauze.buscompany.dtoresponse;

import com.akrauze.buscompany.model.Schedule;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@ToString
public class TripScheduleDtoResponse extends TripDtoResponse{
    Schedule schedule;
    List<LocalDate> dates;
}
