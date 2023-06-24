package com.flexit.spacetoursinc.api.impl;

import com.flexit.spacetoursinc.api.dto.TravelPackageAvailabilityVo;
import com.flexit.spacetoursinc.api.dto.TravelPackageVo;
import com.flexit.spacetoursinc.api.spec.TravelPackagesController;
import com.flexit.spacetoursinc.common.enums.StiEntity;
import com.flexit.spacetoursinc.common.exception.StiNotFoundException;
import com.flexit.spacetoursinc.service.TravelPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TravelPackagesControllerImpl implements TravelPackagesController {

    private final TravelPackageService travelPackageService;

    @Nonnull
    public ResponseEntity<List<TravelPackageVo>> index() {
        return ResponseEntity.ok(travelPackageService.findAll());
    }

    @Nonnull
    public ResponseEntity<TravelPackageVo> get(@PathVariable UUID id) {
        return travelPackageService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new StiNotFoundException(StiEntity.TRAVEL_PACKAGE, id));
    }

    @Nonnull
    public ResponseEntity<List<TravelPackageAvailabilityVo>> getAvailabilitiesByDate(@PathVariable Date date) {
        return ResponseEntity.ok(travelPackageService.getAvailabilitiesByDate(date.toLocalDate()));
    }

}
