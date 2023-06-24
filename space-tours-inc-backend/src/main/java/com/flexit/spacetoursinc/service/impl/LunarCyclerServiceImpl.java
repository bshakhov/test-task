package com.flexit.spacetoursinc.service.impl;

import com.flexit.spacetoursinc.api.dto.LunarCyclerVo;
import com.flexit.spacetoursinc.common.base.BaseServiceImpl;
import com.flexit.spacetoursinc.dao.model.LunarCycler;
import com.flexit.spacetoursinc.converter.LunarCyclerConverter;
import com.flexit.spacetoursinc.dao.repository.LunarCyclerRepository;
import com.flexit.spacetoursinc.service.LunarCyclerService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LunarCyclerServiceImpl extends BaseServiceImpl<LunarCycler, LunarCyclerVo> implements LunarCyclerService {

    public LunarCyclerServiceImpl(LunarCyclerRepository repository, LunarCyclerConverter converter) {
        super(repository, converter);
    }

}
