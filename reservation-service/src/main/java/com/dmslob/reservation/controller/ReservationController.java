package com.dmslob.reservation.controller;

import com.dmslob.reservation.dto.Reservation;
import com.dmslob.reservation.service.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@RestController
@RequestMapping(value = "/reservations")
@Api(value = "reservations", description = "Data service operations on reservations", tags = ("reservations"))
public class ReservationController {

    private static final Logger LOGGER = LogManager.getLogger(ReservationController.class);

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get All Reservations", notes = "Gets all reservations in the system", nickname = "getReservations")
    public List<Reservation> getAll(@RequestParam(name = "date", required = false) String date) {

        return this.reservationService.getAll(date);
    }
}
