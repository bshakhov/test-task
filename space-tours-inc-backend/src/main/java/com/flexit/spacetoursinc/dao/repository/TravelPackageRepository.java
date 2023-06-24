package com.flexit.spacetoursinc.dao.repository;

import com.flexit.spacetoursinc.dao.model.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TravelPackageRepository extends JpaRepository<TravelPackage, UUID> {
}
