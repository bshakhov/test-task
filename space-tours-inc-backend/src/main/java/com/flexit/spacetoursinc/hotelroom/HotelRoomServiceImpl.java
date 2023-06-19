package com.flexit.spacetoursinc.hotelroom;

import com.flexit.spacetoursinc.common.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class HotelRoomServiceImpl extends BaseServiceImpl<HotelRoom, HotelRoomVo> implements HotelRoomService {

    public HotelRoomServiceImpl(HotelRoomRepository repository, HotelRoomConverter converter) {
        super(repository, converter);
    }

}
