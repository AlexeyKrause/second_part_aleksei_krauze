package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.dtoresponse.BusDtoResponse;
import com.akrauze.buscompany.exception.ErrorCode;
import com.akrauze.buscompany.exception.ServerException;
import com.akrauze.buscompany.model.Session;
import com.akrauze.buscompany.service.BusService;
import com.akrauze.buscompany.service.SessionService;
import com.akrauze.buscompany.service.UserService;
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
    private final SessionService sessionService;
    private final UserService userService;

    public BusController(BusService busService, SessionService sessionService, UserService userService) {
        this.busService = busService;
        this.sessionService = sessionService;
        this.userService = userService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<BusDtoResponse> getAllBus(HttpServletRequest httpServletRequest) throws ServerException {
        Session session = sessionService.getJavaSessionId(httpServletRequest);
        if (userService.getUserRoleByJavaSessionId(session.getJavaSessionId()).equals("ADMIN"))
            return busService.getAll();
        else
            throw new ServerException(ErrorCode.YOU_DONT_HAVE_PERMISSIONS, "userRole");
    }
}
