package com.dmslob.reservation.service;

import com.dmslob.reservation.dto.Reservation;
import com.dmslob.reservation.model.ReservationEntity;
import com.dmslob.reservation.repo.ReservationRepository;
import com.dmslob.reservation.utils.DateTimeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationService {

    private final DateTimeUtils dateTimeUtils;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(DateTimeUtils dateTimeUtils) {
        this.dateTimeUtils = dateTimeUtils;
    }

    public List<Reservation> getAll(String date) {
        List<ReservationEntity> reservations;
        if (StringUtils.isNotBlank(date)) {
            reservations = this.reservationRepository.findByDate(this.dateTimeUtils.createDateFromDateString(date));
        } else {
            reservations = (List<ReservationEntity>) this.reservationRepository.findAll();
        }
        return getReservations(reservations);
    }

    public ReservationEntity translateReservationToEntity(Reservation reservation) {
        ReservationEntity entity = new ReservationEntity();
        entity.setGuestId(reservation.getGuestId());
        entity.setId(reservation.getId());
        entity.setRoomId(reservation.getRoomId());
        entity.setDate(this.dateTimeUtils.createDateFromDateString(reservation.getReservationDate()));
        return entity;
    }

    private List<Reservation> getReservations(List<ReservationEntity> entities) {
        List<Reservation> reservations = new ArrayList<>(entities.size());
        entities.forEach(entity -> reservations.add(translateEntityToReservation(entity)));
        return reservations;
    }

    private Reservation translateEntityToReservation(ReservationEntity reservationEntity) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationEntity.getId());
        reservation.setRoomId(reservationEntity.getRoomId());
        reservation.setGuestId(reservationEntity.getGuestId());
        reservation.setReservationDate(this.dateTimeUtils.createDateStringFromDate(reservationEntity.getDate()));
        return reservation;
    }
}
