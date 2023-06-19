package com.flexit.spacetoursinc.travelpackage;

import com.flexit.spacetoursinc.common.base.BaseService;

import javax.annotation.Nonnull;
import java.time.LocalDate;
import java.util.List;

public interface TravelPackageService extends BaseService<TravelPackageVo> {

    @Nonnull
    List<TravelPackageAvailabilityVo> getAvailabilitiesByDate(LocalDate date);

}
