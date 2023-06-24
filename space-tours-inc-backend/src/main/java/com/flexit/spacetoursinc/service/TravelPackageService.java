package com.flexit.spacetoursinc.service;

import com.flexit.spacetoursinc.api.dto.TravelPackageAvailabilityVo;
import com.flexit.spacetoursinc.api.dto.TravelPackageVo;
import com.flexit.spacetoursinc.common.base.BaseService;

import javax.annotation.Nonnull;
import java.time.LocalDate;
import java.util.List;

public interface TravelPackageService extends BaseService<TravelPackageVo> {

    @Nonnull
    List<TravelPackageAvailabilityVo> getAvailabilitiesByDate(LocalDate date);

}
