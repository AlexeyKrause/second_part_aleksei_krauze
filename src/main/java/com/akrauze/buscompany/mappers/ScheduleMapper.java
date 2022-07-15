package com.akrauze.buscompany.mappers;

import com.akrauze.buscompany.dtorequest.ScheduleDtoRequest;
import com.akrauze.buscompany.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScheduleMapper {

    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

    Schedule dtoToModel(ScheduleDtoRequest scheduleDtoRequest);
}
