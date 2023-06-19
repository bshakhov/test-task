package com.flexit.spacetoursinc.spaceship;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpaceshipRepository extends JpaRepository<Spaceship, UUID> {
}
