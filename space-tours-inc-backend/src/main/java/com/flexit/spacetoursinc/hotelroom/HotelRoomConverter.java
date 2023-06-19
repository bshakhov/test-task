package com.flexit.spacetoursinc.hotelroom;

import com.flexit.spacetoursinc.common.base.AbstractConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class HotelRoomConverter extends AbstractConverter<HotelRoom, HotelRoomVo> {

    public HotelRoomConverter(DozerBeanMapper mapper) {
        super(mapper, HotelRoom.class, HotelRoomVo.class);
    }

}
