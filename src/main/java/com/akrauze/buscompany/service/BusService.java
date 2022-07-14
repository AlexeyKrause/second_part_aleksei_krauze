package com.akrauze.buscompany.service;

import com.akrauze.buscompany.daoimpl.BusDaoImpl;
import com.akrauze.buscompany.dtoresponse.BusDtoResponse;
import com.akrauze.buscompany.exception.ErrorCode;
import com.akrauze.buscompany.exception.ServerException;
import com.akrauze.buscompany.mappers.BusMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusService {
    private final BusDaoImpl busDao;
    private final BusMapper busMapper;
    private final ValidateService validateService;

    public BusService(BusDaoImpl busDao, BusMapper busMapper, ValidateService validateService) {
        this.busDao = busDao;
        this.busMapper = busMapper;
        this.validateService = validateService;
    }

    public List<BusDtoResponse> getAll(HttpServletRequest httpServletRequest) throws ServerException {
        validateService.checkUserRole(httpServletRequest, "ADMIN");
        return busDao.getAll().stream().map(busMapper::modelToDto).collect(Collectors.toList());
    }
}
