package com.akrauze.buscompany.dtorequest;

import com.akrauze.buscompany.model.Schedule;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
public class AddTripScheduleDtoRequest extends AddTripDtoRequest{
    @NotNull
    Schedule schedule;
}
