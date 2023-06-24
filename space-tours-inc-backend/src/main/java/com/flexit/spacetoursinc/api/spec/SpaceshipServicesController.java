package com.flexit.spacetoursinc.api.spec;

import com.flexit.spacetoursinc.api.dto.SpaceshipServiceVo;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/spaceship_services")
@Tag(name = "Spaceship Services")
public interface SpaceshipServicesController {

    @GetMapping
    @Timed(value = "spaceship_services.index.time", description = "time to retrieve spaceship services list", percentiles = {0.5, 0.9})
    ResponseEntity<List<SpaceshipServiceVo>> index();

    @GetMapping("{id}")
    @Timed(value = "spaceship_services.get.time", description = "time to retrieve details of a spaceship service", percentiles = {0.5, 0.9})
    ResponseEntity<SpaceshipServiceVo> get(@PathVariable UUID id);

}
