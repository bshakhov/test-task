package com.flexit.spacetoursinc.orb;

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
@RequestMapping("/api/v1/orbs")
@Tag(name = "Orbs")
public class OrbsController {

    private final OrbService orbService;

    public OrbsController(OrbService orbService) {
        this.orbService = orbService;
    }

    @Nonnull
    @GetMapping
    @Timed(value = "orbs.index.time", description = "time to retrieve orb list", percentiles = {0.5, 0.9})
    protected ResponseEntity<List<OrbVo>> index() {
        return ResponseEntity.ok(orbService.findAll());
    }

    @Nonnull
    @GetMapping("{id}")
    @Timed(value = "orbs.get.time", description = "time to retrieve details of an orb", percentiles = {0.5, 0.9})
    protected ResponseEntity<OrbVo> get(@PathVariable UUID id) {
        return orbService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new StiNotFoundException(StiEntity.ORB, id));
    }

}
