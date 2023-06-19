package com.flexit.spacetoursinc.orb;

import com.flexit.spacetoursinc.common.base.AbstractConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class OrbConverter extends AbstractConverter<Orb, OrbVo> {

    public OrbConverter(DozerBeanMapper mapper) {
        super(mapper, Orb.class, OrbVo.class);
    }

}
