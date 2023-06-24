package com.flexit.spacetoursinc.dao.repository;

import com.flexit.spacetoursinc.dao.model.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HotelRoomRepository extends JpaRepository<HotelRoom, UUID> {
}
