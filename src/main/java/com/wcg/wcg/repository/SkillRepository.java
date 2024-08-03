package com.wcg.wcg.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.wcg.wcg.entity.SkillEntity;

public interface SkillRepository extends CrudRepository<SkillEntity, UUID>, JpaSpecificationExecutor<SkillEntity> {
    
}
