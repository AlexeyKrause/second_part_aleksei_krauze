package com.akrauze.buscompany.service.datesperiod;

import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.akrauze.buscompany.service.datesperiod.DatesPeriodUtil.getDates;

@Component
public class DailySchedule implements ScheduleToDatesConverter {

    private static final BiPredicate<LocalDate, String> predicate = (localDate, dayOfWeek) -> localDate.getDayOfWeek().name().equals(dayOfWeek);

    public boolean canHandleThisPeriod(String period) {
        return period.equals("Sun")
            || period.equals("Mon")
            || period.equals("Tue")
            || period.equals("Wed")
            || period.equals("Thu")
            || period.equals("Fri")
            || period.equals("Sat");
    }

    @Override
    public List<String> convert(Stream<LocalDate> datesRange, List<String> schedule) {
        var dates = new ArrayList<String>();

        for (String dayName : schedule) {

            var dayOfWeek = Arrays.stream(DayOfWeek.values())
                .filter(day -> day.name().startsWith(dayName.toUpperCase()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

            dates.addAll(getDates(datesRange, predicate, dayOfWeek.name()));
        }
        return dates;
    }
}
