package com.flexit.spacetoursinc.client;

import com.flexit.spacetoursinc.api.dto.PropellantListItemVo;
import com.flexit.spacetoursinc.api.dto.PropellantVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "propellantclient", configuration = PropellantClientConfig.class, url = "${propellant.baseUri}")
public interface PropellantClient {

    @GetMapping(value = "/propellants")
    List<PropellantListItemVo> getAllPropellants();

    @GetMapping(value = "/propellants/{id}")
    PropellantVo getPropellant(@PathVariable(value = "id") final Integer id);
}
