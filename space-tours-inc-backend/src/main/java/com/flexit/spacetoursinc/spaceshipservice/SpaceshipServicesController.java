package com.flexit.spacetoursinc.spaceshipservice;

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
@RequestMapping("/api/v1/spaceship_services")
@Tag(name = "Spaceship Services")
public class SpaceshipServicesController {

    private final SpaceshipServiceService spaceshipServiceService;

    public SpaceshipServicesController(SpaceshipServiceService spaceshipServiceService) {
        this.spaceshipServiceService = spaceshipServiceService;
    }

    @Nonnull
    @GetMapping
    @Timed(value = "spaceship_services.index.time", description = "time to retrieve spaceship services list", percentiles = {0.5, 0.9})
    protected ResponseEntity<List<SpaceshipServiceVo>> index() {
        return ResponseEntity.ok(spaceshipServiceService.findAll());
    }

    @Nonnull
    @GetMapping("{id}")
    @Timed(value = "spaceship_services.get.time", description = "time to retrieve details of a spaceship service", percentiles = {0.5, 0.9})
    protected ResponseEntity<SpaceshipServiceVo> get(@PathVariable UUID id) {
        return spaceshipServiceService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new StiNotFoundException(StiEntity.SPACESHIP_SERVICE, id));
    }

}
