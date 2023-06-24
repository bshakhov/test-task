package com.flexit.spacetoursinc.dao.repository;

import com.flexit.spacetoursinc.dao.model.SpaceshipService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpaceshipServiceRepository extends JpaRepository<SpaceshipService, UUID> {
}
