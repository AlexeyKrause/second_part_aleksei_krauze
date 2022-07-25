package com.akrauze.buscompany.service.datesperiod;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScheduledSchedule implements ScheduleToDatesConverter {

    @Override
    public boolean canHandleThisPeriod(String period) {
        return period.equalsIgnoreCase("daily") || (period.equalsIgnoreCase("odd"))
            || period.equalsIgnoreCase("even");
    }

    @Override
    public List<String> convert(Stream<LocalDate> datesRange, List<String> schedule) {
        if (schedule.size() > 1) {
            throw new UnsupportedOperationException("There should be only one parameter");
        }

        switch (schedule.get(0)) {
            case "daily":
                return datesRange.map(LocalDate::toString).collect(Collectors.toList());
            case "odd":
                return datesRange.filter(p -> p.getDayOfMonth() % 2 == 1)
                    .map(LocalDate::toString).collect(Collectors.toList());
            case "even":
                return datesRange.filter(p -> p.getDayOfMonth() % 2 == 0)
                    .map(LocalDate::toString).collect(Collectors.toList());
            default:
                throw new UnsupportedOperationException("Invalid Schedule");
        }
    }
}
