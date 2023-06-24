package com.flexit.spacetoursinc.converter;

import com.flexit.spacetoursinc.api.dto.LunarCyclerVo;
import com.flexit.spacetoursinc.common.base.AbstractConverter;
import com.flexit.spacetoursinc.dao.model.LunarCycler;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class LunarCyclerConverter extends AbstractConverter<LunarCycler, LunarCyclerVo> {

    public LunarCyclerConverter(DozerBeanMapper mapper) {
        super(mapper, LunarCycler.class, LunarCyclerVo.class);
    }

}
