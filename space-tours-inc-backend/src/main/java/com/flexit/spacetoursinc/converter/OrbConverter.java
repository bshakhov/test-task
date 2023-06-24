package com.flexit.spacetoursinc.converter;

import com.flexit.spacetoursinc.common.base.AbstractConverter;
import com.flexit.spacetoursinc.dao.model.Orb;
import com.flexit.spacetoursinc.api.dto.OrbVo;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class OrbConverter extends AbstractConverter<Orb, OrbVo> {

    public OrbConverter(DozerBeanMapper mapper) {
        super(mapper, Orb.class, OrbVo.class);
    }

}
