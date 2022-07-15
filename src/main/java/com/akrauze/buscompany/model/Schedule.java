package com.akrauze.buscompany.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Schedule {
    String fromDate;
    String toDate;
    List<String> period;
}
