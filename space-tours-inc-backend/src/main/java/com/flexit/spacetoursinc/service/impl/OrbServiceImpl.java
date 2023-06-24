package com.flexit.spacetoursinc.service.impl;

import com.flexit.spacetoursinc.common.base.BaseServiceImpl;
import com.flexit.spacetoursinc.converter.OrbConverter;
import com.flexit.spacetoursinc.dao.model.Orb;
import com.flexit.spacetoursinc.dao.repository.OrbRepository;
import com.flexit.spacetoursinc.api.dto.OrbVo;
import com.flexit.spacetoursinc.service.OrbService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrbServiceImpl extends BaseServiceImpl<Orb, OrbVo> implements OrbService {

    public OrbServiceImpl(OrbRepository repository, OrbConverter converter) {
        super(repository, converter);
    }

}
