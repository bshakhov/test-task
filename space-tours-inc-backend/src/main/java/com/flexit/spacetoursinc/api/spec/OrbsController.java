package com.flexit.spacetoursinc.api.spec;

import com.flexit.spacetoursinc.api.dto.OrbVo;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/orbs")
@Tag(name = "Orbs")
public interface OrbsController {

    @GetMapping
    @Timed(value = "orbs.index.time", description = "time to retrieve orb list", percentiles = {0.5, 0.9})
    ResponseEntity<List<OrbVo>> index();

    @GetMapping("{id}")
    @Timed(value = "orbs.get.time", description = "time to retrieve details of an orb", percentiles = {0.5, 0.9})
    ResponseEntity<OrbVo> get(@PathVariable UUID id);

}
