package com.flexit.spacetoursinc.api.spec;

import com.flexit.spacetoursinc.api.dto.TravelPackageAvailabilityVo;
import com.flexit.spacetoursinc.api.dto.TravelPackageVo;
import com.flexit.spacetoursinc.common.annotations.GroupedApiResponses;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Nonnull;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/travel_packages")
@Tag(name = "Travel Packages", description = "A travel package is a set of flights and hotel room stays")
public interface TravelPackagesController {

    @GetMapping
    @Operation(summary = "Get all travel packages", description = "A list of all travel packages in the database")
    @GroupedApiResponses
    @Timed(value = "travel_packages.index.time", description = "time to retrieve travel packages list", percentiles = {0.5, 0.9})
    ResponseEntity<List<TravelPackageVo>> index();

    @GetMapping("{id}")
    @Operation(summary = "Get a single travel package by id")
    @GroupedApiResponses
    @Timed(value = "travel_packages.get.time", description = "time to retrieve details of a travel package", percentiles = {0.5, 0.9})
    ResponseEntity<TravelPackageVo> get(@PathVariable UUID id);

    @GetMapping("availability/{date}")
    @Operation(summary = "Get availabilities of all travel packages at a given date", description = "A list of all travel package availabilities at a given date")
    @GroupedApiResponses
    @Timed(value = "travel_packages.get_availability_by_date.time", description = "time to retrieve availabilities of travel packages", percentiles = {0.5, 0.9})
    ResponseEntity<List<TravelPackageAvailabilityVo>> getAvailabilitiesByDate(@PathVariable Date date);

}
