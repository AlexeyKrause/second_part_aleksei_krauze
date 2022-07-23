package com.akrauze.buscompany.service.datesperiod;

import java.time.LocalDate;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DatesPeriodUtil {
    private DatesPeriodUtil() {
        throw new UnsupportedOperationException();
    }

    public static List<String> getDates(Stream<LocalDate> datesRange, BiPredicate<LocalDate, String> predicate, String day) {
        return datesRange.filter(p -> predicate.test(p, day))
            .map(LocalDate::toString).collect(Collectors.toList());
    }
}
