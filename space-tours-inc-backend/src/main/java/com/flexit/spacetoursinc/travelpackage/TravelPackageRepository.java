package com.flexit.spacetoursinc.travelpackage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TravelPackageRepository extends JpaRepository<TravelPackage, UUID> {
}
