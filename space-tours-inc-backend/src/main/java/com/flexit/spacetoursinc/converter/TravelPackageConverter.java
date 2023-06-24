package com.flexit.spacetoursinc.converter;

import com.flexit.spacetoursinc.api.dto.TravelPackageVo;
import com.flexit.spacetoursinc.common.base.AbstractConverter;
import com.flexit.spacetoursinc.dao.model.TravelPackage;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class TravelPackageConverter extends AbstractConverter<TravelPackage, TravelPackageVo> {

    public TravelPackageConverter(DozerBeanMapper mapper) {
        super(mapper, TravelPackage.class, TravelPackageVo.class);
    }

}
