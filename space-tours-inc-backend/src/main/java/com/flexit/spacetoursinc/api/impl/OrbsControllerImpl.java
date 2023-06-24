package com.flexit.spacetoursinc.api.impl;

import com.flexit.spacetoursinc.api.spec.OrbsController;
import com.flexit.spacetoursinc.common.enums.StiEntity;
import com.flexit.spacetoursinc.common.exception.StiNotFoundException;
import com.flexit.spacetoursinc.service.OrbService;
import com.flexit.spacetoursinc.api.dto.OrbVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class OrbsControllerImpl implements OrbsController {

    private final OrbService orbService;

    @Nonnull
    public ResponseEntity<List<OrbVo>> index() {
        return ResponseEntity.ok(orbService.findAll());
    }

    @Nonnull
    public ResponseEntity<OrbVo> get(UUID id) {
        return orbService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new StiNotFoundException(StiEntity.ORB, id));
    }

}
