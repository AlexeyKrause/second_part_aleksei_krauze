package com.akrauze.buscompany.mappers;

import com.akrauze.buscompany.dtoresponse.BusDtoResponse;
import com.akrauze.buscompany.model.Bus;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BusMapper {

    BusMapper INSTANCE = Mappers.getMapper(BusMapper.class);

    BusDtoResponse modelToDto(Bus bus);
}
