package com.flexit.spacetoursinc.service.impl;

import com.flexit.spacetoursinc.common.base.BaseServiceImpl;
import com.flexit.spacetoursinc.converter.SpaceshipConverter;
import com.flexit.spacetoursinc.dao.model.Spaceship;
import com.flexit.spacetoursinc.dao.repository.SpaceshipRepository;
import com.flexit.spacetoursinc.service.SpaceshipService;
import com.flexit.spacetoursinc.api.dto.SpaceshipVo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SpaceshipServiceImpl extends BaseServiceImpl<Spaceship, SpaceshipVo> implements SpaceshipService {

    public SpaceshipServiceImpl(SpaceshipRepository repository, SpaceshipConverter converter) {
        super(repository, converter);
    }

}
