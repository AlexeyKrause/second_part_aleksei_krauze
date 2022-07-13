package com.akrauze.buscompany.dtoresponse;

import com.akrauze.buscompany.model.Bus;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public abstract class TripDtoResponse {
    int tripId;
    String fromStation;
    String toStation;
    String start;
    String duration;
    Double price;
    Bus bus;
    Boolean approved;
}
