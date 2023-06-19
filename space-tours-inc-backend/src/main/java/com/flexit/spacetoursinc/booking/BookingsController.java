package com.flexit.spacetoursinc.booking;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nonnull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexit.spacetoursinc.common.enums.StiEntity;
import com.flexit.spacetoursinc.common.exception.StiNotFoundException;
import com.flexit.spacetoursinc.travelpackage.TravelPackageService;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/bookings")
@Tag(name = "Bookings")
@RequiredArgsConstructor
public class BookingsController {

    private final BookingService bookingService;

    private final TravelPackageService travelPackageService;

    @Nonnull
    @GetMapping
    @Timed(value = "bookings.index.time", description = "time to retrieve bookings list", percentiles = {0.5, 0.9})
    protected ResponseEntity<List<BookingVo>> index() {
        return ResponseEntity.ok(bookingService.findAll());
    }

    @Nonnull
    @GetMapping("{id}")
    @Timed(value = "bookings.get.time", description = "time to retrieve details of a booking", percentiles = {0.5, 0.9})
    protected ResponseEntity<BookingVo> get(@PathVariable UUID id) {
        return bookingService.findById(id)
            .map(ResponseEntity::ok)
            .orElseThrow(() -> new StiNotFoundException(StiEntity.BOOKING, id));
    }

    @Nonnull
    @PostMapping
    @Timed(value = "bookings.post.time", description = "time to create a new booking", percentiles = {0.5, 0.9})
    protected ResponseEntity<BookingVo> post(@RequestBody BookingVo bookingVo) {
        bookingVo.setTravelPackage(travelPackageService.findById(bookingVo.getTravelPackage().getId())
            .orElseThrow(() -> new StiNotFoundException(StiEntity.TRAVEL_PACKAGE, bookingVo.getTravelPackage().getId())));
        return new ResponseEntity<>(bookingService.create(bookingVo), HttpStatus.OK);
    }

}
