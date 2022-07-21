package com.akrauze.buscompany.dtorequest;

import com.akrauze.buscompany.validate.PeriodValid;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;


@Data
@ToString
public class ScheduleDtoRequest {
    @NotNull
    String fromDate;
    @NotNull
    String toDate;
    @PeriodValid
    @NotNull
    String period;
}
