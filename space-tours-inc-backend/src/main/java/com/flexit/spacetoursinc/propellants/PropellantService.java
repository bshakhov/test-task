package com.flexit.spacetoursinc.propellants;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropellantService {

    List<PropellantListItemVo> findAll();

    PropellantVo findById(Integer id);

    List<PropellantVo> findAllDetails();

}
