package com.flexit.spacetoursinc.travelpackage;

import com.flexit.spacetoursinc.common.base.AbstractConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class TravelPackageConverter extends AbstractConverter<TravelPackage, TravelPackageVo> {

    public TravelPackageConverter(DozerBeanMapper mapper) {
        super(mapper, TravelPackage.class, TravelPackageVo.class);
    }

}
