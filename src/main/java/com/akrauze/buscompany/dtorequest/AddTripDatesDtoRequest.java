package com.akrauze.buscompany.dtorequest;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@ToString
public class AddTripDatesDtoRequest extends AddTripDtoRequest{
    List<LocalDate> dates;
}
