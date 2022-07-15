package com.akrauze.buscompany.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class DatesTrip {
    int id;
    Date date;
    int tripId;
}
