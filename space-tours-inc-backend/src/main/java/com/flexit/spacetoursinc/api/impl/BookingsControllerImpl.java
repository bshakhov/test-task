package com.flexit.spacetoursinc.api.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nonnull;

import com.flexit.spacetoursinc.api.dto.BookingVo;
import com.flexit.spacetoursinc.api.spec.BookingsController;
import com.flexit.spacetoursinc.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.flexit.spacetoursinc.common.enums.StiEntity;
import com.flexit.spacetoursinc.common.exception.StiNotFoundException;
import com.flexit.spacetoursinc.service.TravelPackageService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BookingsControllerImpl implements BookingsController {

    private final BookingService bookingService;

    private final TravelPackageService travelPackageService;

    @Nonnull
    public ResponseEntity<List<BookingVo>> index() {
        return ResponseEntity.ok(bookingService.findAll());
    }

    @Nonnull
    public ResponseEntity<BookingVo> get(UUID id) {
        return bookingService.findById(id)
            .map(ResponseEntity::ok)
            .orElseThrow(() -> new StiNotFoundException(StiEntity.BOOKING, id));
    }

    @Nonnull
    public ResponseEntity<BookingVo> post(BookingVo bookingVo) {
        bookingVo.setTravelPackage(travelPackageService.findById(bookingVo.getTravelPackage().getId())
            .orElseThrow(() -> new StiNotFoundException(StiEntity.TRAVEL_PACKAGE, bookingVo.getTravelPackage().getId())));
        return new ResponseEntity<>(bookingService.create(bookingVo), HttpStatus.OK);
    }

}
