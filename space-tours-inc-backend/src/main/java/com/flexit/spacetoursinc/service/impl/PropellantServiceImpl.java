package com.flexit.spacetoursinc.service.impl;

import com.flexit.spacetoursinc.api.dto.PropellantListItemVo;
import com.flexit.spacetoursinc.api.dto.PropellantVo;
import com.flexit.spacetoursinc.common.exception.StiBusinessException;

import com.flexit.spacetoursinc.client.PropellantClient;
import com.flexit.spacetoursinc.service.PropellantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.flexit.spacetoursinc.common.exception.BusinessErrorMessage.FETCHING_LIST_OF_PROPELLANTS;
import static com.flexit.spacetoursinc.common.exception.BusinessErrorMessage.FETCHING_SINGLE_PROPELLANT;

@Service
public class PropellantServiceImpl implements PropellantService {

    private final PropellantClient propellantClient;

    public PropellantServiceImpl(PropellantClient propellantClient) {
        this.propellantClient = propellantClient;
    }

    @Override
    public List<PropellantListItemVo> findAll() {
        return Optional.ofNullable(this.propellantClient.getAllPropellants())
                .orElseThrow(() -> new StiBusinessException(FETCHING_LIST_OF_PROPELLANTS.getErrorMessage()));
    }

    @Override
    public PropellantVo findById(Integer id) {
        return Optional.ofNullable(this.propellantClient.getPropellant(id))
                .orElseThrow(() -> new StiBusinessException(FETCHING_SINGLE_PROPELLANT.getErrorMessage()));
    }

    @Override
    public List<PropellantVo> findAllDetails() {
        return findAll().parallelStream()
                .map(p -> findById(p.getId()))
                .collect(Collectors.toList());
    }

}
