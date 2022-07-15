package com.akrauze.buscompany.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TripSchedule extends Trip{
    Schedule schedule;
}
