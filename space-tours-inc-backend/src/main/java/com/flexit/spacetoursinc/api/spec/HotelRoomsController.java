package com.flexit.spacetoursinc.api.spec;

import com.flexit.spacetoursinc.api.dto.HotelRoomVo;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/hotel_rooms")
@Tag(name = "Hotel Rooms")
public interface HotelRoomsController {

    @GetMapping
    @Timed(value = "hotel_rooms.index.time", description = "time to retrieve hotel room list", percentiles = {0.5, 0.9})
    ResponseEntity<List<HotelRoomVo>> index();

    @GetMapping("{id}")
    @Timed(value = "hotel_rooms.get.time", description = "time to retrieve details of a hotel room", percentiles = {0.5, 0.9})
    ResponseEntity<HotelRoomVo> get(@PathVariable UUID id);

}
