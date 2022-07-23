package com.akrauze.buscompany.service.datesperiod;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.akrauze.buscompany.service.datesperiod.DatesPeriodUtil.getDates;

@Component
public class DayOfMonthSchedule implements ScheduleToDatesConverter {

    private static final BiPredicate<LocalDate, String> predicate = (localDate, day) -> localDate.getDayOfMonth() == Integer.parseInt(day);

    @Override
    public boolean canHandleThisPeriod(String period) {
        try {
            Integer.parseInt(period);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<String> convert(Stream<LocalDate> datesRange, List<String> schedule) {
        var dates = new ArrayList<String>();
        for (String d : schedule) {
            dates.addAll(getDates(datesRange, predicate, d));
        }
        return dates;
    }



}
