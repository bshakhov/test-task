package com.flexit.spacetoursinc.lunarcycler;

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
@RequestMapping("/api/v1/lunar_cycler")
@Tag(name = "Lunar Cyclers")
public class LunarCyclersController {

    private final LunarCyclerService lunarCyclerService;

    public LunarCyclersController(LunarCyclerService lunarCyclerService) {
        this.lunarCyclerService = lunarCyclerService;
    }

    @Nonnull
    @GetMapping
    @Timed(value = "lunar_cycler.index.time", description = "time to retrieve lunar cycler list", percentiles = {0.5, 0.9})
    protected ResponseEntity<List<LunarCyclerVo>> index() {
        return ResponseEntity.ok(lunarCyclerService.findAll());
    }

    @Nonnull
    @GetMapping("{id}")
    @Timed(value = "lunar_cycler.get.time", description = "time to retrieve details of a lunar cycler", percentiles = {0.5, 0.9})
    protected ResponseEntity<LunarCyclerVo> get(@PathVariable UUID id) {
        return lunarCyclerService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new StiNotFoundException(StiEntity.LUNAR_CYCLER, id));
    }

}
