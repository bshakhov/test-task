package com.flexit.spacetoursinc.spaceshipservice;

import com.flexit.spacetoursinc.common.base.AbstractConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class SpaceshipServiceConverter extends AbstractConverter<SpaceshipService, SpaceshipServiceVo> {

    public SpaceshipServiceConverter(DozerBeanMapper mapper) {
        super(mapper, SpaceshipService.class, SpaceshipServiceVo.class);
    }

}
