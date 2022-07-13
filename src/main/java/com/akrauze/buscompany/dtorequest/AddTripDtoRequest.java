package com.akrauze.buscompany.dtorequest;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;


@Data
@ToString
public abstract class AddTripDtoRequest {
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
}

