package com.flexit.spacetoursinc.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

    @Query(
        "SELECT b FROM Booking b WHERE b.departureDate BETWEEN ?1 AND ?2"
    )
    List<Booking> findByDepartureDateBetween(Date from, Date to);

}
