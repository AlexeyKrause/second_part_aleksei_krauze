package com.akrauze.buscompany.service;

import com.akrauze.buscompany.daoimpl.BusDaoImpl;
import com.akrauze.buscompany.dtoresponse.BusDtoResponse;
import com.akrauze.buscompany.mappers.BusMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusService {
    private final BusDaoImpl busDao;
    private final BusMapper busMapper;

    public BusService(BusDaoImpl busDao, BusMapper busMapper) {
        this.busDao = busDao;
        this.busMapper = busMapper;
    }

    public List<BusDtoResponse> getAll() {
        return busDao.getAll().stream()
                .map(busMapper::modelToDto).collect(Collectors.toList());
    }
}
