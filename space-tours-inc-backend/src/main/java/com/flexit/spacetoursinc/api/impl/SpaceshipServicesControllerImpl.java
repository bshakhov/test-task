package com.flexit.spacetoursinc.api.impl;

import com.flexit.spacetoursinc.api.spec.SpaceshipServicesController;
import com.flexit.spacetoursinc.common.enums.StiEntity;
import com.flexit.spacetoursinc.common.exception.StiNotFoundException;
import com.flexit.spacetoursinc.service.SpaceshipServiceService;
import com.flexit.spacetoursinc.api.dto.SpaceshipServiceVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SpaceshipServicesControllerImpl implements SpaceshipServicesController {

    private final SpaceshipServiceService spaceshipServiceService;

    @Nonnull
    public ResponseEntity<List<SpaceshipServiceVo>> index() {
        return ResponseEntity.ok(spaceshipServiceService.findAll());
    }

    @Nonnull
    public ResponseEntity<SpaceshipServiceVo> get(UUID id) {
        return spaceshipServiceService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new StiNotFoundException(StiEntity.SPACESHIP_SERVICE, id));
    }

}
