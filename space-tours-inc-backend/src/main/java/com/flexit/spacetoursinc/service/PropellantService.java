package com.flexit.spacetoursinc.service;

import com.flexit.spacetoursinc.api.dto.PropellantListItemVo;
import com.flexit.spacetoursinc.api.dto.PropellantVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropellantService {

    List<PropellantListItemVo> findAll();

    PropellantVo findById(Integer id);

    List<PropellantVo> findAllDetails();

}
