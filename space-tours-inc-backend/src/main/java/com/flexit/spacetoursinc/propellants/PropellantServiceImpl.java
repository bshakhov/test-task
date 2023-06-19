package com.flexit.spacetoursinc.propellants;

import com.flexit.spacetoursinc.common.exception.StiBusinessException;

import com.flexit.spacetoursinc.propellants.client.PropellantClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropellantServiceImpl implements PropellantService {

    private final PropellantClient propellantClient;

    public PropellantServiceImpl(PropellantClient propellantClient) {
        this.propellantClient = propellantClient;
    }

    @Override
    public List<PropellantListItemVo> findAll() {
        return Optional.ofNullable(this.propellantClient.getAllPropellants())
                .orElseThrow(() -> new StiBusinessException("Error fetching list of propellants"));
    }

    @Override
    public PropellantVo findById(Integer id) {
        return Optional.ofNullable(this.propellantClient.getPropellant(id))
                .orElseThrow(() -> new StiBusinessException("Error fetching a single propellant"));
    }

    @Override
    public List<PropellantVo> findAllDetails() {
        return findAll().parallelStream()
                .map(p -> findById(p.getId()))
                .collect(Collectors.toList());
    }

}
