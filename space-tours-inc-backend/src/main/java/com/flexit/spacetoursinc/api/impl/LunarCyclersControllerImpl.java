package com.flexit.spacetoursinc.api.impl;

import com.flexit.spacetoursinc.api.dto.LunarCyclerVo;
import com.flexit.spacetoursinc.common.enums.StiEntity;
import com.flexit.spacetoursinc.common.exception.StiNotFoundException;
import com.flexit.spacetoursinc.service.LunarCyclerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class LunarCyclersControllerImpl {

    private final LunarCyclerService lunarCyclerService;

    @Nonnull
    protected ResponseEntity<List<LunarCyclerVo>> index() {
        return ResponseEntity.ok(lunarCyclerService.findAll());
    }

    @Nonnull
    protected ResponseEntity<LunarCyclerVo> get(UUID id) {
        return lunarCyclerService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new StiNotFoundException(StiEntity.LUNAR_CYCLER, id));
    }

}
