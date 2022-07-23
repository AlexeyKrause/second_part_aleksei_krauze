package com.akrauze.buscompany.service.datesperiod;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public interface ScheduleToDatesConverter {
    boolean canHandleThisPeriod(String period);
    List<String> convert(Stream<LocalDate> datesRange, List<String> schedule);
}
