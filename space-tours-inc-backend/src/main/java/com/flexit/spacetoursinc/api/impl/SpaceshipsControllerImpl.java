package com.flexit.spacetoursinc.api.impl;

import com.flexit.spacetoursinc.api.spec.SpaceshipsController;
import com.flexit.spacetoursinc.common.enums.StiEntity;
import com.flexit.spacetoursinc.common.exception.StiNotFoundException;
import com.flexit.spacetoursinc.service.SpaceshipService;
import com.flexit.spacetoursinc.api.dto.SpaceshipVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SpaceshipsControllerImpl implements SpaceshipsController {

    private final SpaceshipService spaceshipService;

    @Nonnull
    public ResponseEntity<List<SpaceshipVo>> index() {
        return ResponseEntity.ok(spaceshipService.findAll());
    }

    @Nonnull
    public ResponseEntity<SpaceshipVo> get(UUID id) {
        return spaceshipService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new StiNotFoundException(StiEntity.SPACESHIP, id));
    }

}
