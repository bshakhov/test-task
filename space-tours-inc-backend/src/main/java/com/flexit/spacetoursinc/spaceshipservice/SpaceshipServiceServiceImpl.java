package com.flexit.spacetoursinc.spaceshipservice;

import com.flexit.spacetoursinc.common.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SpaceshipServiceServiceImpl extends BaseServiceImpl<SpaceshipService, SpaceshipServiceVo> implements SpaceshipServiceService {

    public SpaceshipServiceServiceImpl(SpaceshipServiceRepository repository, SpaceshipServiceConverter converter) {
        super(repository, converter);
    }

}
