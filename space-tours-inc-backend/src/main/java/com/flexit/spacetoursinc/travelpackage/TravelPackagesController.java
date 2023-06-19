package com.flexit.spacetoursinc.travelpackage;

import com.flexit.spacetoursinc.common.annotations.GroupedApiResponses;
import com.flexit.spacetoursinc.common.enums.StiEntity;
import com.flexit.spacetoursinc.common.exception.StiNotFoundException;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/travel_packages")
@Tag(name = "Travel Packages", description = "A travel package is a set of flights and hotel room stays")
public class TravelPackagesController {

    private final TravelPackageService travelPackageService;

    public TravelPackagesController(TravelPackageService travelPackageService) {
        this.travelPackageService = travelPackageService;
    }

    @Nonnull
    @GetMapping
    @Operation(summary = "Get all travel packages", description = "A list of all travel packages in the database")
    @GroupedApiResponses
    @Timed(value = "travel_packages.index.time", description = "time to retrieve travel packages list", percentiles = {0.5, 0.9})
    protected ResponseEntity<List<TravelPackageVo>> index() {
        return ResponseEntity.ok(travelPackageService.findAll());
    }

    @Nonnull
    @GetMapping("{id}")
    @Operation(summary = "Get a single travel package by id")
    @GroupedApiResponses
    @Timed(value = "travel_packages.get.time", description = "time to retrieve details of a travel package", percentiles = {0.5, 0.9})
    protected ResponseEntity<TravelPackageVo> get(@PathVariable UUID id) {
        return travelPackageService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new StiNotFoundException(StiEntity.TRAVEL_PACKAGE, id));
    }

    @Nonnull
    @GetMapping("availability/{date}")
    @Operation(summary = "Get availabilities of all travel packages at a given date", description = "A list of all travel package availabilities at a given date")
    @GroupedApiResponses
    @Timed(value = "travel_packages.get_availability_by_date.time", description = "time to retrieve availabilities of travel packages", percentiles = {0.5, 0.9})
    protected ResponseEntity<List<TravelPackageAvailabilityVo>> getAvailabilitiesByDate(@PathVariable Date date) {
        return ResponseEntity.ok(travelPackageService.getAvailabilitiesByDate(date.toLocalDate()));
    }

}
