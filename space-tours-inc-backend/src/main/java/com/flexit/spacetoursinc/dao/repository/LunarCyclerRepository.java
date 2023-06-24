package com.flexit.spacetoursinc.dao.repository;

import com.flexit.spacetoursinc.dao.model.LunarCycler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LunarCyclerRepository extends JpaRepository<LunarCycler, UUID> {
}
