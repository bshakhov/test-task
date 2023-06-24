package com.flexit.spacetoursinc.service.impl;

import com.flexit.spacetoursinc.common.base.BaseServiceImpl;
import com.flexit.spacetoursinc.converter.HotelRoomConverter;
import com.flexit.spacetoursinc.dao.model.HotelRoom;
import com.flexit.spacetoursinc.dao.repository.HotelRoomRepository;
import com.flexit.spacetoursinc.api.dto.HotelRoomVo;
import com.flexit.spacetoursinc.service.HotelRoomService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class HotelRoomServiceImpl extends BaseServiceImpl<HotelRoom, HotelRoomVo> implements HotelRoomService {

    public HotelRoomServiceImpl(HotelRoomRepository repository, HotelRoomConverter converter) {
        super(repository, converter);
    }

}
