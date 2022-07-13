package com.akrauze.buscompany.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Schedule {
    String fromDate;
    String toDate;
    String period;
}
