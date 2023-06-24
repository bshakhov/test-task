package com.flexit.spacetoursinc.api.spec;

import com.flexit.spacetoursinc.api.dto.PropellantListItemVo;
import com.flexit.spacetoursinc.api.dto.PropellantVo;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/v1/propellants")
@Tag(name = "Propellants", description = "Provided by API from Propellant Markt Inc.")
public interface PropellantsController {

    @GetMapping
    @Timed(value = "propellants.index.time", description = "time to retrieve propellants list", percentiles = {0.5, 0.9})
    ResponseEntity<List<PropellantListItemVo>> index();

    @GetMapping("{id}")
    @Timed(value = "propellants.get.time", description = "time to retrieve details of a propellant", percentiles = {0.5, 0.9})
    ResponseEntity<PropellantVo> get(@PathVariable Integer id);

}
