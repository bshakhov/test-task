package com.flexit.spacetoursinc.api.impl;

import com.flexit.spacetoursinc.api.spec.HotelRoomsController;
import com.flexit.spacetoursinc.common.enums.StiEntity;
import com.flexit.spacetoursinc.common.exception.StiNotFoundException;
import com.flexit.spacetoursinc.service.HotelRoomService;
import com.flexit.spacetoursinc.api.dto.HotelRoomVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class HotelRoomsControllerImpl implements HotelRoomsController {

    private final HotelRoomService hotelRoomService;

    @Nonnull
    public ResponseEntity<List<HotelRoomVo>> index() {
        return ResponseEntity.ok(hotelRoomService.findAll());
    }

    @Nonnull
    public ResponseEntity<HotelRoomVo> get(UUID id) {
        return hotelRoomService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new StiNotFoundException(StiEntity.HOTEL_ROOM, id));
    }

}
