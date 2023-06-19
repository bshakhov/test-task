package com.flexit.spacetoursinc.lunarcycler;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LunarCyclerRepository extends JpaRepository<LunarCycler, UUID> {
}
