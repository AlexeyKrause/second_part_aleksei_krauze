package com.akrauze.buscompany.dtoresponse;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;


@Data
@ToString
public class TripDatesDtoResponse extends TripDtoResponse {
     List<LocalDate> dates;
}
