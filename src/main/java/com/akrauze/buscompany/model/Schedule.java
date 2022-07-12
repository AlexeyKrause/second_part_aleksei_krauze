package com.akrauze.buscompany.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Schedule {
    Date fromDate;
    Date toDate;
    String period;
}
