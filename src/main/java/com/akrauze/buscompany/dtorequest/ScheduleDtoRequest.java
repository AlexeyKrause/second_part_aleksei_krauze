package com.akrauze.buscompany.dtorequest;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@Data
@ToString
public class ScheduleDtoRequest {
    @NotNull
    String fromDate;
    @NotNull
    String toDate;
    @NotNull
    List<String> period;

    public void setPeriod(String period) {
        String[] str = period.split(",");
        if (str.length==1)
            str[0].toLowerCase();
        this.period = Arrays.asList(str);
    }
}
