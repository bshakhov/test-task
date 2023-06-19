package com.flexit.spacetoursinc.hotelroom;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HotelRoomRepository extends JpaRepository<HotelRoom, UUID> {
}
