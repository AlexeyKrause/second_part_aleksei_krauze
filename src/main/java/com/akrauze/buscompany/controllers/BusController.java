package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.dtoresponse.BusDtoResponse;
import com.akrauze.buscompany.exception.ServerException;
import com.akrauze.buscompany.service.BusService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {
    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<BusDtoResponse> getAllBus(HttpServletRequest httpServletRequest) throws ServerException {
        return busService.getAll(httpServletRequest);
    }
}
