package com.akrauze.buscompany.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public abstract class Trip {
    String busName;
    String fromStation;
    String toStation;
    String start;
    String duration;
    Double price;
}
