package com.akrauze.buscompany.dtoresponse;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BusDtoResponse {
    String busName;
    int placeCount;
}
