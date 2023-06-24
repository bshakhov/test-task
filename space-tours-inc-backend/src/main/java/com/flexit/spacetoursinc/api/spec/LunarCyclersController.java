package com.flexit.spacetoursinc.api.spec;

import com.flexit.spacetoursinc.api.dto.LunarCyclerVo;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/lunar_cycler")
@Tag(name = "Lunar Cyclers")
public interface LunarCyclersController {

    @GetMapping
    @Timed(value = "lunar_cycler.index.time", description = "time to retrieve lunar cycler list", percentiles = {0.5, 0.9})
    ResponseEntity<List<LunarCyclerVo>> index();

    @GetMapping("{id}")
    @Timed(value = "lunar_cycler.get.time", description = "time to retrieve details of a lunar cycler", percentiles = {0.5, 0.9})
    ResponseEntity<LunarCyclerVo> get(@PathVariable UUID id);

}
