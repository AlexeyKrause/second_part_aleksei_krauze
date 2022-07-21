package com.akrauze.buscompany.dtorequest;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@ToString
public class AddTripDtoRequest {
    @NotNull
    String busName;
    @NotNull
    String fromStation;
    @NotNull
    String toStation;
    @NotNull
    String start;
    @NotNull
    String duration;
    @NotNull
    Double price;
    ScheduleDtoRequest schedule;
    List<LocalDate> dates;
}
