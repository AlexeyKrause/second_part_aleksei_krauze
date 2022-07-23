package com.akrauze.buscompany.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PeriodValidator implements ConstraintValidator<PeriodValid, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.equals(""))
            return false;
        boolean result = false;
        List<String> periods = Arrays.asList(s.split(","));
        List<String> periodsRes = periods.stream()
                .filter(p -> p.equalsIgnoreCase("daily")
                        || p.equalsIgnoreCase("even")
                        || p.equalsIgnoreCase("odd"))
                .collect(Collectors.toList());
        if (periodsRes.size() == 1) {
            return true;
        }
        else if(periodsRes.size() > 1) {
            return false;
        }
        if (periodsRes.size()==0) {
            periodsRes = periods.stream()
                    .filter(p -> p.equals("Sun")
                            || p.equals("Mon")
                            || p.equals("Tue")
                            || p.equals("Wed")
                            || p.equals("Thu")
                            || p.equals("Fri")
                            || p.equals("Sat"))
                    .collect(Collectors.toList());
            if(periodsRes.size()!=0 && periodsRes.size()==periods.size())
                result = true;
            else if (periodsRes.size()!=0 && periodsRes.size()!=periods.size())
                return false;
        }
        if (periodsRes.size()==0) {
            for (String d : periods) {
                try {
                    Integer.parseInt(d);
                    result = true;
                }catch (NumberFormatException exc) {
                    result = false;
                }
            }
        }
        return result;
    }
}
