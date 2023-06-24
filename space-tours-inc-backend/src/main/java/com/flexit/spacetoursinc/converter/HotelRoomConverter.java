package com.flexit.spacetoursinc.converter;

import com.flexit.spacetoursinc.common.base.AbstractConverter;
import com.flexit.spacetoursinc.dao.model.HotelRoom;
import com.flexit.spacetoursinc.api.dto.HotelRoomVo;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class HotelRoomConverter extends AbstractConverter<HotelRoom, HotelRoomVo> {

    public HotelRoomConverter(DozerBeanMapper mapper) {
        super(mapper, HotelRoom.class, HotelRoomVo.class);
    }

}
