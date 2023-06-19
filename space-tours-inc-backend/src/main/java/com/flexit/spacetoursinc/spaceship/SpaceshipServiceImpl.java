package com.flexit.spacetoursinc.spaceship;

import com.flexit.spacetoursinc.common.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SpaceshipServiceImpl extends BaseServiceImpl<Spaceship, SpaceshipVo> implements SpaceshipService {

    public SpaceshipServiceImpl(SpaceshipRepository repository, SpaceshipConverter converter) {
        super(repository, converter);
    }

}
