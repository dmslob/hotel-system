package com.dmslob.guest.repo;

import com.dmslob.guest.model.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
    Guest findByEmailAddress(String emailAddress);
}
