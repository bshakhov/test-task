package com.flexit.spacetoursinc.converter;

import com.flexit.spacetoursinc.common.base.AbstractConverter;
import com.flexit.spacetoursinc.dao.model.SpaceshipService;
import com.flexit.spacetoursinc.api.dto.SpaceshipServiceVo;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class SpaceshipServiceConverter extends AbstractConverter<SpaceshipService, SpaceshipServiceVo> {

    public SpaceshipServiceConverter(DozerBeanMapper mapper) {
        super(mapper, SpaceshipService.class, SpaceshipServiceVo.class);
    }

}
