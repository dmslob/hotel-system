package com.dmslob.reservation.repo;

import com.dmslob.reservation.model.ReservationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {

    List<ReservationEntity> findByDate(LocalDate date);
}
