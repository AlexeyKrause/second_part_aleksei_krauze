package com.akrauze.buscompany.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Bus {
    int id;
    String busName;
    int placeCount;
}
