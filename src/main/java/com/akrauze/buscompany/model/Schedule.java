package com.akrauze.buscompany.model;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class Schedule {
    String fromDate;
    String toDate;
    String period;
}
