package com.flexit.spacetoursinc.spaceship;

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
@RequestMapping("/api/v1/spaceships")
@Tag(name = "Spaceships")
public class SpaceshipsController {

    private final SpaceshipService spaceshipService;

    public SpaceshipsController(SpaceshipService spaceshipService) {
        this.spaceshipService = spaceshipService;
    }

    @Nonnull
    @GetMapping
    @Timed(value = "spaceships.index.time", description = "time to retrieve spaceship list", percentiles = {0.5, 0.9})
    protected ResponseEntity<List<SpaceshipVo>> index() {
        return ResponseEntity.ok(spaceshipService.findAll());
    }

    @Nonnull
    @GetMapping("{id}")
    @Timed(value = "spaceships.get.time", description = "time to retrieve details of a spaceship", percentiles = {0.5, 0.9})
    protected ResponseEntity<SpaceshipVo> get(@PathVariable UUID id) {
        return spaceshipService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new StiNotFoundException(StiEntity.SPACESHIP, id));
    }

}
