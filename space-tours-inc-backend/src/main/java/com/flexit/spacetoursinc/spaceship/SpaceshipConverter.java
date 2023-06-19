package com.flexit.spacetoursinc.spaceship;

import com.flexit.spacetoursinc.common.base.AbstractConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class SpaceshipConverter extends AbstractConverter<Spaceship, SpaceshipVo> {

    public SpaceshipConverter(DozerBeanMapper mapper) {
        super(mapper, Spaceship.class, SpaceshipVo.class);
    }

}
