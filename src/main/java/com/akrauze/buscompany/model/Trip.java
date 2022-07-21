package com.akrauze.buscompany.model;

import com.akrauze.buscompany.dtorequest.ScheduleDtoRequest;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class Trip {
    int id;
    String busName;
    String fromStation;
    String toStation;
    String start;
    String duration;
    Double price;
    ScheduleDtoRequest schedule;
    List<Date> dates;
}
