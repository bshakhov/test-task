package com.flexit.spacetoursinc.hotelroom;

import com.flexit.spacetoursinc.common.enums.StiEntity;
import com.flexit.spacetoursinc.common.exception.StiNotFoundException;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/hotel_rooms")
@Tag(name = "Hotel Rooms")
public class HotelRoomsController {

    private final HotelRoomService hotelRoomService;

    public HotelRoomsController(HotelRoomService hotelRoomService) {
        this.hotelRoomService = hotelRoomService;
    }

    @Nonnull
    @GetMapping
    @Timed(value = "hotel_rooms.index.time", description = "time to retrieve hotel room list", percentiles = {0.5, 0.9})
    protected ResponseEntity<List<HotelRoomVo>> index() {
        return ResponseEntity.ok(hotelRoomService.findAll());
    }

    @Nonnull
    @GetMapping("{id}")
    @Timed(value = "hotel_rooms.get.time", description = "time to retrieve details of a hotel room", percentiles = {0.5, 0.9})
    protected ResponseEntity<HotelRoomVo> get(@PathVariable UUID id) {
        return hotelRoomService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new StiNotFoundException(StiEntity.HOTEL_ROOM, id));
    }

}
