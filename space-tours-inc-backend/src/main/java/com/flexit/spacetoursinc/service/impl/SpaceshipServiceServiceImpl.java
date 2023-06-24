package com.flexit.spacetoursinc.service.impl;

import com.flexit.spacetoursinc.common.base.BaseServiceImpl;
import com.flexit.spacetoursinc.converter.SpaceshipServiceConverter;
import com.flexit.spacetoursinc.dao.model.SpaceshipService;
import com.flexit.spacetoursinc.dao.repository.SpaceshipServiceRepository;
import com.flexit.spacetoursinc.service.SpaceshipServiceService;
import com.flexit.spacetoursinc.api.dto.SpaceshipServiceVo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SpaceshipServiceServiceImpl extends BaseServiceImpl<SpaceshipService, SpaceshipServiceVo> implements SpaceshipServiceService {

    public SpaceshipServiceServiceImpl(SpaceshipServiceRepository repository, SpaceshipServiceConverter converter) {
        super(repository, converter);
    }

}
