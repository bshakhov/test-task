package com.flexit.spacetoursinc.orb;

import com.flexit.spacetoursinc.common.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrbServiceImpl extends BaseServiceImpl<Orb, OrbVo> implements OrbService {

    public OrbServiceImpl(OrbRepository repository, OrbConverter converter) {
        super(repository, converter);
    }

}
