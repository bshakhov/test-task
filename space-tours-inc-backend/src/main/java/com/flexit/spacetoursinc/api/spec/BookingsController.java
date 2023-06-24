package com.flexit.spacetoursinc.api.spec;

import com.flexit.spacetoursinc.api.dto.BookingVo;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/bookings")
@Tag(name = "Bookings")
public interface BookingsController {

    @GetMapping
    @Timed(value = "bookings.index.time", description = "time to retrieve bookings list", percentiles = {0.5, 0.9})
    ResponseEntity<List<BookingVo>> index();

    @GetMapping("{id}")
    @Timed(value = "bookings.get.time", description = "time to retrieve details of a booking", percentiles = {0.5, 0.9})
    ResponseEntity<BookingVo> get(@PathVariable UUID id);

    @PostMapping
    @Timed(value = "bookings.post.time", description = "time to create a new booking", percentiles = {0.5, 0.9})
    ResponseEntity<BookingVo> post(@RequestBody BookingVo bookingVo);

}
