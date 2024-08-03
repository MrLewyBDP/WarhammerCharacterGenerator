package com.wcg.wcg.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.wcg.wcg.entity.RaceEntity;

public interface RaceRepository extends CrudRepository<RaceEntity, UUID>, JpaSpecificationExecutor<RaceEntity> {
    
}
