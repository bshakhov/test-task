package com.flexit.spacetoursinc.booking;

import com.flexit.spacetoursinc.common.base.BaseService;

import java.sql.Date;
import java.util.List;

public interface BookingService extends BaseService<BookingVo> {

    List<BookingVo> findByDepartureDateBetween(Date from, Date to);

}
