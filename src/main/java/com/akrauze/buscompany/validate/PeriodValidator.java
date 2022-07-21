package com.akrauze.buscompany.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PeriodValidator implements ConstraintValidator<PeriodValid, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;
        List<String> periods = Arrays.asList(s.split(","));
        List<String> periodsRes = periods.stream()
                .filter(p -> p.equalsIgnoreCase("daily"))
                .filter(p -> p.equalsIgnoreCase("even"))
                .filter(p -> p.equalsIgnoreCase("odd")).collect(Collectors.toList());
        if (periodsRes.size() != 0)
            result = true;
        if (periodsRes.size()==0) {
            periodsRes = periods.stream()
                    .filter(p -> p.equals("Sun"))
                    .filter(p -> p.equals("Mon"))
                    .filter(p -> p.equals("Tue"))
                    .filter(p -> p.equals("Wed"))
                    .filter(p -> p.equals("Thu"))
                    .filter(p -> p.equals("Fri"))
                    .filter(p -> p.equals("Sat")).collect(Collectors.toList());
            if(periodsRes.size()!=0)
                result = true;
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
