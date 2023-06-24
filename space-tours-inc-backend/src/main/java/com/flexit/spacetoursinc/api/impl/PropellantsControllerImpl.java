package com.flexit.spacetoursinc.api.impl;

import com.flexit.spacetoursinc.api.dto.PropellantListItemVo;
import com.flexit.spacetoursinc.api.dto.PropellantVo;
import com.flexit.spacetoursinc.api.spec.PropellantsController;
import com.flexit.spacetoursinc.service.PropellantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PropellantsControllerImpl implements PropellantsController {

    private final PropellantService propellantService;

    @Nonnull
    public ResponseEntity<List<PropellantListItemVo>> index() {
        return ResponseEntity.ok(propellantService.findAll());
    }

    @Nonnull
    public ResponseEntity<PropellantVo> get(Integer id) {
        return ResponseEntity.ok(propellantService.findById(id));
    }

}
