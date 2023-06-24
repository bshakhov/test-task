package com.flexit.spacetoursinc.converter;

import com.flexit.spacetoursinc.dao.model.Booking;
import com.flexit.spacetoursinc.api.dto.BookingVo;
import com.flexit.spacetoursinc.common.base.AbstractConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class BookingConverter extends AbstractConverter<Booking, BookingVo> {

    public BookingConverter(DozerBeanMapper mapper) {
        super(mapper, Booking.class, BookingVo.class);
    }

}
