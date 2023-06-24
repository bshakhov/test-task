package com.flexit.spacetoursinc.converter;

import com.flexit.spacetoursinc.common.base.AbstractConverter;
import com.flexit.spacetoursinc.dao.model.Spaceship;
import com.flexit.spacetoursinc.api.dto.SpaceshipVo;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class SpaceshipConverter extends AbstractConverter<Spaceship, SpaceshipVo> {

    public SpaceshipConverter(DozerBeanMapper mapper) {
        super(mapper, Spaceship.class, SpaceshipVo.class);
    }

}
