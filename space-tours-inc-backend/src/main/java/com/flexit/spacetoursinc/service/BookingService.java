package com.flexit.spacetoursinc.service;

import com.flexit.spacetoursinc.api.dto.BookingVo;
import com.flexit.spacetoursinc.common.base.BaseService;

import java.sql.Date;
import java.util.List;

public interface BookingService extends BaseService<BookingVo> {

    List<BookingVo> findByDepartureDateBetween(Date from, Date to);

}
