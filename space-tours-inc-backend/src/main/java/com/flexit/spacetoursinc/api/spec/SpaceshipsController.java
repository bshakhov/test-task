package com.flexit.spacetoursinc.api.spec;

import com.flexit.spacetoursinc.api.dto.SpaceshipVo;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/spaceships")
@Tag(name = "Spaceships")
public interface SpaceshipsController {

    @GetMapping
    @Timed(value = "spaceships.index.time", description = "time to retrieve spaceship list", percentiles = {0.5, 0.9})
    ResponseEntity<List<SpaceshipVo>> index();

    @GetMapping("{id}")
    @Timed(value = "spaceships.get.time", description = "time to retrieve details of a spaceship", percentiles = {0.5, 0.9})
    ResponseEntity<SpaceshipVo> get(@PathVariable UUID id);

}
